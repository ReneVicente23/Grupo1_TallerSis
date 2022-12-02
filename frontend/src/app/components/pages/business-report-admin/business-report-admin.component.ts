import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { AdminBussRep } from 'src/app/shared/models/AdminBussRep';
import { Count } from 'src/app/shared/models/Count';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-business-report-admin',
  templateUrl: './business-report-admin.component.html',
  styleUrls: ['./business-report-admin.component.css']
})
export class BusinessReportAdminComponent implements OnInit {

  order2s: AdminBussRep[] = [];
  ct1: Count = new Count();
  ct2: Count = new Count();
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.retrieveDish();
    this.retrieveC();
    this.retrieveC2();
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
   retrieveC(): void {
                 this.foodService.getTotalbusscomp()
                   .subscribe(
                     data => {
                       this.ct1 = data;
                       console.log(this.ct1);
                       console.log('la logramo');
                     },
                     error => {
                       console.log(error);
                     });
               }
   retrieveC2(): void {
                 this.foodService. getTotalbusscanc()
                   .subscribe(
                     data => {
                       this.ct2 = data;
                       console.log(this.ct2);
                       console.log('la logramo');
                     },
                     error => {
                       console.log(error);
                     });
               }
}
