import { Component, OnInit } from '@angular/core';
import {Chart, registerables} from "chart.js";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodService} from "../../../services/food.service";
import { DataSet } from 'src/app/shared/models/DataSet';
import { DataBuble } from 'src/app/shared/models/DataBuble';
import { Observable } from 'rxjs';
import {BehaviorSubject} from "rxjs";

Chart.register(...registerables);

@Component({
  selector: 'app-dashboard-delivery',
  templateUrl: './dashboard-delivery.component.html',
  styleUrls: ['./dashboard-delivery.component.css']
})
export class DashboardDeliveryComponent implements OnInit {
   data1: DataSet[]=[];
      data2: DataSet[]=[];
      data3: DataSet[]=[];

  constructor(private foodService: FoodService, activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.retrieveData1();
    this.retrieveData2();
    this.retrieveData3();
  }

  retrieveData1(): void {
                this.foodService.delimonth()
                  .subscribe(
                    data => {
                      this.data1 = data;
                      console.log(this.data1);
                      console.log('tabla 1');
                      let aux
                      this.data1.forEach(function(element) {
                            console.log(element);
                          });
                      var myChart2 = new Chart("myChart2", {
                            type: 'bar',
                            data:
                              {
                                //labels: ["January", "Februrary", "March", "April", "June", "July", "August"],
                                datasets: [{
                                  label: 'Count',
                                  //data: [65, 59, 80, 81, 56, 55, 40],
                                  data:this.data1,
                                  backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(255, 159, 64, 0.2)',
                                    'rgba(255, 205, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(201, 203, 207, 0.2)'
                                  ],
                                  borderColor: [
                                    'rgb(255, 99, 132)',
                                    'rgb(255, 159, 64)',
                                    'rgb(255, 205, 86)',
                                    'rgb(75, 192, 192)',
                                    'rgb(54, 162, 235)',
                                    'rgb(153, 102, 255)',
                                    'rgb(201, 203, 207)'
                                  ],
                                  borderWidth: 1
                                }]
                              },
                            options:
                              {
                                plugins:{
                                  legend: {
                                   display: false
                                  }
                                 },
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
  retrieveData2(): void {
                  this.foodService.delitype()
                    .subscribe(
                      data => {
                        this.data2 = data;
                        console.log(this.data2);
                        console.log('tabla 2');
                        var aux=[0];
                        var aux2=[''];
                        this.data2.forEach(function(element) {
                                                     aux.push(element.y);
                                                     aux2.push(element.x);
                                                     console.log(element);
                                                   });
                        var myChar3 = new Chart("myChar3", {
                              type: 'pie',
                              data:
                                {
                                  labels: aux2,
                                  datasets:
                                    [
                                      {
                                        label: 'My First Dataset',
                                        data: aux,
                                        backgroundColor: [
                                          'rgb(255, 99, 132)',
                                          'rgb(54, 162, 235)',
                                          'rgb(255, 205, 86)'
                                        ],
                                        hoverOffset: 4
                                      }
                                    ]
                                }
                            });
                   },
                                      error => {
                                        console.log(error);
                                      });
                }
  retrieveData3(): void {
                  this.foodService.deliday()
                    .subscribe(
                      data => {
                        this.data3 = data;
                        console.log(this.data3);
                        console.log('tabla 3');
                        let aux
                        this.data3.forEach(function(element) {
                              console.log(element);
                            });
                        var myChart4 = new Chart("myChar4", {

                              type: 'line',
                              data:
                                {
                                  datasets:
                                    [
                                      {
                                        label: 'Total orders',
                                        //data: [0, 20, 40, 50],
                                        data:this.data3,
                                        backgroundColor: "rgb(115 185 243 / 65%)",
                                        borderColor: "#007ee7",
                                        fill: true,
                                        borderWidth: 5,
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
