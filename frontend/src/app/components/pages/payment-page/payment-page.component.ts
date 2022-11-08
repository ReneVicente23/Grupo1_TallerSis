import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/shared/models/Order';
import {FoodService} from "../../../services/food.service";
import { Observable } from 'rxjs';

@Component({
  selector: 'app-payment-page',
  templateUrl: './payment-page.component.html',
  styleUrls: ['./payment-page.component.css']
})
export class PaymentPageComponent implements OnInit {

  order:Order = new Order();
  constructor(orderService: OrderService, router: Router, private foodService: FoodService) {
    orderService.getNewOrderForCurrentUser().subscribe({
      next: (order) => {
        this.order = order;
        console.log(order);
      },
      error:() => {
        router.navigateByUrl('/chekcout');
      }
    })

  }

  ngOnInit(): void {
  }

  pagoefectivo():void{
    this.foodService.updateorderpayment(this.order).subscribe({
        next:() => {
        //this.router.navigateByUrl('/list-address');
          console.log('paso');
          },
          error:(errorResponse) => {
           console.log('error');
             //this.toastrService.error(errorResponse.error, 'Cart');
          }
          });

  }

}
