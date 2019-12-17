package top.auzqy.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description:  <h1>测试用例启动入口</h1>
 * createTime: 2019-12-17 22:52
 * @author au
 */
@EnableFeignClients(basePackages = {"top.auzqy.homepage"})
@SpringBootApplication
public class HomepageUserApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(HomepageUserApplicationTest.class, args);
    }
}
