package br.edu.ifpe.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpe.models.Usuario;
import br.edu.ifpe.DAO.UsuarioDAO;


@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
		
	@PostMapping("/login")
	public String efetuarLogin(String email, String senha, HttpSession session, RedirectAttributes ra) {
		
			
		// Buscar se existe um usuario com o login e senha informados
		Usuario usuarioLogado = this.usuarioDAO.findByEmailAndSenha(email, senha);
		if (usuarioLogado == null) {
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/";
		} else {
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/acessoNegado")
	public String acessoNegado() {
		return "acesso_negado";
	}
}

