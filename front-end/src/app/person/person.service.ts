import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Person } from '../entity/person';
import { SettingsService } from '../shared/settings.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  personUrl: string =  this.settingsService.BASE_URL + 'person';

  constructor(
    private settingsService: SettingsService,
    private http: HttpClient

  ) {}

  /**
   * Retorna o usuário pelo ID
   * Ex: http://localhost:8080/testserverapp/person/person/0
   * 
   * @param id person_id
   */
  findById(id: string){
    return this.http.get(this.personUrl+'${id}');
  }

  /**
   * Create or update person
   * Ex: http://localhost:8080/testserverapp/person
   * 
   * @param person person object created or updated 
   */
  createOrUpdate(person: Person){
    console.log(this.personUrl);
    if(person.id != null && person.id != ''){
      return this.http.put(this.personUrl, person);
    }else{
      person.id = null;
      return this.http.post(this.personUrl, person);
    }
  }

  /**
   * Delete person
   * 
   * EX: http://localhost:8080/testserverapp/person/5b19aa57c3027e081ca52015
   * 
   * @param id person_id
   */
  delete(id: string){
    return this.http.delete(this.personUrl+'${id}');
  } 

  /**
   * Find All Person
   * 
   * EX: http://localhost:8080/testserverapp/person
   * 
   * @param id person_id
   */
  findAll(){

    return this.http.get(this.personUrl);
    
  } 


}
