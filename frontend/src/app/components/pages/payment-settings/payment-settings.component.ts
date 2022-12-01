import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Pagofav } from 'src/app/shared/models/Pagofav';
import { TypePayment } from 'src/app/shared/models/TypePayment';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-payment-settings',
  templateUrl: './payment-settings.component.html',
  styleUrls: ['./payment-settings.component.css']
})
export class PaymentSettingsComponent implements OnInit {

  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  pago: Pagofav= new Pagofav();
  tipo: TypePayment=new TypePayment();

  ngOnInit(): void {
    this.getpagofav();

  }

  getpagofav(): void {
            this.foodService.getPagofav()
              .subscribe(
                data => {
                  this.pago = data;

                  console.log(this.pago);
                  console.log('la logramo');
                  this.gettype(this.pago.type_payment_id_typepay);
                },
                error => {
                  console.log(error);
                });

          }
   updatePagofav(valor: string): void{
      this.foodService.updatepagofav(valor,this.pago).subscribe({
        next:() => {
        console.log('paso');
        },
        error:(errorResponse) => {
        console.log('error');
        //this.toastrService.error(errorResponse.error, 'Cart');
        }
      });
      console.log('update exitoso');
      //this.router.navigateByUrl('/list-address');
      }
    gettype(type:string): void {
               this.foodService.gettippago(type)
                 .subscribe(
                   data => {
                     this.tipo = data;

                     console.log(this.pago);
                     console.log('la logramo');
                   },
                   error => {
                     console.log(error);
                   });
             }

}
