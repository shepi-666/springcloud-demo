package com.example.clients.fallback;

import com.example.clients.UserClient;
import com.example.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    /**
     * 编写降级的逻辑
     * @param throwable
     * @return
     */
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
                log.error("查询用户异常，请检查用户Id", throwable);
                return new User();
            }
        };
    }
}
