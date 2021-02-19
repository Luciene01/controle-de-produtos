package br.edu.ifpe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpe.models.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{
}
