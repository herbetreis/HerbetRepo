package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.IEndereco;
import frb.edu.br.dominio.entidades.EnderecoDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoRepositorio extends DaoUtil implements IEndereco{

    public EnderecoRepositorio() {
        super();
    }
    
    @Override
    public boolean incluir(EnderecoDto endereco) {
        String sql = "INSERT INTO endereco (idEndereco, endereco, endereco2, bairro, idCidade, cep, telefone)"+
                     " VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps;
        int ret=-1;
        try {
           ps = getPreparedStatement(sql);
           ps.setInt(1, endereco.getIdendereco());
           ps.setString(2, endereco.getEndereco());
           ps.setString(3, endereco.getEndereco2());
           ps.setString(4, endereco.getBairro());
           ps.setInt(5, endereco.getCidade().getPais().getIdpais());
           ps.setString(6, endereco.getCep());
           ps.setString(7, endereco.getTelefone());
           ret = ps.executeUpdate();
           ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public boolean alterar(EnderecoDto endereco) {
        String sql = "UPDATE endereco SET idEndereco=?, endereco=?, endereco2=?, bairro=?, idCidade=?, cep=?, telefone=?"+
                     " WHERE idendereco=?";
        PreparedStatement ps;
        int ret=-1;
        try {
           ps = getPreparedStatement(sql);
           ps.setInt(1, endereco.getIdendereco());
           ps.setString(2, endereco.getEndereco());
           ps.setString(3, endereco.getEndereco2());
           ps.setString(4, endereco.getBairro());
           ps.setInt(5, endereco.getCidade().getPais().getIdpais());
           ps.setString(6, endereco.getCep());
           ps.setString(7, endereco.getTelefone());
           ret = ps.executeUpdate();
           ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM endereco "+
                     " WHERE idendereco=?";
        PreparedStatement ps;
        int ret=-1;
        try {
           ps = getPreparedStatement(sql);
           ps.setInt(1,id);
           ret = ps.executeUpdate();
           ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public EnderecoDto getRegistroPorId(int id) {
        EnderecoDto end = new EnderecoDto();
        
        String sql = "SELECT idEndereco, endereco, endereco2, bairro, idCidade, cep, telefone FROM endereco WHERE idEndereco=?";
        
        CidadeRepositorio cidad = new CidadeRepositorio();
        
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                end = new EnderecoDto(rs.getInt("idEndereco"),
                        rs.getString("endereco"),
                        rs.getString("endereco2"),
                        rs.getString("bairro"),
                        cidad.getRegistroPorId(rs.getInt("idCidade")),
                        rs.getString("cep"),
                        rs.getString("telefon"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return end;
        
    }

    @Override
    public List<EnderecoDto> getListaTodos() {
            List<EnderecoDto> enderecos = new LinkedList<EnderecoDto>();
        String sql = "SELECT idCidade, nome"; 
        sql += " FROM cidade ";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                enderecos.add(new EnderecoDto(rs.getInt("idEndereco"),
                                      rs.getString("nome")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return enderecos;
    }
}