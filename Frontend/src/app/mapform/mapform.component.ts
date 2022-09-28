import { Component, OnInit } from '@angular/core';
import { AppService } from '../services/address.service';
import {FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-mapform',
  templateUrl: './mapform.component.html',
  styleUrls: ['./mapform.component.css']
})
export class MapformComponent implements OnInit {
  address = {
    street: '',
    zone: '',
    h_number: '',
    city: '',
  };

  title:string='REGISTRO DE DIRECCIONES';
  constructor(private formBuilder:FormBuilder,private router:Router,private appService: AppService) { }

  ngOnInit(): void {
    this.retrieveAddress();
  }

  retrieveAddress(): void {
    console.log('la logramo');
    this.appService.getAll()
      .subscribe(
        data => {
          this.address = data;
          console.log(data);
          console.log('la logramo');
        },
        error => {
          console.log(error);
        });
  }

  model:any = {};
  model2:any = {};

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
          this.refresh();
        },
        error => {
          console.log(error);
        });
  }
  myValue:any;
  refresh(): void { window.location.reload(); }



}
