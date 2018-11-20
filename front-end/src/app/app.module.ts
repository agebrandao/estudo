import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PersonModule } from './person/person.module';

import { SharedModule } from './shared/shared.module';
import { SettingsService } from './shared/settings.service';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    PersonModule,
  ],
  providers: [
    SettingsService,
    {
      //Configura o locale da aplicação
      provide: LOCALE_ID,
      deps: [SettingsService],
      useFactory: (SettingsService) => SettingsService.getLocale()
    },

  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
