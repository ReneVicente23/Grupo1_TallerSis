import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'my-login-form',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private formBuilder:FormBuilder){}

  profileForm = this.formBuilder.group({
    firstName:['',[Validators.required]],
    lastName:['',[Validators.required]],
    phoneNumber:['',[Validators.required]],
    mail:['',[Validators.required]],
    userType:['',[Validators.required]]
  });

  saveForm(){
    if(this.profileForm.valid){
      console.log('Profile form data :: ', this.profileForm.value);
    }
  }

}
