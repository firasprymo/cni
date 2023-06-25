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
  {
    path: 'users',
    loadChildren: () =>
      import('./modules/users/users.module').then((m) => m.UsersModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'add',
    loadChildren: () =>
      import('./modules/users/add/add.module').then((m) => m.AddModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'detail/:id',
    loadChildren: () =>
      import('./modules/users/detail/detail.module').then((m) => m.DetailModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'edit/:id',
    loadChildren: () =>
      import('./modules/users/add/add.module').then((m) => m.AddModule),
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
