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

    constructor(private dataService: ApiClientService) {
    }

    addApiClient(id: string, privateKey: string) {
        this.dataService.addApiClient(id, privateKey);
    }

    ngOnInit() {
        this.dataService.fetchApiClients()
            .subscribe((resp: Response) => {
                this.clients = resp.json();
            });


    }
}