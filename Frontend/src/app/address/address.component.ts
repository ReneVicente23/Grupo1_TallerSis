import { Component} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent{

  hide: boolean = false;

  constructor(private formBuilder:FormBuilder, private router:Router){}
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

}
