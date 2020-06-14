package frb.edu.br.dominio.entidades;

import frb.edu.br.dominio.entidades.PaisDto;

public class CidadeDto {
    private int idcidade;
    private String nome;
    private PaisDto pais;

    public CidadeDto() {
        pais = new PaisDto();
        //endereco = new EnderecoDto();
    }

    public CidadeDto(int idcidade, String nome,PaisDto pais) {
        this.idcidade = idcidade;
        this.pais = pais;
        this.nome = nome;
    }

    public CidadeDto(int idcidade) {
        this.idcidade = idcidade;
        pais = new PaisDto();
    }

    public int getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(int idcidade) {
        this.idcidade = idcidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PaisDto getPais() {
        return pais;
    }
    
    public void setPais(PaisDto pais) {
        this.pais = pais;
    }


}
