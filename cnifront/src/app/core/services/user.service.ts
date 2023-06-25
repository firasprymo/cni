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

  getUser(id: number) {
    return this.httpClient.get(`${environment.apiUrl}${environment.users}/${id}`);
  }

  deleteUser(id: number) {
    return this.httpClient.delete(`${environment.apiUrl}${environment.users}/${id}`);
  }

  addUser(user: any) {
    return this.httpClient.post(`${environment.apiUrl}${environment.users}/`, user);
  }

  editUser(id: number, user: any) {
    return this.httpClient.patch(`${environment.apiUrl}${environment.users}/${id}`, user);
  }
}
