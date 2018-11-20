import { EventEmitter } from '@angular/core';
import { Injectable } from '@angular/core';

 /**
   *System configuration
   */
@Injectable()
export class SettingsService {
  
  //URL base (Server access)
  BASE_URL: string = 'http://localhost:8080/testserverapp/';

  constructor() {}

  /** 
   * Configura o locale da aplicação
   */
  getLocale(){
    return 'pt_BR';
  }

}
