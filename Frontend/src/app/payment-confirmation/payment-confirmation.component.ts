import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/deliverylist.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-payment-confirmation',
  templateUrl: './payment-confirmation.component.html',
  styleUrls: ['./payment-confirmation.component.css']
})
export class PaymentConfirmationComponent implements OnInit {

  constructor(private appService: AppService) { }

   deliveri = {
       id_order: '',
       total_payment: '',
       order_status_id_order_status: '',
       type_payment_id_typepay: '',
       delivery_id_delivery:'',
     };
    deliveri2 = {
          id_order: '',
          total_payment: '',
          order_status_id_order_status: '',
          type_payment_id_typepay: '',
          delivery_id_delivery:'',
          orderdate: '',
        };

  ngOnInit(): void {
  console.log(localStorage.getItem('order'));
  }

  updatepay(): void {
      console.log('iniciando pay');
      console.log(localStorage.getItem('order'));

      this.deliveri = JSON.parse(localStorage.getItem('order')|| '{}');

      this.deliveri2.id_order = this.deliveri.id_order;

      console.log(this.deliveri);
      console.log(this.deliveri2);
       console.log('aqui');

      this.appService.updatestate(this.deliveri2);
      localStorage.removeItem('order');
    }

   eliminalocal(): void {
         localStorage.removeItem('order');
       }

}
