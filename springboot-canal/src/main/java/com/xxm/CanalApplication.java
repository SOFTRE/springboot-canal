package com.xxm;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 描述
 *
 * @author Mr Liu
 * @version 1.0
 * @package com.xxm *
 * @Date 2019-11-26
 * @since 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除掉
@EnableEurekaClient
@EnableCanalClient//启用客户端注解生效
public class CanalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }
}
