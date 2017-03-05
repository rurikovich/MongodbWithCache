import {ApiClient} from "./ApiClient";
export class ApiClientService {

    clients: ApiClient[] = [
        {id: "id111", privateKey: "wsewdwe", allowedUrls: ["/api1", "/api2"]},
        {id: "id2222", privateKey: "wsewdwe", allowedUrls: ["/api1", "/api2"]}
    ];


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