import {
    CanActivate,
    ActivatedRouteSnapshot,
    RouterStateSnapshot,
    Router,
    CanActivateChild, ActivatedRoute
}
    from "@angular/router";
import { Injectable } from "@angular/core";
import { AuthService } from "./Auth.service";
import { Observable } from 'rxjs/internal/Observable';


@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild {
    constructor(private authService: AuthService,
        private router: Router, private activatedRoute : ActivatedRoute) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        return this.authService.isAuthenticated()
            .then(
                (authenticated: boolean) => {
                    console.log(authenticated);
                    if (authenticated) {
                        return true;
                    }
                    else {
                        this.router.navigate(['/login']);
                    }
                }
            )
    }

    canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        return this.canActivate(route, state);
    }
}