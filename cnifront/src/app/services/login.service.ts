import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {environment} from "../../environments/environment";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  constructor(private http: HttpClient) { }

  login(credentials:any): Observable<any> {
    return this.http.post(environment.apiUrl+'auth/signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(user:any): Observable<any> {
    return this.http.post(environment.apiUrl + 'auth/signup', {
      username: user.username,
      email: user.email,
      password: user.password
    }, httpOptions);
  }
}
