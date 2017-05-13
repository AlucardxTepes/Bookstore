import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class LoginService {

  constructor(private http: Http) {
  }

  sendCredential(username: string, password: string) {
    // backend token server (Spring session)
    let url = 'http://localhost:8181/token';

    // encrypt credentials
    let encodedCredentials = btoa(username + ':' + password);

    // Pass headers include authorization
    let basicHeader = "Basic " + encodedCredentials;
    let headers = new Headers ({
        'Content-Type' : 'application/x-www-form-urlencoded',
        'Authorization' : basicHeader
    });

    return this.http.get(url, {headers: headers});
  }

}
