import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/deliverylist.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-list-delivery',
  templateUrl: './list-delivery.component.html',
  styleUrls: ['./list-delivery.component.css']
})
export class ListDeliveryComponent implements OnInit {

  constructor(private appService: AppService) { }
  deliverys: any[]=[];
  deliveri = {
    id_order:'',
    total_payment: '',
    order_status_id_order_status: '',
    type_payment_id_typepay: '',
  };
  ngOnInit(): void {
    this.delivery();
  }
  delivery(): void {
    console.log('la logramo');
    this.appService.getAll()
      .subscribe(
        data => {
          this.deliverys = data;
          console.log(this.deliveri)
          console.log('la logramo');
        },
        error => {
          console.log(error);
        });
  }
}
