import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './registeration/login/login.component';
import { HomeComponent } from './home/home.component';
import { SignUpComponent } from './registeration/sign-up/sign-up.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AuthGuard } from './authService/auth-guard.service';
import { AuthService } from './authService/Auth.service';
import { AuthenticatedToRegistrationGuard } from './authService/authenticated-to-registration-guard.service';
import { RegistrationComponent } from './registeration/registration.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignUpComponent,
    NotFoundComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AuthService, AuthGuard, AuthenticatedToRegistrationGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
