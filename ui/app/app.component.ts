import {Component, OnInit} from '@angular/core';
import {Response} from '@angular/http';
import {ApiClient} from "./ApiClient";
import {ApiClientService} from "./api-client.service";

@Component({
    selector: 'my-app',
    templateUrl: 'app/app.component.html',
    providers: [ApiClientService]
})
export class AppComponent implements OnInit {

    clients: ApiClient[] = [];
    json: string = "1";

    constructor(private dataService: ApiClientService) {
    }

    addApiClient(id: string, privateKey: string) {
        this.dataService.addApiClient(id, privateKey);
    }

    ngOnInit() {
        // this.clients = this.dataService.getApiClients();
        // this.dataService.fetchFirstApiClient().subscribe((data: Response) => this.clients.push(data.json()))

        // this.dataService.fetchFirstApiClient().subscribe((data: Response) => {
        //     console.log("Friends are being called");
        //     this.json = "data"
        // });

        this.dataService.fetchFirstApiClient()
            .subscribe((resp: Response) => {
                let client = resp.json().data;
                // for (let index in clientsList) {
                console.log(client);
                this.json += client.id + '_';

                // this.clients.push(new ApiClient(client.id, client.privateKey));
                // }
            });


    }
}