import { Component, OnInit } from '@angular/core';
import {ConfirmedValidator} from "./confirmed.validator";
import {Router} from "@angular/router";
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent{

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
