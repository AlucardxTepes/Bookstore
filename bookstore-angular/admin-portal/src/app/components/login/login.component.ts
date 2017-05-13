import {Component, OnInit} from '@angular/core';
import {LoginService} from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private credential = {'username': '', 'password': ''};
  private loggedIn = false;

  constructor(private loginService: LoginService) {
  }

  onSubmit() {
    this.loginService.sendCredential(this.credential.username, this.credential.password).subscribe(
      res => {
        // if successful, receive response (res)
        console.log(res);
        localStorage.set('xAuthToken', res.json().token); // auth stored in local browser
        this.loggedIn = true;
        location.reload(); // refresh page
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit() {
  }

}
