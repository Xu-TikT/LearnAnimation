package com.tikt.mathmeetsanimation.retrofitInterface;

import com.tikt.mathmeetsanimation.entity.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by tikt on 16-7-27.
 * 这只是一个例子
 */
public interface RetrofitTest {

	/**
	 * 该接口定义了一个函数 listRepos,该函数会通过HTTP GET
	 * 请求去访问服务器的/users/{user}/repos路径并把返回的结果封装为
	 * List<Repo> Java对象返回。
	 * 其中URL路径中的{user}的值为listRepos 函数中的参数 user的取值。
	 *
	 * 请求方式:
	 *  每个函数都必须带有 HTTP 注解来表明请求方式和请求的URL路径。类库中有5个HTTP注解:GET, POST, PUT,DELETE和HEAD。
	 *  注解中的参数为请求的相对URL路径。
	 *  在URL路径中也可以指定URL参数:@GET("/users/list?sort=desc")
	 *
	 * URL处理:
	 *  请求的URL可以根据函数参数动态更新。一个可替换的区块为用 { 和 } 包围的字符串，
	 *  而函数参数必需用 @Path注解标明，并且注解的参数为同样的字符串
	 * e.g:
	 *  \@GET("/group/{id}/users") //注意 字符串id
	 *   List<User> groupList(@Path("id") int groupId); //注意 Path注解的参数要和前面的字符串一样 id
	 *
	 * 还支持查询参数:
	 *  \@GET("/group/{id}/users")
	 *  List<User> groupList(@Path("id") int groupId, @Query("sort") String sort);
	 * 复杂的参数查询可以使用map:
	 *  \@GET("group/{id}/users")
	 *  Call<List<User>> groupList(@Path("id") int groupId, @QueryMap Map<String, String> options);
	 *
	 * 请求体（Request Body）:
	 *  通过@Body注解可以声明一个对象作为请求体发送到服务器。
	 *  \@POST("/users/new")
	 *  void createUser(@Body User user, Callback<User> cb);
	 *  对象将被RestAdapter使用对应的转换器转换为字符串或者字节流提交到服务器。
	 *  如果没有添加转化器，则只有 RequestBody能被只用
	 *
	 * 函数也可以注解为发送表单数据和multipart 数据
	 *  使用@FormUrlEncoded注解来发送表单数据；
	 *  使用@Field 注解和参数来指定每个表单项的Key，value为参数的值。
	 *  \@FormUrlEncoded
	 *   \@POST("user/edit")
	 *   Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */

		@GET("users/{user}/repos")
		Call<List<Repo>> listRepos(@Path("user") String user);
}
