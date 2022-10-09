import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./components/pages/home/home.component";
import { FoodPageComponent } from "./components/pages/food-page/food-page.component";
import { CartPageComponent } from "./components/pages/cart-page/cart-page.component";
import { SalesReportComponent } from './components/pages/sales-report/sales-report.component';
import { OrdersHistoryComponent } from './components/pages/orders-history/orders-history.component';
import { ReportDeliveriesComponent } from './components/pages/report-deliveries/report-deliveries.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'search/:searchTerm',component:HomeComponent},
  {path:'tag/:tag',component:HomeComponent},
  {path:'food/:id',component:FoodPageComponent},
  {path:'cart-page',component:CartPageComponent},
  {path:'sales-report',component:SalesReportComponent},
  {path: 'orders-history', component:OrdersHistoryComponent},
  {path: 'report-deliveries', component:ReportDeliveriesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
