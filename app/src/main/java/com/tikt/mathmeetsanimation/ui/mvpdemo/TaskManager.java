package com.tikt.mathmeetsanimation.ui.mvpdemo;

/**
 * Created by tikt on 16-8-15.
 *  从数据层获取的数据，在这里进行拼装和组合
 *  TaskManager 是作为业务层，对获取到的数据进行拼装，然后交给调用层。
 *  首先来讲业务层 TaskManager，业务层的上层是 View 层，下层是 Data 层。
 *  在这个类里，只有一个 Data 层的接口，所以业务层是不关心数据是如何取得，只需要通过接口获得数据之后，
 *  对原始的数据进行组合和拼装。因为完全与其上层和下层分离，所以我们在测试的时候，可以完全独立的是去测试业务层的逻辑。
 */
public class TaskManager {


	TaskDataSource dataSource;
	/*
	TaskManager 中的 construct 方法的参数是数据层接口，这意味着我们可以给业务层注入不同的数据层实现。
	正式线上发布的时候注入 TaskDataSourceImpl 这个实现，在测试业务层逻辑的时候，注入 TaskDataSourceTestImpl.java 实现。
	这也正是使用接口来处理每个层级互相通信的好处，可以根据使用场景的不用，使用不同的实现.
	 */
	public TaskManager(TaskDataSource dataSource){

		this.dataSource = dataSource;

	}

	public String getShowContent(){
		// do what you want do on the original data
		return dataSource.getStringFromRemote()+dataSource.getStringFromCache();
	}

}
