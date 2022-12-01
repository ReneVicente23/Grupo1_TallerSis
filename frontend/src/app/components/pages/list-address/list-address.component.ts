import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Address } from 'src/app/shared/models/Address';
import { Nick } from 'src/app/shared/models/Nick';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-address',
  templateUrl: './list-address.component.html',
  styleUrls: ['./list-address.component.css']
})
export class ListAddressComponent implements OnInit {

  addresss: Address[]=[];
  nick:Nick=new Nick();
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
   this.retrieveDish();
  }

  retrieveDish(): void {
          this.foodService.getaddress()
            .subscribe(
              data => {
                this.addresss = data;
                console.log(this.addresss);
                console.log('la logramo');
              },
              error => {
                console.log(error);
              });

        }
  retrieveNick(id:string): string {
            this.foodService.getNick(id)
              .subscribe(
                data => {
                  this.nick = data;
                  console.log(this.nick);
                  console.log('la logramo');
                },
                error => {
                  console.log(error);
                });
            return this.nick.nick;
          }

   modificar(valor: Address): void{
        localStorage.setItem ('direccion a modificar', JSON.stringify (valor));
   }

    borrar(valor: Address): void{

          this.foodService.deladdress(valor).subscribe({
                                                                next:() => {

                                                                  console.log('paso');
                                                                },
                                                                error:(errorResponse) => {
                                                                  console.log('error');
                                                                  //this.toastrService.error(errorResponse.error, 'Cart');
                                                                }
                                                              });
               console.log('update exitoso');
               this.router.navigateByUrl('/list-address');
      }

}
