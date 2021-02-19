package br.edu.ifpe.controllers;

import br.edu.ifpe.models.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifpe.DAO.ProdutoDAO;
import br.edu.ifpe.DAO.CategoriaDAO;
import br.edu.ifpe.models.Produto;

import javax.validation.Valid;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private CategoriaDAO categoriaDAO;

    @GetMapping("add/produto")
    public String adicionarProduto(Produto produto, Model model) {
        model.addAttribute("categorias", this.categoriaDAO.findAll());
        return "add/produto";
    }

    @GetMapping("editar/produto")
    public String editarProduto(@RequestParam Integer id, Model model) {
        Produto produto = this.produtoDAO.getOne(id);
        model.addAttribute("produto", produto);
        model.addAttribute("categorias", this.categoriaDAO.findAll());

        return "add/produto";
    }

    @PostMapping("add/produto")
    public String salvarEstoque(@Valid Produto produto, BindingResult results, Model model) {
        if(results.hasErrors()) {
            model.addAttribute("mensagem", "*Erro ao salvar dados!*");
            model.addAttribute("style", "text-align: center;  color: Tomato;");
            return "add/produto";
        }

        model.addAttribute("style", "text-align: center; color: #6cdf49");
        model.addAttribute("mensagem", "Dados salvos no banco!");
        this.produtoDAO.save(produto);
        return "add/produto";
    }

    @GetMapping("listar/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", this.produtoDAO.findAll());
        return "listar/produtos";
    }

    @GetMapping("deletar/produto")
    public String deletarProdutos(@RequestParam Integer id, Model model) {
        Produto produto = this.produtoDAO.getOne(id);
        this.produtoDAO.deleteById(produto.getId());

        return "redirect:/listar/produtos";
    }
}
