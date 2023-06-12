import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'LanguageAppAngular';

  showHeader = true;

  constructor(private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit(): void {
    const parent = this.route.snapshot.parent;
    this.router.events.subscribe((val) => {
     if (val instanceof NavigationEnd) {
       if(val.url === '/'){
         this.showHeader = false;
       } else {
         this.showHeader = true;
       }
     }

    });



    // if(parent === null){
    //   this.showHeader = false;
    // } else {
    //   this.showHeader = true;
    // }
    // console.log(this.showHeader);
    // console.log(this.router.url);

  }


}
