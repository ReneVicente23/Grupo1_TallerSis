import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Address } from 'src/app/shared/models/Address';
import { Observable } from 'rxjs';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-add-nick',
  templateUrl: './add-nick.component.html',
  styleUrls: ['./add-nick.component.css']
})
export class AddNickComponent implements OnInit {

  addresss!: Address;
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
     this.get();
  }

  get() {
      var direct = localStorage.getItem('paranick');
      var direccion = JSON.parse(direct!);
      this.addresss = direccion;
    }

   getInputValue(nick:string){

      this.foodService.updatenick(this.addresss,nick).subscribe({
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
