import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../../services/token-storage.service";
import {environment} from "../../../../environments/environment";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  loggedIn: boolean = false;
  user: any = [];

  constructor(private router: Router,
    private tokenStorageService: TokenStorageService) {

  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser()
    console.log(this.user)
    if (this.user) {
      this.loggedIn = true;
    }
  }
  logout() {
    localStorage.clear();
    this.tokenStorageService.signOut();
    sessionStorage.removeItem(environment.authToken);

    sessionStorage.clear()
    this.router.navigateByUrl("login");
  }

}
