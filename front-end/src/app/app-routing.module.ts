
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PersonComponent } from './person/person.component';
import { PersonFormComponent } from './person/person-form/person-form.component';

const appRoutes: Routes = [

  //  { path: '', component: AppComponent, },

  // { path: '', pathMatch: 'full', redirectTo: 'person' },

   { path: 'person', component: PersonComponent,},

];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
