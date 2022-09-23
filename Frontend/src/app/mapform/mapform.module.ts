import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
//import { MapformService } from './services/mapform.service';
import { MapformComponent } from './mapform.component';
//import { AppRoutingModule } from 'src/app/app-routing.module';

@NgModule({
  declarations: [
    MapformComponent,
    //MapformService,
    //AppRoutingModule
  ],
  imports: [
    BrowserModule,
    //AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  //providers: [UserService],
  //bootstrap: [AppComponent]
})
export class AppModule { }
