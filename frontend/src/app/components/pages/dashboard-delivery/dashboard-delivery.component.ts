import { Component, OnInit } from '@angular/core';
import {Chart, registerables} from "chart.js";

Chart.register(...registerables);

@Component({
  selector: 'app-dashboard-delivery',
  templateUrl: './dashboard-delivery.component.html',
  styleUrls: ['./dashboard-delivery.component.css']
})
export class DashboardDeliveryComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

    var myChart2 = new Chart("myChart2", {
      type: 'bar',
      data:
        {
          labels: ["January", "Februrary", "March", "April", "June", "July", "August"],
          datasets: [{
            label: 'My First Dataset',
            data: [65, 59, 80, 81, 56, 55, 40],
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
          indexAxis: 'y',
          scales: {
            y: {
              beginAtZero: true
            }
          }
        },
    });

    var myChar3 = new Chart("myChar3", {
      type: 'pie',
      data:
        {
          labels: ['Red', 'Blue', 'Yellow'],
          datasets:
            [
              {
                label: 'My First Dataset',
                data: [300, 50, 100],
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

    var myChart4 = new Chart("myChar4", {
      
      type: 'line',
      data:
        {
          datasets:
            [
              {
                label: 'Current Vallue',
                data: [0, 20, 40, 50],
                backgroundColor: "rgb(115 185 243 / 65%)",
                borderColor: "#007ee7",
                fill: true,
                borderWidth: 10,
              },
              {
                label: 'Invested Amount',
                data: [0, 20, 40, 60, 80],
                backgroundColor: "#47a0e8",
                borderColor: "#007ee7",
                fill: true,
              }
            ],
            labels: ['January 2019', 'February 2019', 'March 2019', 'April 2019']
        }
    });
  }

}
