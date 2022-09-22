import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from './cart-page/cart-page.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MapComponent } from './map/map.component';
import { MapformComponent } from './mapform/mapform.component';
import { ListdirectionComponent } from './listdirection/listdirection.component';
import { FoodpageComponent } from './foodpage/foodpage.component';
import {AddressComponent} from "./address/address.component";
import { UserProfileComponent } from './user-profile/user-profile.component';
import { EditUserComponent } from './edit-user/edit-user.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'search/:searchItem',component:HomeComponent},
  {path:'cart-page',component:CartPageComponent},
  {path:'login', component:LoginComponent},
  {path:'register', component:RegisterComponent},
  {path:'map', component:MapComponent},
  {path:'mapform', component:MapformComponent},
  {path:'listdirection',component:ListdirectionComponent},
  {path: 'food/:id', component:FoodpageComponent},
  {path: 'address', component: AddressComponent},
  {path: 'user-profile', component: UserProfileComponent},
  {path: 'edit-user', component: EditUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
