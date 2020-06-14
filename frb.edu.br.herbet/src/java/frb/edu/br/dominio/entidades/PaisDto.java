package frb.edu.br.dominio.entidades;

import java.util.Date;


public class PaisDto {
    private int idpais;
    private String nome;

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
}
