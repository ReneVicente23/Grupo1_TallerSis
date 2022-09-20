import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import {ConfirmedValidator} from "./confirmed.validator";
import {Router} from "@angular/router";

@Component({
  selector: 'my-login-form',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{

  hide: boolean = false;

  constructor(private formBuilder:FormBuilder,private router:Router){}

  profileForm = this.formBuilder.group({
    firstName:['',[Validators.required]],
    lastName:['',[Validators.required]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    confirm_password: ['', [Validators.required, Validators.minLength(6)]],
    phoneNumber:['',[Validators.required]],
    mail:['',[Validators.required]],
    userType:['',[Validators.required]]
  },{
    validator: ConfirmedValidator('password', 'confirm_password')
  });

  saveForm(){
    if(this.profileForm.valid){
      console.log('Profile form data :: ', this.profileForm.value);
      this.router.navigateByUrl('/address');
    }
  }

}




