import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/shared/models/Order';
import { Tarjeta } from 'src/app/shared/models/Tarjeta';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-choose-card',
  templateUrl: './choose-card.component.html',
  styleUrls: ['./choose-card.component.css']
})
export class ChooseCardComponent implements OnInit {
  tarje: Tarjeta[]=[];
  order:Order = new Order();
  constructor(orderService: OrderService, private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) {
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
    this.retrieveDish();
  }

    retrieveDish(): void {
            this.foodService.getTarjeta()
              .subscribe(
                data => {
                  this.tarje = data;
                  console.log(this.tarje);
                  console.log('la logramo');
                },
                error => {
                  console.log(error);
                });
          }

     pagoetarjeta():void{
             this.foodService.updateordertoCard(this.order).subscribe({
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
