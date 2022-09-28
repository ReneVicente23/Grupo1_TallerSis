import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/dish.service";

@Component({
  selector: 'app-report-supplier',
  templateUrl: './report-supplier.component.html',
  styleUrls: ['./report-supplier.component.css']
})
export class ReportSupplierComponent implements OnInit {
    name = 'Angular';

  constructor(private appService: AppService) {}
  dishs: any [] = [];
      dish = {
        id_dish: '',
        name: '',
        description: '',
        cost: '',
        business_id_business: '',
      };
  costs: any [] = [];
      cost ={
        cost: '',
      };
  orders: any [] = [];
       order ={
         count: '',
       };

  ngOnInit(): void {
    this.retrieveDish();
    this.retrieveCost();
    this.retrieveOrder();
  }

  retrieveDish(): void {
      console.log('la logramo');
      this.appService.getAll()
        .subscribe(
          data => {
            this.dishs = data;
            console.log(this.dish)
            console.log('la logramo');
          },
          error => {
            console.log(error);
          });
    }

    retrieveCost(): void {
          console.log('la logramo');
          this.appService.getCost()
            .subscribe(
              data => {
                this.cost = data;
                console.log(this.cost)
                console.log(this.costs)
                console.log('la logramo');
              },
              error => {
                console.log(error);
              });
        }

    retrieveOrder(): void {
              console.log('la logramo');
              this.appService.getOrder()
                .subscribe(
                  data => {
                    this.order = data;
                    console.log(this.order)
                    console.log(this.orders)
                    console.log('la logramo');
                  },
                  error => {
                    console.log(error);
                  });
            }
}
