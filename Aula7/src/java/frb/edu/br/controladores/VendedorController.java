package frb.edu.br.controladores;

import frb.edu.br.dominio.contratos.IVendedor;
import frb.edu.br.dominio.entidades.VendedorDto;
import frb.edu.br.infra.repositorios.VendedorRepositorio;
import java.util.List;

public class VendedorController {

    private VendedorDto vendedor;
    private List<VendedorDto> vendedores = null;
    
    private IVendedor vendedorRepositorio = new VendedorRepositorio();
    
    public VendedorController() {
    }

    public VendedorDto getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorDto vendedor) {
        this.vendedor = vendedor;
    }

    public List<VendedorDto> getVendedores() {
        if (vendedores == null){
            vendedores = vendedorRepositorio.getListaTodos();
        }
        return vendedores;
    }
    
    public String prepararInclusao(){
        vendedor = new VendedorDto();
        return "vaiParaVendedorIncluir";
    }
    
    public String finalizaInclusao(){
        
        vendedorRepositorio.incluir(vendedor);
        vendedores = null;
        return "voltaParaVendedorListagem";
    }
    
    public String finalizaEdicao(){
        vendedorRepositorio.alterar(vendedor);
        vendedores= null;
        return "voltaParaVendedorListagem";
    }
    
    public String finalizaDelecao(){
        vendedorRepositorio.deletar( vendedor.getIdvendedor() );
        vendedores = null;
        return null;
    }
    
    
    
}
