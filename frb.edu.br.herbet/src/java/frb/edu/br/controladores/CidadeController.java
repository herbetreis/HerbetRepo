package frb.edu.br.controladores;

import frb.edu.br.dominio.entidades.CidadeDto;
import frb.edu.br.infra.repositorios.CidadeRepositorio;
import java.util.List;
import frb.edu.br.dominio.contratos.ICidade;

public class CidadeController {
    private ICidade cidadeDao = new CidadeRepositorio();

    private CidadeDto cidad;
    private List<CidadeDto> cidades = null;

    public CidadeController() {
    }

    public CidadeDto getCidad() {
        return cidad;
    }

    public void setCidad(CidadeDto cidad) {
        this.cidad = cidad;
    }

    public List<CidadeDto> getCidades() {
        if(cidades == null){
            cidades = cidadeDao.getListaTodos();
        }
        return cidades;
    }
    public String preparaInclusao(){
        cidad = new CidadeDto();
        return "vaiParaCidadeIncluir";
    }
    
    public String finalizaInclusao(){
        cidadeDao.incluir(cidad);
        return "voltaParaCidadeListagem";
    }
    
    public String finalizaEdicao(){
        cidadeDao.alterar(cidad);
        cidades = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        cidadeDao.deletar(cidad.getIdcidade());
        cidades = null;
        return "refresh";
    }
    
}
