import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Address } from 'src/app/shared/models/Address';
import { Observable } from 'rxjs';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-edit-address',
  templateUrl: './edit-address.component.html',
  styleUrls: ['./edit-address.component.css']
})
export class EditAddressComponent implements OnInit {

  addresss!: Address;
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
      this.get();
      console.log(this.addresss);
  }

  get() {
    var direct = localStorage.getItem('direccion a modificar');
    var direccion = JSON.parse(direct!);
    this.addresss = direccion;
  }

  getInputValue(street:string, zone:string, h_number:string, city:string){
    this.addresss.street=street;
    this.addresss.zone=zone;
    this.addresss.h_number=h_number;
    this.addresss.city=city;
    console.log(this.addresss.street);
    console.log(this.addresss);

    this.foodService.updateaddress(this.addresss).subscribe({
                                                      next:() => {
                                                        this.router.navigateByUrl('/list-address');
                                                        console.log('paso');
                                                      },
                                                      error:(errorResponse) => {
                                                        console.log('error');
                                                        //this.toastrService.error(errorResponse.error, 'Cart');
                                                      }
                                                    });
     console.log('update exitoso');
  }

}
