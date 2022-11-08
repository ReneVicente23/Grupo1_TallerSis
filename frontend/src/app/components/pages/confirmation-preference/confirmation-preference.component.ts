import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/shared/models/Order';
import {FoodService} from "../../../services/food.service";
import { Observable } from 'rxjs';
import { Pagofav } from 'src/app/shared/models/Pagofav';

@Component({
  selector: 'app-confirmation-preference',
  templateUrl: './confirmation-preference.component.html',
  styleUrls: ['./confirmation-preference.component.css']
})
export class ConfirmationPreferenceComponent implements OnInit {

  order:Order = new Order();
  pago!:Pagofav;
  constructor(orderService: OrderService, private router: Router, private foodService: FoodService) {
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
   this.getpagofav();
  }

  getpagofav(): void {
              this.foodService.getPagofav()
                .subscribe(
                  data => {
                    this.pago = data;
                    console.log(this.pago);
                    console.log('la logramo');
                  },
                  error => {
                    console.log(error);
                  });
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
       pagootro():void{
           this.foodService.updateordertoPaypal(this.order).subscribe({
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

  pagar():void{
    if(this.pago.type_payment_id_typepay=='1'){
        this.pagoefectivo();
         console.log('tipo 1');
    }else{
      if(this.pago.type_payment_id_typepay=='2'){
              this.router.navigateByUrl('/choose-card');
              //this.pagoetarjeta();
              console.log('tipo 2');
          }else{
            this.pagootro();
            console.log('tipo 3');
          }
    }
  }
}
