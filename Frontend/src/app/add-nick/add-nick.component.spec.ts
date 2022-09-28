import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNickComponent } from './add-nick.component';

describe('AddNickComponent', () => {
  let component: AddNickComponent;
  let fixture: ComponentFixture<AddNickComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNickComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddNickComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
