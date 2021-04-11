package com.learn.initiative.store.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.initiative.store.model.dto.Category;
import com.learn.initiative.store.model.dto.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfiguration {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        ObjectMapper mapper = new ObjectMapper();
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer(mapper));
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        return template;
    }

    @Bean
    public RedisCacheManager redisCacheManager(JedisConnectionFactory jedisConnectionFactory) {

        ObjectMapper mapper = new ObjectMapper();

        var cacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.fromSerializer(new GenericJackson2JsonRedisSerializer(mapper)).getValueSerializationPair())
                .serializeKeysWith(RedisSerializationContext.fromSerializer(new StringRedisSerializer()).getKeySerializationPair());

        RedisCacheWriter cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(jedisConnectionFactory);
        return RedisCacheManager.builder()
                .enableStatistics()
                .cacheWriter(cacheWriter)
                .cacheDefaults(cacheConfiguration)
                .build();
    }

    @Bean
    public Jackson2JsonRedisSerializer<Category> defaultCategoryRedisSerializer() {
        return new Jackson2JsonRedisSerializer<>(Category.class);
    }

    @Bean
    public Jackson2JsonRedisSerializer<Product> defaultProductRedisSerializer() {
        return new Jackson2JsonRedisSerializer<>(Product.class);
    }


}
