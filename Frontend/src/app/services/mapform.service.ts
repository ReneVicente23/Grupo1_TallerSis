import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/user/address';

@Injectable({
  providedIn: 'root'
})
export class MapformService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(baseUrl);
  }
  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }
  delete(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
}
