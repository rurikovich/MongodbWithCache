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