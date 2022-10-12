import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Order2 } from 'src/app/shared/models/Order2';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-report-deliveries',
  templateUrl: './report-deliveries.component.html',
  styleUrls: ['./report-deliveries.component.css']
})
export class ReportDeliveriesComponent implements OnInit {

   order2s: Order2[] = [];
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.retrieveDish();
  }

  retrieveDish(): void {
          this.foodService.getrepdeli('0','15')
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
