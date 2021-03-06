package br.edu.ifpe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import br.edu.ifpe.models.Estoque;
import br.edu.ifpe.models.EstoqueId;


public interface EstoqueDAO extends JpaRepository<Estoque, EstoqueId>{

    List<Estoque> findByProduto_NomeContainingIgnoreCaseOrderByDataValidadeDesc(String nomePesquisa);
}
