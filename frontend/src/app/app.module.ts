import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/partials/header/header.component';
import { HomeComponent } from './components/pages/home/home.component';
import { OrdersHistoryComponent } from './components/pages/orders-history/orders-history.component';
import { ReportDeliveriesComponent } from './components/pages/report-deliveries/report-deliveries.component';
import { ListAddressComponent } from './components/pages/list-address/list-address.component';
import { EditAddressComponent } from './components/pages/edit-address/edit-address.component';
import { RatingModule } from "ng-starrating";
import { SearchComponent } from './components/partials/search/search.component';
import { TagsComponent } from './components/partials/tags/tags.component';
import { FoodPageComponent } from './components/pages/food-page/food-page.component';
import { CartPageComponent } from './components/pages/cart-page/cart-page.component';
import { TitleComponent } from './components/partials/title/title.component';
import { NotFoundComponent } from './components/partials/not-found/not-found.component';
import { LoginPageComponent } from './components/pages/login-page/login-page.component';
import { ReactiveFormsModule } from "@angular/forms";
import { ToastrModule } from "ngx-toastr";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { InputContainerComponent } from './components/partials/input-container/input-container.component';
import { InputValidationComponent } from './components/partials/input-validation/input-validation.component';
import { TextInputComponent } from './components/partials/text-input/text-input.component';
import { DefaultButtonComponent } from './components/partials/default-button/default-button.component';
import { RegisterPageComponent } from './components/pages/register-page/register-page.component';
import { LoadingComponent } from './components/partials/loading/loading.component';
import { LoadingInterceptor } from "./shared/interceptors/loading.interceptor";
import { CheckoutPageComponent } from './components/pages/checkout-page/checkout-page.component';
import { OrderItemsListComponent } from './components/partials/order-items-list/order-items-list.component';
import { MapComponent } from './components/partials/map/map.component';
import {AuthInterceptor} from "./auth/auth.interceptor";
import { PaymentPageComponent } from './components/pages/payment-page/payment-page.component';
import { PaypalButtonComponent } from './components/partials/paypal-button/paypal-button.component';
import { MessageConfirmComponent } from './components/pages/message-confirm/message-confirm.component';
import { PendingPaymentsComponent } from './components/pages/pending-payments/pending-payments.component';
import { PaymentConfirmationComponent } from './components/pages/payment-confirmation/payment-confirmation.component';
import { SettingsComponent } from './components/pages/settings/settings.component';
import { PaymentSettingsComponent } from './components/pages/payment-settings/payment-settings.component';
import { PaymentConfirmComponent } from './components/pages/payment-confirm/payment-confirm.component';
import { ConfirmationPreferenceComponent } from './components/pages/confirmation-preference/confirmation-preference.component';
import { RegisterCardComponent } from './components/pages/register-card/register-card.component';
import { ListCardComponent } from './components/pages/list-card/list-card.component';
import { ChooseCardComponent } from './components/pages/choose-card/choose-card.component';
import { EditCardComponent } from './components/pages/edit-card/edit-card.component';
import { ConfirmCardComponent } from './components/pages/confirm-card/confirm-card.component';
import { BusinessReportAdminComponent } from './components/pages/business-report-admin/business-report-admin.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    EditAddressComponent,
    OrdersHistoryComponent,
    ReportDeliveriesComponent,
    ListAddressComponent,
    SearchComponent,
    TagsComponent,
    FoodPageComponent,
    CartPageComponent,
    TitleComponent,
    NotFoundComponent,
    LoginPageComponent,
    InputContainerComponent,
    InputValidationComponent,
    TextInputComponent,
    DefaultButtonComponent,
    RegisterPageComponent,
    LoadingComponent,
    CheckoutPageComponent,
    OrderItemsListComponent,
    MapComponent,
    PaymentPageComponent,
    PaypalButtonComponent,
    MessageConfirmComponent,
    PendingPaymentsComponent,
    PaymentConfirmationComponent,
    SettingsComponent,
    PaymentSettingsComponent,
    PaymentConfirmComponent,
    ConfirmationPreferenceComponent,
    RegisterCardComponent,
    ListCardComponent,
    ChooseCardComponent,
    EditCardComponent,
    ConfirmCardComponent,
    BusinessReportAdminComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    RatingModule,
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot({
      timeOut:3000,
      positionClass:'toast-bottom-right',
      newestOnTop:false
    })
  ],
  providers: [
    {provide:HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi:true},
    {provide:HTTP_INTERCEPTORS, useClass: LoadingInterceptor, multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
