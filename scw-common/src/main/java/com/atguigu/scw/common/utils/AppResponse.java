package com.atguigu.scw.common.utils;

import java.io.Serializable;

import com.atguigu.scw.common.consts.AppConsts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse<T> implements Serializable{
	//响应状态码 10000为成功 10001为失败
	private int code;
	//响应信息：描述本次响应状态
	private String message;
	//响应数据
	private T data;
	
	//响应成功的方法
	public static <T> AppResponse<T> ok(T data,String message){
		return new AppResponse<T>(AppConsts.SUCCESS_CODE,message,data);//封装响应状态+响应信息+响应数据
	}
	//响应失败的方法
	public static <T> AppResponse<T> fail(T data,String message){
		return new AppResponse<T>(AppConsts.ERROR_CODE,message,data);//封装响应状态+响应信息+响应数据
	}
}
