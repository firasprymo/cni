import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {UserService} from "../../../core/services/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  formUser!: FormGroup;
  id!: number;
  edit: boolean = false;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private userService: UserService) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((res: any) => {
      console.log(res)
      if (res?.id) {
        this.id = res?.id;
        this.getUser(res?.id);
        this.edit = true;
      }
    })
    this.formUser = this.formBuilder.group({
      username: [''],
      email: [''],
      password: [''],
      authorized: [''],
      roles: [''],
    })
  }

  addUser() {
    const roles = [
      {
        name: this.formUser.value.roles
      }
    ];
    this.formUser.patchValue({
      roles
    })
    this.userService.addUser(this.formUser.value).subscribe(res => {
      console.log(res)
      this.router.navigateByUrl('/users')
    })
  }

  editUser() {
    const roles = [
      {
        name: this.formUser.value.roles
      }
    ];
    this.formUser.patchValue({
      roles
    })
    this.userService.editUser(this.id, this.formUser.value).subscribe(res => {
      console.log(res)
      this.router.navigateByUrl('/users')
    })
  }

  getUser(id: number) {

    this.userService.getUser(id).subscribe((res: any) => {

      this.formUser.patchValue({
        username: res.username,
        email: res.email,
        authorized: res.authorized,
        roles: res.roles[0].name,
      })
      console.log(res)
    })
  }
}
