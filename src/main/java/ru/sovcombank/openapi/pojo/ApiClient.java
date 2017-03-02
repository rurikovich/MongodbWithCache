package ru.sovcombank.openapi.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rurik on 02/03/17.
 */
public class ApiClient implements Serializable {

    @Id
    private String id;
    private String privateKey;
    private List<String> allowedUrls;

    public ApiClient(String id, String privateKey, List<String> allowedUrls) {
        this.id = id;
        this.privateKey = privateKey;
        this.allowedUrls = allowedUrls;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public List<String> getAllowedUrls() {
        return allowedUrls;
    }

    public void setAllowedUrls(List<String> allowedUrls) {
        this.allowedUrls = allowedUrls;
    }
}
