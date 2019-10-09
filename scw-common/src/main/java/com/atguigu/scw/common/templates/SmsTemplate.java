package com.atguigu.scw.common.templates;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.atguigu.scw.common.utils.HttpUtils;
@Component
public class SmsTemplate {
	
//	@Value("${sms.host}") //只能在组件中使用
	private String host;
	//@Value("${sms.path}") 
	private String path;
	//@Value("${sms.method}") 
	private String method;
	//@Value("${sms.appcode}") 
	private String appcode;
	//发送短信的方法
	public boolean sendSms(Map<String, String> querys) {
		
		//测试短信平台
//		   String host = "http://dingxin.market.alicloudapi.com";
//		    String path = "/dx/sendSms";
//		    String method = "POST";
//		    String appcode = "3d3a5edbc6a24613b4c2e09aa1b8273011";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
//		    Map<String, String> querys = new HashMap<String, String>();
//		    querys.put("mobile", "13858164468");
//		    querys.put("param", "code:1234");
//		    querys.put("tpl_id", "TP1711063");
		    Map<String, String> bodys = new HashMap<String, String>();


		    try {
		    	/**
		    	* 重要提示如下:
		    	* HttpUtils请从
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		    	* 下载
		    	*
		    	* 相应的依赖请参照
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		    	*/
		    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
		    	return true;
		    	//System.out.println(response.toString());
		    	//获取response的body
		    	//System.out.println(EntityUtils.toString(response.getEntity()));
		    } catch (Exception e) {
		    	e.printStackTrace();
		    	return false;
		    }
	}
	
}
