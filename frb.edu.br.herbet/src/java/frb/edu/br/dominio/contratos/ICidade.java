
package frb.edu.br.dominio.contratos;

import frb.edu.br.dominio.entidades.CidadeDto;
import java.util.List;


public interface ICidade {
    boolean incluir(CidadeDto vendedor);
    boolean alterar(CidadeDto vendedor);
    boolean deletar(int id);
    CidadeDto getRegistroPorId(int id);
    List<CidadeDto> getListaTodos();
}
