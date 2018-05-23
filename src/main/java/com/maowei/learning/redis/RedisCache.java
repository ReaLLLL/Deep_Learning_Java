package com.maowei.learning.redis;

import com.ibatis.sqlmap.engine.cache.CacheController;
import com.ibatis.sqlmap.engine.cache.CacheModel;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Properties;

public class RedisCache implements CacheController{
    private static final Logger logger = Logger.getLogger(RedisCache.class);

    private RedisTemplate redisTemplate;

    public void flush(CacheModel cacheModel) {
        this.redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                logger.debug("flush redis");
                redisConnection.flushDb();
                return null;
            }
        });
    }

    public Object getObject(CacheModel cacheModel, Object o) {
        return null;
    }

    public Object removeObject(CacheModel cacheModel, Object o) {
        return null;
    }

    public void putObject(CacheModel cacheModel, Object o, Object o1) {

    }

    public void configure(Properties properties) {

    }
}
