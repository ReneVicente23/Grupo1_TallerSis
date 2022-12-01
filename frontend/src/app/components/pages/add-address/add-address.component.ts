import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Address } from 'src/app/shared/models/Address';
import { Observable } from 'rxjs';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {

  addresss: Address=new Address();

  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

   getInputValue(street:string, zone:string, h_number:string, city:string){
      this.addresss.street=street;
      this.addresss.zone=zone;
      this.addresss.h_number=h_number;
      this.addresss.city=city;
      this.addresss.ref="ref";
      console.log(this.addresss.street);
      console.log(this.addresss);

      localStorage.setItem ('paranick', JSON.stringify (this.addresss));

      this.foodService.newaddress(this.addresss).subscribe({
                                                        next:() => {
                                                          this.router.navigateByUrl('/add-nick');
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
