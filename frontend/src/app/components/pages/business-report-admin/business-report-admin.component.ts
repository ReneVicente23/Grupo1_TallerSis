import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { AdminBussRep } from 'src/app/shared/models/AdminBussRep';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-business-report-admin',
  templateUrl: './business-report-admin.component.html',
  styleUrls: ['./business-report-admin.component.css']
})
export class BusinessReportAdminComponent implements OnInit {

  order2s: AdminBussRep[] = [];
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.retrieveDish();
  }

   retrieveDish(): void {
              this.foodService.getrepadminbuss('0','100')
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
