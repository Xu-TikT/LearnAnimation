package com.tikt.mathmeetsanimation.ui.mvpdemo;

/**
 * Created by tikt on 16-8-15.
 * TaskDataSourceImpl.java 是数据层，直接负责数据获取，无论是从api获得，还是从本地数据库读取数据，本质上都是IO操作。
 */
public class TaskDataSourceImpl implements TaskDataSource{
	@Override
	public String getStringFromRemote() {
		return "Hello ";
	}

	@Override
	public String getStringFromCache() {
		return "world ";
	}
}
