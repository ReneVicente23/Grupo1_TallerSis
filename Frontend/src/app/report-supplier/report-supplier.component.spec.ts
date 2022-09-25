import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportSupplierComponent } from './report-supplier.component';

describe('ReportSupplierComponent', () => {
  let component: ReportSupplierComponent;
  let fixture: ComponentFixture<ReportSupplierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportSupplierComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReportSupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
