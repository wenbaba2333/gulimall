package com.atguigu.gulimall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class MyRedissonConfig {

    /**
     * 所有对Redisson的使用都是通过对RedissonClient对象
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod="shutdown")
    RedissonClient redisson() throws IOException {
        // 1. 创建配置
        Config config = new Config();
//        config.useClusterServers()
//              .addNodeAddress("redis://127.0.0.1:7004", "redis://127.0.0.1:7001");
        config.useSingleServer().setAddress("redis://10.0.0.23:6379");
        // 2。 根据Config创建出RedissonClient实例
        return Redisson.create(config);
    }
}
