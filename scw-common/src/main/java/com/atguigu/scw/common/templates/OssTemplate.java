package com.atguigu.scw.common.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.eclipse.jetty.util.MultiPartInputStreamParser.MultiPart;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OssTemplate {
	
	String scheme;
	// Endpoint以杭州为例，其它Region请按实际情况填写。
	String endpoint;
	// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
	String accessKeyId;
	String accessKeySecret;
	String bucketName;
	String imgsDir;
	
	
	//MultipartFile代表上传的一个文件，代表上传的文件信息【文件大小文件名文件流】
	public String upLoadImg(MultipartFile multipartfile) throws Exception {

		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(scheme+endpoint, accessKeyId, accessKeySecret);
		//File file = new File("C:\\Users\\Administrator\\Desktop\\1.png");
		// 上传文件流。
		//InputStream inputStream = new FileInputStream(file);
		InputStream inputStream = multipartfile.getInputStream();//获取上传文件的文件流
		String filename = System.currentTimeMillis()+"_"+UUID.randomUUID().toString().replace("-", "")+"_"+multipartfile.getOriginalFilename();
		ossClient.putObject(bucketName, imgsDir+filename, inputStream);
		String filname = scheme+bucketName+"."+endpoint+"/"+imgsDir+filename;
		//log.info("图片上传成功的地址：{}",filname);
		// 关闭OSSClient。
		ossClient.shutdown();
		return filname;
		
	}
	
	
}
