import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { DeliAdminRep } from 'src/app/shared/models/DeliAdminRep';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-payment-report-delivery-admin',
  templateUrl: './payment-report-delivery-admin.component.html',
  styleUrls: ['./payment-report-delivery-admin.component.css']
})
export class PaymentReportDeliveryAdminComponent implements OnInit {

  order2s: DeliAdminRep[] = [];
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
     this.retrieveDish();
  }

   retrieveDish(): void {
            this.foodService.getrepadmindeli('0','100')
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

}
