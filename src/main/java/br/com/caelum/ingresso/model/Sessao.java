package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalTime horario;
    
    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Filme filme;

    /*
        * Usado apenas pelo Hibernate, na criacao da tabela
    */
    
    public Sessao(){

    }


    public Sessao(LocalTime horario, Filme filme, Sala sala) {
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
    }

    public Integer getId() {
        return this.id;
    }

    public LocalTime getHorario() {
        return this.horario;
    }

    public Sala getSala() {
        return this.sala;
    }

    public Filme getFilme() {
        return this.filme;
    }

}