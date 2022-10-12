import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Address } from 'src/app/shared/models/Address';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-address',
  templateUrl: './list-address.component.html',
  styleUrls: ['./list-address.component.css']
})
export class ListAddressComponent implements OnInit {

  addresss: Address[]=[];
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute) { }

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

   modificar(valor: Address): void{
        localStorage.setItem ('direccion a modificar', JSON.stringify (valor));
   }

}
