import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Tarjeta } from 'src/app/shared/models/Tarjeta';
import { Observable } from 'rxjs';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.css']
})
export class EditCardComponent implements OnInit {
  tarje: Tarjeta=new Tarjeta();
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
   this.get();
   console.log(this.tarje);
  }

  get() {
      var direct = localStorage.getItem('tarjeta a modificar');
      var direccion = JSON.parse(direct!);
      this.tarje = direccion;
    }

  getInputValue(card:string, exp:string, cvv:string, cardh:string){
      this.tarje.n_tarjeta=card;
      this.tarje.caducidad=exp;
      this.tarje.cvv=cvv;
      this.tarje.titular=cardh;

      this.foodService.updateTarjeta(this.tarje).subscribe({
                                                        next:() => {

                                                          console.log('paso');
                                                        },
                                                        error:(errorResponse) => {
                                                          console.log('error');
                                                          //this.toastrService.error(errorResponse.error, 'Cart');
                                                        }
                                                      });
       console.log('update exitoso');
       this.router.navigateByUrl('/list-card');
    }
}
