import { Injectable } from '@angular/core';
import { Foods } from 'src/app/shared/models/food';
@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor() { }


  getFoodById(id:number):Foods{
    return this.getAll().find(food => food.id == id)!;
  }

  getAll():Foods[]{
    return[
      {
        id:1,
        name: 'Comida 1',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/1.webp',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      },
      {
        id:2,
        name: 'Comida 2',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/2.jpg',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      },
      {
        id:3,
        name: 'Comida 3',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/3.jpg',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      },
      {
        id:4,
        name: 'Comida 4',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/4.webp',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      },
      {
        id:5,
        name: 'Comida 5',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/5.webp',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      },
      {
        id:6,
        name: 'Comida 6',
        cookTime: 'Fast Food',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/6.jpg',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      },
      {
        id:7,
        name: 'Comida 7',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/7.jpg',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      },
      {
        id:8,
        name: 'Comida 8',
        cookTime: '10-20 min',
        price: 10,
        favorite: false,
        origins: ['Italy'],
        star: 4.5,
        imageUrl:'/assets/8.jpg',
        tags: ['fastfood'],
        description: ['Lorem ipsum dolor sit amet, consectetur adipiscing elit, laboris nisi ut aliquip ex ea commodo consequat.'],
      }
    ];
  }
}
