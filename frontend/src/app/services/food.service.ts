import { Injectable } from '@angular/core';
import { Food } from "../shared/models/Food";
import { Order2 } from "../shared/models/Order2";
import { Count } from "../shared/models/Count";
import {sample_tags} from "../../data";
import {Tag} from "../shared/models/Tag";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {
  FOOD_BY_ID_URL,
  FOODS_BY_SEARCH_URL,
  FOODS_BY_TAG_URL,
  FOODS_TAGS_URL,
  FOODS_URL
} from "../shared/constants/urls";

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private http:HttpClient) { }

  getAll(): Observable<Food[]>{
    return this.http.get<Food[]>(FOODS_URL);
  }

  getAllFoodsBySearchTerm(searchTerm: string) {
    return this.http.get<Food[]>(FOODS_BY_SEARCH_URL + searchTerm);
  }

  getAllTags(): Observable<Tag[]> {
    return this.http.get<Tag[]>(FOODS_TAGS_URL);
  }

  getAllFoodsByTag(tag: string): Observable<Food[]> {
    return tag === "All" ?
      this.getAll() :
      this.http.get<Food[]>(FOODS_BY_TAG_URL + tag);
  }

  getFoodById(foodId:string):Observable<Food>{
    return this.http.get<Food>(FOOD_BY_ID_URL + foodId);
  }

  getDishUser(page:string, size:string):Observable<Order2[]>{
      return this.http.get<Order2[]>('http://localhost:8080/api/users/report?page='+page+'&size='+size);
    }
  getTotalUser():Observable<Count[]>{
        return this.http.get<Count[]>('http://localhost:8080/api/users/report/total');
      }

   getrepdeli(page:string, size:string):Observable<Order2[]>{
        return this.http.get<Order2[]>('http://localhost:8080/api/delivery/report?page='+page+'&size='+size);
      }
}
