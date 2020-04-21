package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    
    private BigDecimal preco;

    /*
        * Usado apenas pelo Hibernate, na criacao da tabela
    */
    
    public Sessao(){

    }


    public Sessao(LocalTime horario, Filme filme, Sala sala) {
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.preco = sala.getPreco().add(filme.getPreco());
        
    }
    
    public BigDecimal getPreco() {
    	return preco.setScale(2, RoundingMode.HALF_UP);
    }
    
    public void setPreco(BigDecimal preco) {
    	 this.preco = preco;
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