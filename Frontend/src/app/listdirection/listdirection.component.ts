import { Component, OnInit } from '@angular/core';
import {AppService} from "../services/address.service";

@Component({
  selector: 'app-listdirection',
  templateUrl: './listdirection.component.html',
  styleUrls: ['./listdirection.component.css']
})

export class ListdirectionComponent implements OnInit
{
  name = 'Angular';
  action: string = 'Add';

  onClick() {
    if(this.action == 'Add') {
      this.action = 'Delete';
      //alert('Primary Clicked');
    } else {
      this.action = 'Add';
      //alert('Danger clicked');
    }
  }

  constructor(private appService: AppService) { }
  addresss: any[]=[];
  address = {
    street: '',
    zone: '',
    h_number: '',
    city: '',
  };
  ngOnInit(): void
  {
    this.retrieveAddress();
  }


  retrieveAddress(): void {
    console.log('la logramo');
    this.appService.getAll()
      .subscribe(
        data => {
          this.addresss = data;
          console.log(this.address)
          console.log('la logramo');
        },
        error => {
          console.log(error);
        });
  }


}
