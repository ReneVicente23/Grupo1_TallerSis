import { Component, OnInit } from '@angular/core';
import { MapformService } from '../services/mapform.service';

@Component({
  selector: 'app-mapform',
  templateUrl: './mapform.component.html',
  styleUrls: ['./mapform.component.css']
})
export class MapformComponent implements OnInit {
  address: any;

  title:string='REGISTRO DE DIRECCIONES';
  constructor(private mapformService: MapformService) { }

  ngOnInit(): void {
    this.retrieveAddress();
  }

  retrieveAddress(): void {
    this.mapformService.getAll()
      .subscribe(
        data => {
          this.address = data;
          console.log(data);
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

    this.mapformService.create(data)
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
