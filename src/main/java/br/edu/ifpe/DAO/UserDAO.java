package br.edu.ifpe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpe.models.User;


public interface UserDAO extends JpaRepository<User, Integer> {
}
