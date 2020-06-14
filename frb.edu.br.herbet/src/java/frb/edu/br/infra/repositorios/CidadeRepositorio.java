package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.entidades.CidadeDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import frb.edu.br.dominio.contratos.ICidade;

public class CidadeRepositorio extends DaoUtil implements ICidade {

    public CidadeRepositorio() {
        super ();
    }

    @Override
    public boolean incluir(CidadeDto cidade) {
        String sql = "INSERT INTO cidade (idpais, nome) VALUES (?,?)";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setInt(1, cidade.getPais().getIdpais());
            ps.setString(2, cidade.getNome());
            ret = ps.executeUpdate();
            ps.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
        
    }

    @Override
    public boolean alterar(CidadeDto cidade) {
        String sql = "UPDATE cidade SET nome=?"+
                     " WHERE idcidade=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setString(1, cidade.getNome());
            ps.setInt(2, cidade.getIdcidade());
            ret = ps.executeUpdate();
            ps.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM cidade WHERE idcidade=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public CidadeDto getRegistroPorId(int id) {
        CidadeDto cidad = new CidadeDto();
        
        String sql = "SELECT idCidade, nome "; 
        sql += " FROM cidade ";
        sql += " WHERE idCidade = ?";
        

        
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cidad = new CidadeDto (rs.getInt("idcidade"),
                        rs.getInt("idpais"),
                        rs.getString("nome"));           
            }
            rs.close();
            ps.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cidad;
    }

    @Override
    public List<CidadeDto> getListaTodos() {
        List <CidadeDto> cids = new LinkedList<CidadeDto> ();
        String sql = "SELECT idcidade, nome FROM cidade";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                
                cids.add (new CidadeDto (rs.getInt("idcidade"),
                                        rs.getString("nome")));
            }
            rs.close();
            ps.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cids;
    }
    
}
