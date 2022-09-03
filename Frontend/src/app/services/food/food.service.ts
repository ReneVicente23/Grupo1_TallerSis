import { Injectable } from '@angular/core';
import { Foods } from 'src/app/shared/models/food';
@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor() { }

  getAll():Foods[]{
    return[
      {
        id:1,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/1.webp',
        tags: ['fastfood'],
      },
      {
        id:2,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/2.jpg',
        tags: ['fastfood'],
      },
      {
        id:3,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/3.jpg',
        tags: ['fastfood'],
      },
      {
        id:4,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/4.webp',
        tags: ['fastfood'],
      },
      {
        id:5,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/5.webp',
        tags: ['fastfood'],
      },
      {
        id:6,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/6.jpg',
        tags: ['fastfood'],
      },
      {
        id:7,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/7.jpg',
        tags: ['fastfood'],
      },
      {
        id:8,
        name: 'comida',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/8.jpg',
        tags: ['fastfood'],
      }
    ];
  }
}
