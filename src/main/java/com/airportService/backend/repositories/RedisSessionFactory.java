package com.airportService.backend.repositories;
import redis.clients.jedis.Jedis;

public class RedisSessionFactory {
    private static Jedis redis;
    public static Jedis getRedisDB() {
        if(redis == null) {
            try {
                redis = new Jedis("localhost", 6379);
            }catch (Exception e) {
                System.out.println("redis error");
            }
        }
        return redis;
    }
}
