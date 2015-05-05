/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaencadeadaordenada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gschroeder
 */
public class Pessoa implements Comparable {

    protected String nome;
    protected String cpf;
    protected int idade;
    protected Date dataNascimento;
    protected SimpleDateFormat sdf;

    public Pessoa(String nome, String cpf, int idade, String dataNascimento) throws ParseException {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataNascimento = sdf.parse(dataNascimento);
    }

    @Override
    public int compareTo(Object t) {
        return this.nome.compareTo((((Pessoa)t)).nome);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

}
