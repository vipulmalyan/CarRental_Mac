import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-success-dialog',
  templateUrl: './registration-success-dialog.component.html',
  styleUrls: ['./registration-success-dialog.component.scss']
})


export class RegistrationSuccessDialogComponent {
  constructor(
    private dialogRef: MatDialogRef<RegistrationSuccessDialogComponent>,
    private router: Router
  ) {}

  onOkClick(): void {
    this.dialogRef.close();
    this.router.navigate(['/login']);
  }
}


