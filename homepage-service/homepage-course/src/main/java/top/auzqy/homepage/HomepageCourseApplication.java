package top.auzqy.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * description:  <h1>SpringBoot 启动入口</h1>
 * createTime: 2019-12-17 16:31
 * @author au
 */
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class HomepageCourseApplication {

    public static void main(String[] args) {

        SpringApplication.run(HomepageCourseApplication.class, args);
    }
}