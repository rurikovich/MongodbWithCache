package ru.sovcombank.openapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sovcombank.openapi.pojo.ApiClient;

/**
 * Created by rurik on 02/03/17.
 */
public interface ApiClientRepository extends MongoRepository<ApiClient, String> {


    public ApiClient findById(String id);

}
