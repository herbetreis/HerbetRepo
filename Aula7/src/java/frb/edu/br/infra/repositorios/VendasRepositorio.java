package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.IVendas;
import frb.edu.br.dominio.entidades.VendasDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.util.List;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;

public class VendasRepositorio extends DaoUtil implements IVendas{

    public VendasRepositorio() {
        super();
    }

    @Override
    public boolean incluir(VendasDto venda) {
        String sql = "INSERT INTO vendas (idProduto, idVendedor, vlVenda, quantidade)"+
                "VALUES (?,?,?,?)";
        
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, venda.getProduto().getIdproduto());
            ps.setInt(2, venda.getVendedor().getIdvendedor());
            ps.setDouble(3, venda.getVlvenda());
            ps.setInt(4, venda.getQuantidade());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e){
            Logger.getLogger(VendasRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e){
            
        }
        return ret >0;
    }

    @Override
    public boolean alterar(VendasDto venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendasDto getRegistroPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VendasDto> getListaTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
