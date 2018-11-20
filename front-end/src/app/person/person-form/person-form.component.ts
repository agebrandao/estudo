import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

import { PersonService } from '../person.service';


@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit {

  formPerson: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private personService: PersonService,
    private http: HttpClient
  ) { }

  ngOnInit() {

    //Inicializa os campos do formulário 
    this.formPerson = this.formBuilder.group({

      id: [null],
      name: [null, [Validators.required, Validators.maxLength(30)]],
      cpf: [null, [Validators.required, Validators.maxLength(11)]],
      adress: [null, [Validators.required, Validators.maxLength(50)]],
      city: [null, [Validators.required, Validators.maxLength(20)]],
      uf: [null, [Validators.required, Validators.maxLength(2)]],
      email: [null, [Validators.required, Validators.email]],
      telephone: [null, [Validators.required, Validators.maxLength(12)]],
      obs: [null, [Validators.maxLength(200)]],

    });

    this.disableFields();
  }

  /**
   * Submit no formulário
   */
  onSubmit() {

    // console.log(this.formPerson.value);

    // // this.personService.createOrUpdate(this.formPerson.value);

    // this.personService.createOrUpdate(this.formPerson.value).subscribe(); //data => this.formPerson = data

    // this.http.post('3http:httpbin.org/post', 
    //                 JSON.stringify(this.formPerson.value))
    // // .map(res => res)
    // .subscribe(data => {
    //   console.log(data);

    //   //Limpa o formulário
    //   this.formPerson.reset;

    //   //Ir para tela de usuário
    //   this.router.navigate(['person']);

    // },

    // (error: any) => {
    //   alert('Erro ao tentar salvar os dados');
    // }

    // ) ;

    console.log(this.formPerson.value);

    this.personService.createOrUpdate(this.formPerson.value)
      .subscribe(
        person => {
          person = person

          console.log(person);

          alert('Pessoa atualizada');

          this.formPerson.reset;

          this.router.navigate(['person']);

        },
        error => alert('Erro na busca'));

  }

  /**
  * Desabilita campos
  */
  disableFields() {
    this.formPerson.get('id')['disable']();
  }

}
