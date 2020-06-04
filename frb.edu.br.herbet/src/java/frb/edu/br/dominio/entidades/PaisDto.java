package frb.edu.br.dominio.entidades;

import java.util.Date;


public class PaisDto {
    private int idpais;
    private String nome;
    private String descricao;

    public PaisDto() {
    }

    public PaisDto(int idpais, String nome) {
        this.idpais = idpais;
        this.nome = nome;
    }

    public PaisDto(int idpais) {
        this.idpais = idpais;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
