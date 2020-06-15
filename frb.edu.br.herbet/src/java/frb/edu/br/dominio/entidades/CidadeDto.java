
package frb.edu.br.dominio.entidades;

public class CidadeDto {
    private int idcidade;
    private String nome;
    private PaisDto pais;

    public CidadeDto() {
        pais = new PaisDto ();
    }
    
    

    public CidadeDto(int idcidade, String nome, PaisDto pais) {
        this.idcidade = idcidade;
        this.nome = nome;
        this.pais = pais;
    }

    public CidadeDto(int idcidade) {
        this.idcidade = idcidade;
         pais = new PaisDto ();
    }

    public CidadeDto(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
