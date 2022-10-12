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
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) {

   }


  ngOnInit(): void {
    this.retrieveDish();
    this.llenacount();
  }

  retrieveDish(): void {
        this.foodService.getDishUser('0','15')
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
