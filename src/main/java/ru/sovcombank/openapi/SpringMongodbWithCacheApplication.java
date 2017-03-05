package ru.sovcombank.openapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import ru.sovcombank.openapi.repositories.ApiClientRepository;

@EnableCaching
@SpringBootApplication
public class SpringMongodbWithCacheApplication implements CommandLineRunner {

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
        cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cmfb.setShared(true);
        return cmfb;
    }

    @Autowired
    ApiClientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbWithCacheApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//        ArrayList urls = new ArrayList<String>();
//        urls.add("/api1");
//        Random randomazer = new Random();
//        for (int i = 0; i < 100; i++) {
//            int random = randomazer.nextInt();
//            String id = "id" + random;
//            repository.save(new ApiClient(id, "asa", urls));
//            System.out.println(repository.findAll().size());
////            Thread.currentThread().sleep(400);
//        }
//
//        repository.resetApiClientCache();
//        System.out.println(repository.findAll().size());
    }

}
