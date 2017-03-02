package ru.sovcombank.openapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sovcombank.openapi.pojo.ApiClient;
import ru.sovcombank.openapi.repositories.ApiClientRepository;

import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
public class SpringMongodbWithCacheApplication implements CommandLineRunner {

    @Autowired
    ApiClientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbWithCacheApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ArrayList urls = new ArrayList<String>();
        urls.add("/api1");
        String id = "id" + new Random().nextInt();
        repository.save(new ApiClient(id, "derd", urls));
        ApiClient apiClient = repository.findById(id);
    }

}
