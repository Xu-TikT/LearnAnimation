package com.tikt.mathmeetsanimation.ui.mvpdemo;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by tikt on 16-8-15.
 * 可以看到 Presenter 层是连接 Model 层和 View 层的中间层，因此持有 View 层的接口和 Model 层的接口。
 */
public class MainPresenter {


	MainView mainView;
	TaskManager taskData;

	public MainPresenter(){
		this.taskData = new TaskManager(new TaskDataSourceImpl());
	}

	public MainPresenter test(){
		this.taskData = new TaskManager(new TaskDataSourceTestImpl());
		return this;
	}

	public MainPresenter addTaskListener(MainView viewListener){
		this.mainView = viewListener;
		return this;
	}
	public void getString(){
		/**
		 * 到现在为止一个基于 MVP 简单框架就搭建完成了，但其实还遗留了一个比较大的问题:
		 *      Android 规定，主线程是无法直接进行网络请求,会抛出 NetworkOnMainThreadException 异常
		 *
		 *我们回到 Presenter 层，看看这里的调用:
		 * 因为 presenter 层并不知道业务层以及数据层到底是从网络获取数据，还是从本地获取数据（符合层级间相互透明的原则），
		 * 因为每次调用都可能存在触发这个问题。并且我们知道，即使是从本地获取数据，
		 * 一次简单的IO访问也要消耗10MS左右。因此多而复杂的IO可能会直接引发页面的卡顿。
		 *
		 *
		 */

		/*
		String str = taskData.getShowContent();
		mainView.onShowString(str);
		*/

		/*
		Android 本身提供一些方案，比如下面这种.
		通过新建子线程进行IO读写获取数据，然后通过主线程的 Looper 将结果通过传回主线程进行渲染和展示。
		但每个调用都这样写，首先是新建线程会增加额外的成功，其次就是代码看起来很难读，缩进太多。
		好在有了 RxJava ,可以比较方便的解决这个问题。

		final Handler mainHandler = new Handler(Looper.getMainLooper());
		new Thread(){
			@Override
			public void run() {
				super.run();
				final String str = taskData.getShowContent();
				mainHandler.post(new Runnable() {
					@Override
					public void run() {
						mainView.onShowString(str);
					}
				});
			}
		}.start();
		*/

		/**
		 * 使用RxJava来解决主线程发出网络请求的问题
		 * RxJava 是一个天生用来做异步的工具，相比 AsyncTask, Handler 等，它的优点就是简洁，无比的简洁。
		 * 在 Android 中使用 RxJava 需要加入下面两个依赖：
		 * compile 'io.reactivex:rxjava:1.0.14'
		 * compile 'io.reactivex:rxandroid:1.0.1'
		 * 这里我们直接介绍如何使用 RxJava 解决这个问题，直接在 presenter 中修改调用方法 getString
		 */

		Func1 dataAction = new Func1<String,String>() {
			@Override
			public String call(String param) {
				return taskData.getShowContent();
			}
		};

		Action1 viewAction = new Action1<String>() {
			@Override
			public void call(String str) {
				mainView.onShowString(str);
			}
		};

		/**
		 * 简单说明一下，与业务数据层的交互被定义到 Action1 里，然后交由 rxJava，指定 Schedulers.io() 获取到的线程来执行。
		 * Shedulers.io() 是专门用来进行IO访问的线程，并且线程会重复利用，不需要额外的线程管理。
		 * 而数据返回到 View 层的操作是在 Action1 中完成，由 rxJava 交由 AndroidSchedulers.mainThread() 指定的UI主线程来执行。
		 *
		 * 从代码量上来讲，似比上一种方式要更多了，但实际上，当业务复杂度成倍增加的时候，RxJava 可以采用这种链式编程方式随意的增加调用和返回，
		 * 而实现方式要比前面的方法灵活得多，简洁得多。
		 */
		Observable.just("")
				.observeOn(Schedulers.io())
				.map(dataAction)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(viewAction);

		/*
		至此为止，通过 MVP+RxJava 的组合，我们已经构建出一个比较灵活的 Android 项目框架，总共分成了四部分：View 层，Presenter 层，Model 业务层，Data 数据持久化层。
		这个框架的优点大概有以下几点:
        1.每层各自独立，通过接口通信
        2.实现与接口分离，不同场景（正式，测试）可以挂载不同的实现，方便测试和开发写假数据
        3.所有的业务逻辑都在非UI线程中进行，最大限度减少IO操作对UI的影响
        4.使用 RxJava 可以将复杂的调用进行链式组合，解决多重回调嵌套问题
        */

	}
}
