import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Order2 } from 'src/app/shared/models/Order2';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-sales-report',
  templateUrl: './sales-report.component.html',
  styleUrls: ['./sales-report.component.css']
})
export class SalesReportComponent implements OnInit {

  order2s: Order2[] = [];
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.retrieveDish();
  }

  retrieveDish(): void {
            this.foodService.getbussinesrep("1")
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
