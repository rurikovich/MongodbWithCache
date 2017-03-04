import {Component} from '@angular/core';


export class ApiClient {
    id: String;
    privateKey: String;
    allowedUrls: String[];


    constructor(id: String, privateKey: String, allowedUrls?: String[]) {
        this.id = id;
        this.privateKey = privateKey;
        this.allowedUrls = allowedUrls;
    }


}

@Component({
    selector: 'my-app',
    template: `<div class="page-header">
        <h1>Клиенты Api</h1>
    </div>
    <div class="panel">
        <div class="form-inline">
            <div class="form-group">
                <div class="col-md-8">
                    <input class="form-control" [(ngModel)]="id" placeholder = "Id" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input  class="form-control" [(ngModel)]="privateKey" placeholder="Секретный ключ" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-8">
                    <button class="btn btn-default" (click)="addApiClient(id, privateKey)">Добавить</button>
                </div>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Секретный ключ</th>
                    <th>Список разрешенных адресов</th>
                </tr>
            </thead>
            <tbody>
                <tr *ngFor="let client of clients">
                    <td>{{client.id}}</td>
                    <td>{{client.privateKey}}</td>
                    <td>{{client.allowedUrls}}</td>
                </tr>
            </tbody>
        </table>
    </div>`
})
export class AppComponent {
    clients: ApiClient[] = [
        {id: "id1", privateKey: "wsewdwe", allowedUrls: ["/api1", "/api2"]},
        {id: "id2", privateKey: "wsewdwe", allowedUrls: ["/api1", "/api2"]}
    ];

    addApiClient(id: string, privateKey: string): void {
        if (id == null || id == undefined || id.trim() == "")
            return;
        if (privateKey == null || privateKey == undefined)
            return;
        this.clients.push(new ApiClient(id, privateKey));
    }


}