import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Tarjeta } from 'src/app/shared/models/Tarjeta';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-card',
  templateUrl: './list-card.component.html',
  styleUrls: ['./list-card.component.css']
})
export class ListCardComponent implements OnInit {

  tarje: Tarjeta[]=[];
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  this.retrieveDish();
  }

  retrieveDish(): void {
            this.foodService.getTarjeta()
              .subscribe(
                data => {
                  this.tarje = data;
                  console.log(this.tarje);
                  console.log('la logramo');
                },
                error => {
                  console.log(error);
                });
          }

  modificar(valor: Tarjeta): void{
          localStorage.setItem ('tarjeta a modificar', JSON.stringify (valor));
     }

  borrar(valor: Tarjeta): void{

            this.foodService.borraTarjeta(valor).subscribe({
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
