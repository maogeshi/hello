package com.atguigu.scw.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.atguigu.scw.common.templates.OssTemplate;
@Configuration
public class AppConfig {
	
	//注入Oss模板类	
	@ConfigurationProperties(prefix="oss")
	@Bean
	public OssTemplate getOssTemplate() {
		return new OssTemplate();
	}
	
	//密码处理器
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
