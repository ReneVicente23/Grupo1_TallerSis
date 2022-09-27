import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { CartPageComponent } from './cart-page/cart-page.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MapComponent } from './map/map.component';
import { MapformComponent } from './mapform/mapform.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from "@angular/material/button";
import { MatMenuModule } from "@angular/material/menu";
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from "@angular/material/card";
import { MatSelectModule } from "@angular/material/select";
import { MatInputModule } from "@angular/material/input";
import { ListdirectionComponent } from './listdirection/listdirection.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatRadioModule} from "@angular/material/radio";
import { FoodpageComponent } from './foodpage/foodpage.component';
import { AddressComponent } from './address/address.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import {HttpClientModule} from "@angular/common/http";
import { EditaddressComponent } from './editaddress/editaddress.component';
import { PaymentMethodComponent } from './payment-method/payment-method.component';
import { ReportSupplierComponent } from './report-supplier/report-supplier.component';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { ListDeliveryComponent } from './list-delivery/list-delivery.component';
import { PaymentConfirmationComponent } from './payment-confirmation/payment-confirmation.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CartPageComponent,
    LoginComponent,
    RegisterComponent,
    MapComponent,
    MapformComponent,
    ListdirectionComponent,
    FoodpageComponent,
    AddressComponent,
    UserProfileComponent,
    EditUserComponent,
    EditaddressComponent,
    PaymentMethodComponent,
    ReportSupplierComponent,
    ConfirmDialogComponent,
    ListDeliveryComponent,
    PaymentConfirmationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    ReactiveFormsModule,
    MatCardModule,
    MatSelectModule,
    MatInputModule,
    MatDatepickerModule,
    MatRadioModule,

    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
