import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAwardedProjectsComponent } from './admin-awarded-projects.component';

describe('AdminAwardedProjectsComponent', () => {
  let component: AdminAwardedProjectsComponent;
  let fixture: ComponentFixture<AdminAwardedProjectsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAwardedProjectsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAwardedProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
