package com.feidian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }


    /**
     * 配置上传文件大小的配置
     *
     * @return
     */
    /*@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  设置单个文件大小
        factory.setMaxFileSize(DataSize.parse("102400KB"));//KB 或者 MB 都可以 1MB=1024KB。1KB=1024B(字节)
        /// 设置总上传文件大小
        factory.setMaxRequestSize(DataSize.parse("102400KB"));//KB 或者 MB 都可以 1MB=1024KB。1KB=1024B(字节)
        return factory.createMultipartConfig();
    }*/

}
