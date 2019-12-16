package top.auzqy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description:  eureka 的入口启动类
 *
 * 1. 只需要使用 @EnableEurekaServer 注解就可以让应用变为 Eureka Server
 * 2. pom 文件中对应到 spring-cloud-starter-netflix-eureka-server
 *
 * createTime: 2019-12-16 18:25
 * @author au
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
