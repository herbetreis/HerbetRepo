package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.ICidade;
import frb.edu.br.dominio.entidades.CidadeDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CidadeRepositorio extends DaoUtil implements ICidade{

    public CidadeRepositorio() {
        super();
    }
    
    @Override
    public boolean incluir(CidadeDto cidade) {
        String sql = "INSERT INTO cidade (idPais, nome)"+
                     " VALUES (?,?)";
        PreparedStatement ps;
        int ret=-1;
        try {
           ps = getPreparedStatement(sql);
           ps.setInt(1, cidade.getPais().getIdpais());
           ps.setString(2, cidade.getNome());
           ret = ps.executeUpdate();
           ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public boolean alterar(CidadeDto cidade) {
        String sql = "UPDATE cidade SET idPais=?, nome=?"+
                     " WHERE idcidade=?";
        PreparedStatement ps;
        int ret=-1;
        try {
           ps = getPreparedStatement(sql);
           ps.setInt(1, cidade.getPais().getIdpais());
           ps.setString(2, cidade.getNome());
           ps.setInt(3, cidade.getIdcidade());
           ret = ps.executeUpdate();
           ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM cidade "+
                     " WHERE idcidade=?";
        PreparedStatement ps;
        int ret=-1;
        try {
           ps = getPreparedStatement(sql);
           ps.setInt(1,id);
           ret = ps.executeUpdate();
           ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public CidadeDto getRegistroPorId(int id) {
        CidadeDto city = new CidadeDto();
        
        String sql = "SELECT idCidade, nome, idPais FROM cidade WHERE idCidade=?";
        
        PaisRepositorio pai = new PaisRepositorio();
        
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                city = new CidadeDto(rs.getInt("idCidade"),
                        rs.getString("nome"),
                        pai.getRegistroPorId(rs.getInt("idPais")));
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return city;
    }

    @Override
    public List<CidadeDto> getListaTodos() {
        List<CidadeDto> cidades = new LinkedList<CidadeDto>();
        String sql = "SELECT idCidade, nome"; 
        sql += " FROM cidade ";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                cidades.add(new CidadeDto(rs.getInt("idCidade"),
                                      rs.getString("nome")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return cidades;
    }
    }
    
