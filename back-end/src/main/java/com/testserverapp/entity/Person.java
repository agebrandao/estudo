package com.testserverapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
// ,uniqueConstraints = {
//     @UniqueConstraint(name = "users_unique_cpf_idx", columnNames = "cpf"),
//     @UniqueConstraint(name = "users_unique_email_idx", columnNames = "email")
// })
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    @Size(max = 30)
    private String name;

    @Column(name = "cpf")
    @NotEmpty(message = "*Please provide your cpf")
    @Size(max = 11)
    private String cpf;

    @Column(name = "address")
    @NotEmpty(message = "*Please provide your address")
    @Size(max = 50)
    private String address;

    @Column(name = "city")
    @NotEmpty(message = "*Please provide city")
    @Size(max = 20)
    private String city;

    @Column(name = "uf")
    @NotEmpty(message = "*Please provide federated unit")
    @Size(max = 2)
    private String uf;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    @Size(max = 30)
    private String email;

    @Column(name = "telephone")
    @NotEmpty(message = "*Please provide your telephone")
    @Size(max = 12)
    private String telephone;

    @Column(name = "obs")
    @Size(max = 200)
    private String obs;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAdress(String address) {
        this.address = address;
    }

     /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

}