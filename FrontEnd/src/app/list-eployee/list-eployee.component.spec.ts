import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListEployeeComponent } from './list-eployee.component';

describe('ListEployeeComponent', () => {
  let component: ListEployeeComponent;
  let fixture: ComponentFixture<ListEployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListEployeeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListEployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
