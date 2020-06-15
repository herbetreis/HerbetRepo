
package frb.edu.br.dominio.contratos;

import frb.edu.br.dominio.entidades.EnderecoDto;
import java.util.List;


public interface IEndereco {
    boolean incluir(EnderecoDto endereco);
    boolean alterar(EnderecoDto Endereco);
    boolean deletar(int id);
    EnderecoDto getRegistroPorId(int id);
    List<EnderecoDto> getListaTodos();
}
