package com.tikt.mathmeetsanimation.ui.mvpdemo;

/**
 * Created by tikt on 16-8-15.
 */
public class TaskDataSourceTestImpl implements TaskDataSource{
	@Override
	public String getStringFromRemote() {
		return "Hello ";
	}

	@Override
	public String getStringFromCache() {
		return "world Test";
	}
}
