import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  getAllUsers() {
    return this.httpClient.get(`${environment.apiUrl}${environment.users}/`);
  }

  deleteUser(id: number) {
    return this.httpClient.delete(`${environment.apiUrl}${environment.users}/${id}`);
  }
}
