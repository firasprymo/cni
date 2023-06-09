import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AuthGuard} from "./core/guard/auth-guard.service";

const routes: Routes = [
  {path: "home", component: HomeComponent},
  {
    path: '',
    loadChildren: () =>
      import('./modules/accueil/accueil.module').then((m) => m.AccueilModule),
    canActivate: [AuthGuard]
  },
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
