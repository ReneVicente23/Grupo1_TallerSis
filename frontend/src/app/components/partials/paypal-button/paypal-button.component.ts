import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/shared/models/Order';
import {FoodService} from "src/app/services/food.service";

//window.paypal
declare var paypal: any;

@Component({
  selector: 'paypal-button',
  templateUrl: './paypal-button.component.html',
  styleUrls: ['./paypal-button.component.css']
})
export class PaypalButtonComponent implements OnInit {
  @Input()
  order!:Order;

  @ViewChild('paypal', {static: true})
  paypalElement!:ElementRef;

  order2:Order = new Order();
  constructor(private orderService: OrderService,
              private cartService: CartService,
              private router:Router,
              private toastrService: ToastrService,
              private foodService: FoodService) {
                  orderService.getNewOrderForCurrentUser().subscribe({
                        next: (order) => {
                          this.order = order;
                          console.log(order);
                          console.log('tas aqui');
                        },
                        error:() => {
                          router.navigateByUrl('/chekcout');
                        }
                      })
              }

  ngOnInit(): void {
    const self = this;
    paypal
      .Buttons({
        createOrder: (data: any, actions: any) => {
          console.log('dentro buttons');
          //this.pagoepaypal();
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  value: self.order.totalPrice,
                },
              },
            ],
          });
          this.pagoepaypal();
        },

        onApprove: async (data: any, actions: any) => {
          console.log('dentro de aprove');
          const payment = await actions.order.capture();
          this.order.paymentId = payment.id;
          self.orderService.pay(this.order).subscribe(
            {
              next: (orderId) => {
                this.cartService.clearCart();
                this.router.navigateByUrl('/track/' + orderId);
                this.toastrService.success(
                  'Payment Saved Successfully',
                  'Success'
                );

                this.foodService.updateordertoCard(this.order).subscribe({
                     next:() => {
                            //this.router.navigateByUrl('/list-address');
                              console.log('se completo');
                              },
                              error:(errorResponse) => {
                               console.log('error en endpoint');
                                                                                                //this.toastrService.error(errorResponse.error, 'Cart');
                              }
                              });

              },
              error: (error) => {
                this.toastrService.error('Payment Save Failed', 'Error');
              }
            }
          );
        },

        onError: (err: any) => {
          this.toastrService.error('Payment Failed', 'Error');
          console.log(err);
        },
      })
      .render(this.paypalElement.nativeElement);

  }

  pagoepaypal():void{
        this.foodService.updateordertoPaypal(this.order).subscribe({
            next:() => {
            this.toastrService.success(
                              'Payment Saved Successfully',
                              'Success'
                            );
              this.router.navigateByUrl('');
              console.log('paso');
              },
              error:(errorResponse) => {
               console.log('error');
                 //this.toastrService.error(errorResponse.error, 'Cart');
              }
              });
      }
}
