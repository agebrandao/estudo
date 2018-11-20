import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';

import { PersonRoutingModule } from './person.routing.module';
import { PersonService } from './person.service';
import { PersonComponent } from './person.component';
import { PersonFormComponent } from './person-form/person-form.component';


@NgModule({

  imports: [
    CommonModule,
    SharedModule,    
    PersonRoutingModule,
  ],

  declarations: [
    PersonComponent,
    PersonFormComponent,
  ],

  //Todos os componentes declarados neste modulo terão acesso aos itens declarados no provider
  providers:[
    PersonService,    
  ]
})
export class PersonModule { }
