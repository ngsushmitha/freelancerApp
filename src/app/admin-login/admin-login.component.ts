import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
selector: 'app-admin-login',
templateUrl: './admin-login.component.html',
styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

constructor(private routerDemo: Router) { }
username;
password;
ngOnInit() {
}
validate() {
if (this.username === 'admin' && this.password === 'pass') {
this.routerDemo.navigateByUrl('/adminhome');
} else {
alert('Invalid Credentials!');
}

}

}
