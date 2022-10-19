import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/pages/home/home.component";
import {FoodPageComponent} from "./components/pages/food-page/food-page.component";
import {CartPageComponent} from "./components/pages/cart-page/cart-page.component";
import {LoginPageComponent} from "./components/pages/login-page/login-page.component";
import {RegisterPageComponent} from "./components/pages/register-page/register-page.component";
import {CheckoutPageComponent} from "./components/pages/checkout-page/checkout-page.component";
import {AuthGuard} from "./auth/guards/auth.guard";
import {PaymentPageComponent} from "./components/pages/payment-page/payment-page.component";
import {OrdersHistoryComponent } from './components/pages/orders-history/orders-history.component';
import {SalesReportComponent } from './components/pages/sales-report/sales-report.component';
import {ReportDeliveriesComponent } from './components/pages/report-deliveries/report-deliveries.component';
import { ListAddressComponent } from './components/pages/list-address/list-address.component';
import { EditAddressComponent } from './components/pages/edit-address/edit-address.component';
import { MessageConfirmComponent } from './components/pages/message-confirm/message-confirm.component'; 
import { PendingPaymentsComponent } from './components/pages/pending-payments/pending-payments.component';
import { PaymentConfirmationComponent } from './components/pages/payment-confirmation/payment-confirmation.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'search/:searchTerm',component:HomeComponent},
  {path:'tag/:tag',component:HomeComponent},
  {path:'food/:id',component:FoodPageComponent},
  {path:'cart-page',component:CartPageComponent},
  {path:'login',component:LoginPageComponent},
  {path:'register',component:RegisterPageComponent},
  {path:'checkout',component:CheckoutPageComponent, canActivate:[AuthGuard]},
  {path:'payment',component:PaymentPageComponent, canActivate:[AuthGuard]},
  {path:'sales-report',component:SalesReportComponent, canActivate:[AuthGuard]},
  {path: 'orders-history', component:OrdersHistoryComponent, canActivate:[AuthGuard]},
  {path: 'report-deliveries', component:ReportDeliveriesComponent, canActivate:[AuthGuard]},
  {path: 'list-address', component:ListAddressComponent, canActivate:[AuthGuard]},
  {path: 'edit-address', component:EditAddressComponent, canActivate:[AuthGuard]},
  {path: 'message-confirm',component:MessageConfirmComponent, canActivate:[AuthGuard]},
  {path: 'pending-payments', component:PendingPaymentsComponent, canActivate:[AuthGuard]},
  {path: 'payment-confirmation', component:PaymentConfirmationComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
