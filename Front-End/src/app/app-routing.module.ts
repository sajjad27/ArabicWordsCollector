import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LoginComponent } from './registeration/login/login.component';
import { SignUpComponent } from './registeration/sign-up/sign-up.component';
import { AuthGuard } from './authService/auth-guard.service';
import { AuthenticatedToRegistrationGuard } from './authService/authenticated-to-registration-guard.service';
import { RegistrationComponent } from './registeration/registration.component';


const routes: Routes = [

  {
    path: '', canActivate: [AuthGuard],
    component: HomeComponent
  },
  {
    path: 'login', component: LoginComponent, 
    canActivate: [AuthenticatedToRegistrationGuard],
  },
  {
    path: 'signup', component: SignUpComponent, 
    canActivate: [AuthenticatedToRegistrationGuard],
  },
  { path: 'home', component: HomeComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
