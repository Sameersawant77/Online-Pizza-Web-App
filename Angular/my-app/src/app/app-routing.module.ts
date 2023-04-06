import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PlaceorderComponent } from './placeorder/placeorder.component';
import { MycartComponent } from './mycart/mycart.component';
import { OrdertableComponent } from './ordertable/ordertable.component';

const routes: Routes = [
  { path: 'placeorder', component: PlaceorderComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'mycart', component: MycartComponent},
  { path: 'order', component: OrdertableComponent},
  { path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
