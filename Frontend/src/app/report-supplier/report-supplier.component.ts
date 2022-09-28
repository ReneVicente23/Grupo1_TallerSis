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

  ngOnInit(): void {
    this.retrieveDish();
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
}
