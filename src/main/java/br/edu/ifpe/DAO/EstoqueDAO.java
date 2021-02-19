package br.edu.ifpe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import br.edu.ifpe.models.Estoque;

public interface EstoqueDAO extends JpaRepository<Estoque, Integer>{

    List<Estoque> findByProduto_NomeContainingIgnoreCaseOrderByDataValidadeDesc(String nomePesquisa);
}
