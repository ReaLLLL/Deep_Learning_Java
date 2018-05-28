package com.maowei.learning.redis;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {
    private static final Logger logger = Logger.getLogger(RedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id;
    private RedisTemplate redisTemplate;
    //private static final long EXPIRE_TIME_IN_MINUTES = 30;

    public RedisCache(String id){
        if(id == null)
            throw new IllegalArgumentException("Cache instance requires an ID");

        this.id = id;
        logger.info(id);
    }

    public String getId() {
        return this.id;
    }

    private RedisTemplate getRedisTemplate() {
        if(null == this.redisTemplate){
            logger.debug("set redisTemplate");
            this.redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }
        return this.redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void putObject(Object key, Object value) {
        HashOperations opsForHash = this.getRedisTemplate().opsForHash();
        opsForHash.put(this.getId(),key, value);
        //opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        logger.debug("Put query result to redis");
    }

    public Object getObject(Object key) {
        HashOperations opsForHash = this.getRedisTemplate().opsForHash();
        logger.debug("Get cached query result from redis");
        return opsForHash.get(this.getId(),key);
    }

    public Object removeObject(Object key) {
        HashOperations opsForHash = this.getRedisTemplate().opsForHash();
        opsForHash.delete(this.getId(),key);
        logger.debug("Remove cached query result from redis");
        return key;
    }

    public void clear() {
        this.getRedisTemplate().delete(this.getId());
        /*this.getRedisTemplate().execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                logger.debug("flush redis");
                redisConnection.flushDb();
                return null;
            }
        });*/
    }

    public int getSize() {
        return 0;
    }

    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
