package com.atguigu.scw.common.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

//需要使用accessToken的类的父类
@Data
@ToString
public class BaseVo implements Serializable{
	 private String accessToken; //用户登录成功的token
}
