package ru.sovcombank.openapi.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sovcombank.openapi.pojo.ApiClient;

import java.util.List;

/**
 * Created by rurik on 02/03/17.
 */
@CacheConfig(cacheNames = "apiclients")
public interface ApiClientRepository extends MongoRepository<ApiClient, String> {

    @Cacheable
    ApiClient findById(String id);

    @Cacheable
    List<ApiClient> findAll();

    @CacheEvict(allEntries = true)
    default void resetApiClientCache() {
    }
}
