import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <!-- <app-home></app-home> -->
  
  <router-outlet></router-outlet>`,
  styleUrls: []
})
export class AppComponent {
  title = 'pitza';
}
