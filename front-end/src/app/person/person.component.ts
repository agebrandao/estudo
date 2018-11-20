import { HttpClient } from '@angular/common/http';

import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

import { PersonService } from './person.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})

export class PersonComponent implements OnInit {

  people;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private personService: PersonService,
    private http: HttpClient) { }

  ngOnInit() {

    this.people = this.findAllPerson();

  }

  findAllPerson() {

    this.personService.findAll()
    .subscribe(
      people => this.people = people,
      error => alert('Erro na busca'));

  }

}
