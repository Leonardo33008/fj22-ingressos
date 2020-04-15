package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {

    private Integer id;
    private LocalTime horario;
    private Sala sala;
    private Filme filme;


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