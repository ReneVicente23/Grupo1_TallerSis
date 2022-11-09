import { Injectable } from '@angular/core';
import { Food } from "../shared/models/Food";
import { Order2 } from "../shared/models/Order2";
import { Pagofav } from "../shared/models/Pagofav";
import { Tarjeta } from "../shared/models/Tarjeta";
import { TypePayment } from "../shared/models/TypePayment";
import { Count } from "../shared/models/Count";
import { Address } from "../shared/models/Address";
import { Saldoapp } from "../shared/models/Saldoapp";
import { Order } from '../shared/models/Order';
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


  getDishUser2(page:string, size:string, sort:string, filt:string):Observable<Order2[]>{
        return this.http.get<Order2[]>('http://localhost:8080/api/users/reporte?page='+page+'&size='+size+'&sort='+sort+'&filt='+filt);
      }


  getTotalUser():Observable<Count>{
        return this.http.get<Count>('http://localhost:8080/api/users/report/total');
      }

   getrepdeli(page:string, size:string):Observable<Order2[]>{
        return this.http.get<Order2[]>('http://localhost:8080/api/delivery/report?page='+page+'&size='+size);
      }


   getaddress():Observable<Address[]>{
          return this.http.get<Address[]>('http://localhost:8080/api/user/address');
        }

   updateaddress(address: Address){
       return this.http.post<Address>('http://localhost:8080/api/user/address/up', address);
     }

   updateorderpayment(order: Order){
          return this.http.put<Order>('http://localhost:8080/api/order/cash', order);
        }

    updateordertoCard(order: Order){
              return this.http.put<Order>('http://localhost:8080/api/order/card', order);
            }
    updateordertoPaypal(order: Order){
                  return this.http.put<Order>('http://localhost:8080/api/order/paypal', order);
                }

    gettopay():Observable<Order2[]>{
              return this.http.get<Order2[]>('http://localhost:8080/api/order/delivery/cash/pending');
            }
  updatepayorder(order2: Order2){
            return this.http.put<Order2>('http://localhost:8080/api/order/cash/pay', order2);
          }
  deladdress(address: Address){
         return this.http.put<Address>('http://localhost:8080/api/user/address/del', address);
       }

   getSaldoapp():Observable<Saldoapp>{
                return this.http.get<Saldoapp>('http://localhost:8080/api/user/saldoapp');
              }

  getPagofav():Observable<Pagofav>{
                  return this.http.get<Pagofav>('http://localhost:8080/api/user/pagofav');
  }

  updatepagofav(dato: string, pago: Pagofav){
         return this.http.post<Pagofav>('http://localhost:8080/api/user/pagofav/'+dato,pago);
       }

  getTarjeta():Observable<Tarjeta[]>{
                    return this.http.get<Tarjeta[]>('http://localhost:8080/api/user/cards');
    }
  postTarjeta(tarjeta: Tarjeta){
         return this.http.post<Tarjeta>('http://localhost:8080/api/user/cards/new', tarjeta);
       }
  borraTarjeta(tarjeta: Tarjeta){
           return this.http.put<Tarjeta>('http://localhost:8080/api/user/cards', tarjeta);
    }
  updateTarjeta(tarjeta: Tarjeta){
           return this.http.post<Tarjeta>('http://localhost:8080/api/user/cards', tarjeta);
         }
  gettippago(tipe: string):Observable<TypePayment>{
           return this.http.get<TypePayment>('http://localhost:8080/api/user/pagofav/type/'+tipe);
      }
}
