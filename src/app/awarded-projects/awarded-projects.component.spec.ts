import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AwardedProjectsComponent } from './awarded-projects.component';

describe('AwardedProjectsComponent', () => {
  let component: AwardedProjectsComponent;
  let fixture: ComponentFixture<AwardedProjectsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AwardedProjectsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AwardedProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
