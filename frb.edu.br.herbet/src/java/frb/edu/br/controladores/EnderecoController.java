package frb.edu.br.controladores;

import frb.edu.br.dominio.entidades.EnderecoDto;
import frb.edu.br.infra.repositorios.EnderecoRepositorio;
import java.util.List;
import frb.edu.br.dominio.contratos.IEndereco;


public class EnderecoController {
    private EnderecoDto endereco;
    private List<EnderecoDto> enderecos = null;
    
    private IEndereco enderecoRepositorio = (IEndereco) new EnderecoRepositorio();


    public EnderecoController() {
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<EnderecoDto> getEnderecos() {
        if(enderecos == null){
            enderecos = enderecoRepositorio.getListaTodos();
        }
        return enderecos;
    }
    
    public String prepararInclusao(){
        endereco = new EnderecoDto();
        return "vaiParaEnderecoIncluir";
    }
    
    public String finalizaInclusao(){
        
        enderecoRepositorio.incluir(endereco);
        enderecos = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        enderecoRepositorio.alterar(endereco);
        enderecos = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        enderecoRepositorio.deletar(endereco.getIdendereco());
        enderecos = null;
        return "refresh";
    }
    
    
}
