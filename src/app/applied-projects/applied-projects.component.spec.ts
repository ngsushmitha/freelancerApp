import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppliedProjectsComponent } from './applied-projects.component';

describe('AppliedProjectsComponent', () => {
  let component: AppliedProjectsComponent;
  let fixture: ComponentFixture<AppliedProjectsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppliedProjectsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppliedProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
