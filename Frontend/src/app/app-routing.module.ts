import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from './cart-page/cart-page.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MapComponent } from './map/map.component';
import { MapformComponent } from './mapform/mapform.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'search/:searchItem',component:HomeComponent},
  {path:'cart-page',component:CartPageComponent},
  {path:'login', component:LoginComponent},
  {path:'register', component:RegisterComponent},
  {path:'map', component:MapComponent},
  {path:'mapform', component:MapformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
