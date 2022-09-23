import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import {ConfirmedValidator} from "./confirmed.validator";
import {Router} from "@angular/router";
import {AppService} from "../services/app.service";

@Component({
  selector: 'my-login-form',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{

  hide: boolean = false;
  user = {
    firstName: '',
    lastName: '',
    phoneNumber: '',
    mail: '',

  };

  constructor(private formBuilder:FormBuilder,private router:Router,private appService: AppService){}

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
  saveUser(): void {
    const data = {
      name: this.user.firstName,
      last_name: this.user.lastName,
      phone: this.user.phoneNumber,
      mail: this.user.mail

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




