import { Component, OnInit } from '@angular/core';
import { Order2 } from 'src/app/shared/models/Order2';
import {FoodService} from "../../../services/food.service";
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pending-payments',
  templateUrl: './pending-payments.component.html',
  styleUrls: ['./pending-payments.component.css']
})
export class PendingPaymentsComponent implements OnInit {
  order2s: Order2[] = [];
  constructor(private foodService: FoodService) { }

  ngOnInit(): void {
    this.retrieveDish();
  }

  retrieveDish(): void {
          this.foodService.gettopay()
            .subscribe(
              data => {
                this.order2s = data;
                console.log('data');
                console.log(this.order2s);

              },
              error => {
                console.log(error);
              });
        }
  //
   pagoefectivocom(valor: Order2):void{
       console.log(valor);
       this.foodService.updatepayorder(valor).subscribe({
           next:() => {
           //this.router.navigateByUrl('/list-address');
             console.log('paso');
             },
             error:(errorResponse) => {
              console.log('error');
                                                                               //this.toastrService.error(errorResponse.error, 'Cart');
             }
             });
             }

}
