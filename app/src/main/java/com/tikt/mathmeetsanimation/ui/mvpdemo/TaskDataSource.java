package com.tikt.mathmeetsanimation.ui.mvpdemo;

/**
 * Created by tikt on 16-8-15.
 * data 层接口定义
 * TaskDataSource.java 作为数据层对外的接口,
 */
public interface TaskDataSource {


	String getStringFromRemote();
	String getStringFromCache();
}
