package top.auzqy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * description:
 * <h1>网关应用程序</h1>
 * EnableZuulProxy: 标识当前的应用是 Zuul Server
 * SpringCloudApplication: 用于简化配置的组合注解
 *
 * createTime: 2019-12-17 15:25
 * @author au
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
