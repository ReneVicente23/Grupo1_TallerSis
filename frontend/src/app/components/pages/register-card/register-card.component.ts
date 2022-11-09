import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Tarjeta } from 'src/app/shared/models/Tarjeta';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-register-card',
  templateUrl: './register-card.component.html',
  styleUrls: ['./register-card.component.css']
})
export class RegisterCardComponent implements OnInit {
  tarjeta: Tarjeta = new Tarjeta();

  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  getInputValue(n_tarjeta:string, caducidad:string, cvv:string,  titular:string){
      //this.tarjeta.t_id="0";
      console.log(n_tarjeta);
      this.tarjeta.n_tarjeta=n_tarjeta;
      this.tarjeta.caducidad=caducidad;
      this.tarjeta.cvv=cvv;
      this.tarjeta.titular=titular;
      //this.tarjeta.userapp_id_userapp="0";
      console.log(this.tarjeta.n_tarjeta);
      console.log(this.tarjeta);

      this.foodService.postTarjeta(this.tarjeta).subscribe({
               next:() => {
                //this.router.navigateByUrl('/list-address');
               console.log('paso');
              },
              error:(errorResponse) => {
             console.log('error');
                                                          //this.toastrService.error(errorResponse.error, 'Cart');
              }
              });
       console.log('post exitoso');
    }

}
