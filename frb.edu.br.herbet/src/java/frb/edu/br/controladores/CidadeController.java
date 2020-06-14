package frb.edu.br.controladores;

import frb.edu.br.dominio.entidades.CidadeDto;
import frb.edu.br.infra.repositorios.CidadeRepositorio;
import java.util.List;
import frb.edu.br.dominio.contratos.ICidade;

public class CidadeController {

    private CidadeDto cidade;
    private List<CidadeDto> cidades = null;
    
    private ICidade cidadeRepositorio = new CidadeRepositorio();
    
    public CidadeController() {
    }

    public CidadeDto getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDto cidade) {
        this.cidade = cidade;
    }

    public List<CidadeDto> getCidades() {
        if (cidades == null){
            cidades = cidadeRepositorio.getListaTodos();
        }
        return cidades;
    }
    
    public String prepararInclusao(){
        cidade = new CidadeDto();
        return "vaiParaCidadeIncluir";
    }
    
    public String finalizaInclusao(){
        cidadeRepositorio.incluir(cidade);
        cidades = null;
        return "voltaParaCidadeListagem";
    }
    
    public String finalizaEdicao(){
        cidadeRepositorio.alterar(cidade);
        cidades= null;
        return "voltaParaCidadeListagem";
    }
    
    public String finalizaDelecao(){
        cidadeRepositorio.deletar(cidade.getIdcidade() );
        cidades = null;
        return null;
    }
    
    
    
}
