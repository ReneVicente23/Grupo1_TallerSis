import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/user/address';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }


  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }
  getAll(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/user/2/address/');
  }
}
