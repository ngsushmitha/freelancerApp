import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelancerBrowseProjectsComponent } from './freelancer-browse-projects.component';

describe('FreelancerBrowseProjectsComponent', () => {
  let component: FreelancerBrowseProjectsComponent;
  let fixture: ComponentFixture<FreelancerBrowseProjectsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreelancerBrowseProjectsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreelancerBrowseProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
