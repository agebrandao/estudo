import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PersonComponent } from './person.component';
import { PersonFormComponent } from './person-form/person-form.component';

const personRoutes: Routes = [
  { path: '', component: PersonComponent},

  { path: 'person/new', component: PersonFormComponent},

  { path: 'person/:id/edit', component: PersonFormComponent}

];

@NgModule({
  imports: [RouterModule.forChild(personRoutes)],
  exports: [RouterModule]
})
export class PersonRoutingModule { }