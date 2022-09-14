import { Input, Component, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

interface users {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'my-login-form',
  template: `
      <mat-card>

      <mat-card-content>
        <form [formGroup]="form" (ngSubmit)="submit()" class="custom-form">
        <mat-card-title>Login</mat-card-title>
            <p>
            <mat-form-field>
              <input type="text" matInput placeholder="Name" formControlName="name" class="custom-input">
            </mat-form-field>
            </p>

            <p>
            <mat-form-field>
              <input type="text" matInput placeholder="Last Name" formControlName="l_name" class="custom-input">
            </mat-form-field>
            </p>

          <p>
            <mat-form-field>
              <input type="text" matInput placeholder="Phone" formControlName="p_number" class="custom-input">
            </mat-form-field>
          </p>

          <p>
            <mat-form-field>
              <input type="text" matInput placeholder="Email" formControlName="email" class="custom-input">
            </mat-form-field>
          </p>

          <p>
            <mat-form-field>
              <input type="password" matInput placeholder="Password" formControlName="password" class="custom-input">
            </mat-form-field>
          </p>

          <!--p>
            <mat-label>User Type</mat-label>
            <mat-select [(ngModel)]="selectedValue" formControlName="uTypes">
              <mat-option *ngFor="let users of userTypes" [value]="users.value">
                {{users.viewValue}}
              </mat-option>
            </mat-select>
          </p-->

          <p *ngIf="error" class="error">
            {{ error }}
          </p>


          <div class="button">
            <button type="submit" mat-button class="B1">Register</button>
          </div>


        </form>
      </mat-card-content>
    </mat-card>
  `,
  styles: [
    `
      .custom-form {
        min-width: 300px;
        max-width: 60%;
        margin: 0px auto;
        background: rgba(255, 255, 255, 0.15);
        padding: 2rem 3rem;
        margin: auto;
        border-radius: 2.5rem;
        background-color: #ecf0f3;
        box-shadow: 13px 13px 20px #cbced1, -13px -13px 20px #ffffff;
        color: black;
        margin-top: 10rem;
      }

      :host {
        border: none;
        display: flex;
        justify-content: center;
        margin: 50px 0;
      }

      mat-form-field {
        width: 100%;
        min-width: 300px;
      }

      mat-card-title,
      mat-card-content {
        display: flex;
        justify-content: center;
      }

      .error {
        padding: 16px;
        width: 300px;
        color: white;
        background-color: red;
      }

      .mat-button {
        text-transform: uppercase;
        letter-spacing: 0.15em;
        border: none;
        font-size: 0.875rem;
        background-color: #fc4141;
        padding: 0.875rem 1rem;
        border-radius: 1.5rem;
        box-shadow: 3px 3px 8px #b1b1b1, -3px -3px 8px #ffffff;
        cursor: pointer;
        font-size: 0.875rem;
        color: #ffffff;
      }
      .B1{
        margin-right: 7px;
        height: auto;
      }
    `,
  ],

})
export class RegisterComponent {
  //selectedValue: string | undefined;
  form: FormGroup = new FormGroup({
    name: new FormControl(''),
    l_name: new FormControl(''),
    p_number: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    utypes: new FormControl('')
  });

  submit() {
    if (this.form.valid) {
      this.submitEM.emit(this.form.value);
    }
  }
  @Input() error: string | null | undefined;

  @Output() submitEM = new EventEmitter();

  userTypes: users[] = [
    {value: 'client', viewValue: 'Client'},
    {value: 'b_owner', viewValue: 'Business Owner'},
    {value: 'admin', viewValue: 'Admin'},
  ];

}

