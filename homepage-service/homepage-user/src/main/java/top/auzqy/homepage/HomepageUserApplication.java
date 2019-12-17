package top.auzqy.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * description:  <h1>用户服务启动入口</h1>
 * createTime: 2019-12-17 18:11
 * @author au
 */
@EnableJpaAuditing
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class HomepageUserApplication {

    public static void main(String[] args) {

        SpringApplication.run(HomepageUserApplication.class, args);
    }
}
