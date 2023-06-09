// import { Component } from '@angular/core';
// import { Router } from '@angular/router';
// import { LoginService } from '../services/login.service';
// import { TokenStorageService } from '../services/token-storage.service';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// export class LoginComponent {
//   form: any = {};
//   isLoggedIn = false;
//   isLoginFailed = false;
//   errorMessage = '';
//   roles: string[] = [];

//   constructor(private authService: LoginService, private tokenStorage: TokenStorageService,private router:Router) { }

//   ngOnInit(): void {
//     if (this.tokenStorage.getToken()) {
//       this.isLoggedIn = true;
//     }
//   }

//   onSubmit(): void {
//     this.authService.login(this.form).subscribe(
//       (data:any) => {
//         this.tokenStorage.saveToken(data.accessToken);
//         this.tokenStorage.saveUser(data);

//         this.isLoginFailed = false;
//         this.isLoggedIn = true;
//         this.router.navigate(["home"]);

//       },
//       (err:any)=> {
//         this.errorMessage = err.error.message;
//         this.isLoginFailed = true;
//       }
//     );
//   }


// }
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth-service.service';
import { TokenStorageService } from '../services/token-storage.service';
import { Router } from '@angular/router';
// import { AuthService } from '../_services/auth.service';
// import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService,private router: Router
    ) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.router.navigate(['/']);

      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;

    this.authService.login(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.router.navigate(['/']);

      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }
  regitre(){
    this.router.navigate(['/accueil']);
  }
}
