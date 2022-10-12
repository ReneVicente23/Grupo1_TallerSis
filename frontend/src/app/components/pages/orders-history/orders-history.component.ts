import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Order2 } from 'src/app/shared/models/Order2';
import { Count } from 'src/app/shared/models/Count';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-orders-history',
  templateUrl: './orders-history.component.html',
  styleUrls: ['./orders-history.component.css']

})
export class OrdersHistoryComponent implements OnInit {

  order2s: Order2[] = [];
  count!: Count;
  mypage: number = 0;
  mylengt: number = 20;
  mysort: number = 6;
  myfil: number = 200;
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) {

   }


  ngOnInit(): void {
    this.retrieveDish();
    this.llenacount();
  }

  retrieveDish(): void {
        this.foodService.getDishUser('0','20')
          .subscribe(
            data => {
              this.order2s = data;
              console.log(this.order2s);
              console.log('la logramo');
            },
            error => {
              console.log(error);
            });
      }
   nextpage(): void {
            this.mypage=this.mypage+1;
           this.foodService.getDishUser2(this.mypage+'',this.mylengt+'',this.mysort+'',this.myfil+'')
             .subscribe(
               data => {
                 this.order2s = data;
                 console.log(this.order2s);
                 console.log('la logramo');
               },
               error => {
                 console.log(error);
               });
         }
   prevpage(): void {
               this.mypage=this.mypage-1;
              this.foodService.getDishUser2(this.mypage+'',this.mylengt+'',this.mysort+'',this.myfil+'')
                .subscribe(
                  data => {
                    this.order2s = data;
                    console.log(this.order2s);
                    console.log('la logramo');
                  },
                  error => {
                    console.log(error);
                  });
            }
   limitador(num:number): void {
                  this.myfil = num;
                  console.log(this.mypage);
                  console.log(this.mylengt);
                  console.log(this.mysort);
                  console.log(this.myfil);
                 this.foodService.getDishUser2(this.mypage+'',this.mylengt+'',this.mysort+'',this.myfil+'')
                   .subscribe(
                     data => {
                       this.order2s = data;
                       console.log(this.order2s);
                       console.log('la logramo');
                     },
                     error => {
                       console.log(error);
                     });
               }
   ordenar(nume:number): void {
                     this.mysort = nume;
                    this.foodService.getDishUser2(this.mypage+'',this.mylengt+'',this.mysort+'',this.myfil+'')
                      .subscribe(
                        data => {
                          this.order2s = data;
                          console.log(this.order2s);
                          console.log('la logramo');
                        },
                        error => {
                          console.log(error);
                        });
                  }

  llenacount():void{
      this.foodService.getTotalUser()
                .subscribe(
                  data => {
                    this.count = data;
                    console.log(this.count);
                    console.log('la logramo');
                  },
                  error => {
                    console.log(error);
                  });
  }

}
