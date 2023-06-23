import {Component, OnInit} from '@angular/core';
import {UserService} from "../../core/services/user.service";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: any = [];

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe(res => {
      this.users = res;
    })
  }

  delete(id: number, index: number) {
    this.userService.deleteUser(id).subscribe(res => {
      this.users.splice(index, 1)
      console.log(res)
    })
  }
}
