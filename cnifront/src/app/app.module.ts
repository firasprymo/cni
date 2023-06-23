import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {authInterceptorProviders} from './helpers/auth.interceptor';
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';
import {RegisterComponent} from './register/register.component';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {AccueilComponent} from './modules/accueil/accueil.component';
import {AccueilModule} from './modules/accueil/accueil.module';
import {AuthGuard} from "./core/guard/auth-guard.service";
import { UsersComponent } from './modules/users/users.component';
import { UsersModule } from './modules/users/users.module';
import { HeaderComponent } from './shared/component/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    AccueilComponent,
    UsersComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    CommonModule,
    AccueilModule,
    UsersModule

  ],
  providers: [authInterceptorProviders,
    AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
