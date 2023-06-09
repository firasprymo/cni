import {Component, OnInit} from '@angular/core';
import {environment} from "../../../environments/environment";
import {Router} from "@angular/router";
import {TokenStorageService} from "../../services/token-storage.service";

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  user: any = [];
  loggedIn: boolean = false;

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
