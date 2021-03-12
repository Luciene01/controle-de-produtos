package br.edu.ifpe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpe.models.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {


	Usuario findByEmailAndSenha(String email, String senha);

}
