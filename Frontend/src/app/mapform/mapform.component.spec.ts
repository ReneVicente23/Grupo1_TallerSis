import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapformComponent } from './mapform.component';

describe('MapformComponent', () => {
  let component: MapformComponent;
  let fixture: ComponentFixture<MapformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MapformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MapformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
