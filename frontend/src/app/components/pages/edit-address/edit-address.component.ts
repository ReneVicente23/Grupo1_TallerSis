import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { Address } from 'src/app/shared/models/Address';
import { Observable } from 'rxjs';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-edit-address',
  templateUrl: './edit-address.component.html',
  styleUrls: ['./edit-address.component.css']
})
export class EditAddressComponent implements OnInit {

  addresss!: Address;
  constructor() { }

  ngOnInit(): void {
      this.get();
      console.log(this.addresss);
  }

  get() {
    var direct = localStorage.getItem('direccion a modificar');
    var direccion = JSON.parse(direct!);
    this.addresss = direccion;
  }

}
