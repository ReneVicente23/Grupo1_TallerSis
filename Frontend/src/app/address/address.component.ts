import { Component} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AppService} from "../services/address.service";
@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent{

  hide: boolean = false;
  address = {
    street: '',
    zone: '',
    h_number: '',
    city: '',
  };

  constructor(private formBuilder:FormBuilder,private router:Router,private appService: AppService){}
  addressForm = this.formBuilder.group({
    street:['',[Validators.required]],
    zone:['',[Validators.required]],
    h_number: ['', [Validators.required]],
    city: ['', [Validators.required]],
  }
  );

  saveForm(){
    if(this.addressForm.valid){
      console.log('Profile form data :: ', this.addressForm.value);
      this.router.navigateByUrl('/map');
    }
  }
  saveAddress(): void {
    const data = {
      street: this.address.street,
      zone: this.address.zone,
      h_number: this.address.h_number,
      city: this.address.city

    };
    this.appService.create(data)
      .subscribe(
        response => {
          console.log(response);

        },
        error => {
          console.log(error);
        });
  }

}

