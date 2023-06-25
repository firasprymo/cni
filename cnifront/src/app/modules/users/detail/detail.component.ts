import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../core/services/user.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  user: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private userService: UserService) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((res: any) => {
      this.getUser(res?.id)
    })
  }

  getUser(id: number) {

    this.userService.getUser(id).subscribe((res: any) => {
      this.user = res;
      console.log(res)
    })
  }

}
