import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { RegistrationSuccessDialogComponent } from '../registration-success-dialog/registration-success-dialog.component';
 
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {
  itemForm: FormGroup;

  constructor(private fb: FormBuilder, private httpService: HttpService, private router: Router, private dialog:MatDialog) {
      this.itemForm = this.fb.group({
        username: ['', [Validators.required, Validators.minLength(3)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=[\\]{};:\'",.<>/?]).{8,}$')]],
        role: [null, Validators.required]
      });
    }

 
  onSubmit(): void {
    if (this.itemForm.valid) {
      this.httpService.registerUser(
        this.itemForm.value).subscribe(
        response => {
          console.log('Registration successful', response);
          //this.router.navigate(['/login']);
          this.dialog.open(RegistrationSuccessDialogComponent);
        },
        error => {
          console.error('Registration failed', error);
        }
      );
    }
  }

  navigateToHome() {
    this.router.navigate(['/home']);
  }

}