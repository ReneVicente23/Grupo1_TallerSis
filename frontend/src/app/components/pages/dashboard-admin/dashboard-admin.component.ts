import { Component, OnInit} from '@angular/core';
import {Chart, registerables} from "chart.js";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { DataSet } from 'src/app/shared/models/DataSet';
import { DataBuble } from 'src/app/shared/models/DataBuble';
import { Observable } from 'rxjs';
import {BehaviorSubject} from "rxjs";


Chart.register(...registerables);

@Component({
  selector: 'app-dashboard-admin',
  templateUrl: './dashboard-admin.component.html',
  styleUrls: ['./dashboard-admin.component.css']
})
export class DashboardAdminComponent implements OnInit {

  data1: DataSet[]=[];
  data2: DataSet[]=[];
  data3: DataBuble[]=[];
  data4: DataSet[]=[];
  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.retrieveData1();
     this.retrieveData2();
     this.retrieveData3();
     this.retrieveData4();
  }


   retrieveData1(): void {
            this.foodService.dashpaymentcount()
              .subscribe(
                data => {
                  this.data1 = data;
                  console.log(this.data1);
                  console.log('tabla 1');
                  let aux
                  this.data1.forEach(function(element) {
                        console.log(element);
                      });
                  var myChart = new Chart("myChart", {
                        type: 'bar',
                        data:
                          {
                            //labels: this.data1,
                            datasets:
                              [
                                {

                                  label: 'Count of Payments',
                                  data: this.data1,
                                  borderWidth: 1
                                }
                              ]
                          },
                        options:
                          {
                            scales: {
                              y: {
                                beginAtZero: true
                              }
                            }
                          },
                      });
                },
                error => {
                  console.log(error);
                });
          }

   retrieveData2(): void {
               this.foodService.dashsalesmonth()
                 .subscribe(
                   data => {
                     this.data2 = data;
                     console.log(this.data2);
                     console.log('tabla 2');
                     let aux
                     this.data2.forEach(function(element) {
                           console.log(element);
                         });
                     var myChart2 = new Chart("myChart2", {
                           type: 'bar',
                           data:
                             {
                               //labels: ["January", "Februrary", "March", "April", "June", "July", "August"],
                               datasets: [{
                                 label: 'My First Dataset',
                                 //data: [65, 59, 80, 81, 56, 55, 40],
                                 data: this.data2,
                                 backgroundColor: [
                                   'rgba(255, 99, 132, 0.2)',
                                   'rgba(255, 159, 64, 0.2)',
                                   'rgba(255, 205, 86, 0.2)',
                                   'rgba(75, 192, 192, 0.2)',
                                   'rgba(54, 162, 235, 0.2)',
                                   'rgba(153, 102, 255, 0.2)'

                                 ],
                                 borderColor: [
                                   'rgb(255, 99, 132)',
                                   'rgb(255, 159, 64)',
                                   'rgb(255, 205, 86)',
                                   'rgb(75, 192, 192)',
                                   'rgb(54, 162, 235)',
                                   'rgb(153, 102, 255)'

                                 ],
                                 borderWidth: 1
                               }]
                             },
                           options:
                             {
                               //indexAxis: 'y',
                               scales: {
                                 y: {
                                   beginAtZero: true
                                 }
                               }
                             },
                         });
                   },
                   error => {
                     console.log(error);
                   });
             }
    retrieveData3(): void {
               this.foodService.bussSales()
                 .subscribe(
                   data => {
                     this.data3 = data;
                     console.log(this.data3);
                     console.log('tabla 3');
                     //let aux
                     this.data3.forEach(function(element) {
                        // element['x']=parseInt(element['x']);
                         element['r']=10;
                         //console.log(element);
                     });
                     var myChar3 = new Chart("myChar3", {
                           type: 'bubble',
                           data:
                             {
                              //labels: ['Red', 'Blue', 'Yellow'],
                               datasets:
                                 [
                                   {
                                     label: 'Bussines ID',
                                    // data: [300, 50, 100],
                                     data: this.data3,
                                      backgroundColor: 'rgb(255, 99, 132)'
                                   }
                                 ]
                             }
                         });
                   },
                   error => {
                     console.log(error);
                   });
             }

  retrieveData4(): void {
                 this.foodService.dashsalesday()
                   .subscribe(
                     data => {
                       this.data4 = data;
                       console.log(this.data4);
                       console.log('tabla 4');
                       //let aux
                        var myChart4 = new Chart("myChar4", {

                              type: 'line',
                              data:
                                {
                                  datasets:
                                    [
                                      {
                                        label: 'Current Vallue',
                                        //data: [0, 20, 40, 50],
                                        data:this.data4,
                                        backgroundColor: "rgb(115 185 243 / 65%)",
                                        borderColor: "#007ee7",
                                        fill: true,
                                        borderWidth: 10,
                                      }
                                    ],
                                    //labels: ['January 2019', 'February 2019', 'March 2019', 'April 2019']
                                }
                            });
                     },
                     error => {
                       console.log(error);
                     });
               }
}



