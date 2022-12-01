import { Component, OnInit } from '@angular/core';
import {Cart} from "../../../shared/models/Cart";
import {CartService} from "../../../services/cart.service";
import {CartItem} from "../../../shared/models/CartItem";
import {Saldoapp} from "../../../shared/models/Saldoapp";
import {FoodService} from "../../../services/food.service";

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {

  cart!: Cart;
  saldo!: Saldoapp;
  constructor(private cartService: CartService, private foodService: FoodService) {
    this.cartService.getCartObservable().subscribe((cart) => {
      this.cart = cart;
    });
  }

  ngOnInit(): void {
    this.getSaldo();
  }

  removeFromCart(cartItem:CartItem){
    this.cartService.removeFromCart(cartItem.food.id);
  }

  changeQuantity(cartItem:CartItem,quantityInString:string){
    const quantity = parseInt(quantityInString);
    this.cartService.changeQuantity(cartItem.food.id,quantity);
  }

  getSaldo(){
    this.foodService.getSaldoapp()
         .subscribe(
           data => {
           this.saldo = data;
           console.log(this.saldo);
           console.log('la logramo');
           },
           error => {
           console.log(error);
           });
  }

  descuentaSaldo(){
     if (this.saldo.saldo < this.cart.totalPrice) {
          this.cart.totalPrice=this.cart.totalPrice-this.saldo.saldo;
          this.saldo.saldo=0;
     }else{
          this.saldo.saldo=this.saldo.saldo-this.cart.totalPrice;
          this.cart.totalPrice=0;
     }
  }

}
