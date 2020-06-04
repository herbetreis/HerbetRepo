package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.entidades.PaisDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import frb.edu.br.dominio.contratos.IPais;


public class PaisRepositorio extends DaoUtil implements IPais{

    public PaisRepositorio() {
        super();
    }    
    
    @Override
    public boolean incluir(PaisDto pais) {
        String sql = "INSERT INTO pais (nome)" +
                     " VALUE (?)";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, pais.getNome());
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0; 
    }

    @Override
    public boolean alterar(PaisDto pais) {
        String sql = "UPDATE pais SET nome=?" +
                     " WHERE idPais=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, pais.getNome());
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM pais WHERE idPais=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public PaisDto getRegistroPorId(int id) {
        PaisDto pai = new PaisDto();
        String sql = "SELECT idPais, nome, "; 
        sql += " descricao FROM pais ";
        sql += " WHERE idPais = ?";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pai = new PaisDto(rs.getInt("idPais"),
                                      rs.getString("nome"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return pai;
    }

    @Override
    public List<PaisDto> getListaTodos() {
        List<PaisDto> paises = new LinkedList<PaisDto>();
        String sql = "SELECT idPais, nome,"; 
        sql += " descricao FROM pais ";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                paises.add(new PaisDto(rs.getInt("idPais"),
                                      rs.getString("nome")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return paises;
    }
    
}
