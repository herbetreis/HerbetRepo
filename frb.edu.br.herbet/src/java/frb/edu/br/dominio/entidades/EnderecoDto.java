package frb.edu.br.dominio.entidades;

public class EnderecoDto {
    private int idendereco;
    private String endereco;
    private String endereco2;
    private String bairro;
    private CidadeDto cidade;
    private String cep;
    private String telefone;

    public EnderecoDto(CidadeDto cidade) {
        this.cidade = cidade;
    }

    public EnderecoDto(int idendereco, String endereco, String endereco2, String bairro, CidadeDto cidade, String cep, String telefone) {
        this.idendereco = idendereco;
        this.endereco = endereco;
        this.endereco2 = endereco2;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
    }

    public EnderecoDto() {
    }

    public EnderecoDto(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public CidadeDto getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDto cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
