import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {ApiClient} from "./ApiClient";

@Injectable()
export class ApiClientService {

    clients: ApiClient[] = [
        {id: "id111", privateKey: "wsewdwe", allowedUrls: ["/api1", "/api2"]},
        {id: "id2222", privateKey: "wsewdwe", allowedUrls: ["/api1", "/api2"]}
    ];

    constructor(private http: Http){ }

    fetchApiClients(){
        let data = this.http.get('http://localhost:8080/apiclients');
        return data;
    }

    fetchFirstApiClient(){
        let data = this.http.get('/apiclient');
        return data;
    }


    getApiClients(): ApiClient[] {
        return this.clients;
    }

    addApiClient(id: string, privateKey: string): void {
        if (id == null || id == undefined || id.trim() == "")
            return;
        if (privateKey == null || privateKey == undefined)
            return;
        this.clients.push(new ApiClient(id, privateKey));
    }
}