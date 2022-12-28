package com.airportService.backend.services;

import com.airportService.backend.repositories.RedisSessionFactory;
import com.airportService.backend.models.Role;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

@Service
public class UserServiceImpl implements UserService {
    public void set(Role role, String password) {
        Jedis redis = RedisSessionFactory.getRedisDB();
        Transaction multi = redis.multi();
        multi.set(role.name(), password);
        multi.exec();
    }

    public Response<String> getPassword(Role role) {
        Jedis redis = RedisSessionFactory.getRedisDB();
        Transaction multi = redis.multi();
        Response<String> password = multi.get(role.name());
        multi.exec();
        return password;
    }

    public void delete(Role role) {
        Jedis redis = RedisSessionFactory.getRedisDB();
        Transaction multi = redis.multi();
        multi.del(role.name());
        multi.exec();
    }
}
