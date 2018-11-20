import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    FormsModule,    
    //Reactive form - FormGroup
    ReactiveFormsModule,
    HttpClientModule
  ],

  declarations: [ ],

  exports: [
    
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

  ],

  providers: [
  ], 

})
export class SharedModule { }
