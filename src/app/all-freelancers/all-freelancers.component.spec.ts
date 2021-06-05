import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllFreelancersComponent } from './all-freelancers.component';

describe('AllFreelancersComponent', () => {
  let component: AllFreelancersComponent;
  let fixture: ComponentFixture<AllFreelancersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllFreelancersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllFreelancersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
