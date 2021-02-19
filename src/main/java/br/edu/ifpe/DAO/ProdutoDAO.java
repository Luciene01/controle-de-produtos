package br.edu.ifpe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpe.models.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Integer>{
}
