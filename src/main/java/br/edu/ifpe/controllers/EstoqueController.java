package br.edu.ifpe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifpe.DAO.EstoqueDAO;
import br.edu.ifpe.DAO.ProdutoDAO;
import br.edu.ifpe.models.Estoque;
import br.edu.ifpe.models.EstoqueId;

import javax.validation.Valid;


@Controller
public class EstoqueController {

    @Autowired
    private EstoqueDAO estoqueDAO;

    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping("add/estoque")
    public String adicionarEstoque(Estoque estoque, Model model) {
        model.addAttribute("produtos", this.produtoDAO.findAll());

        return "add/estoque";
    }

    @GetMapping("editar/estoque")
    public String editarEstoque(@RequestParam EstoqueId id, Model model) {
        Estoque estoque = this.estoqueDAO.getOne(id);
        model.addAttribute("estoque", estoque);
        model.addAttribute("produtos", this.produtoDAO.findAll());

        return "add/estoque";
    }

    @PostMapping("add/estoque")
    public String salvarEstoque(@Valid Estoque estoque, BindingResult results, Model model) {
        if(results.hasErrors()) {
            model.addAttribute("mensagem", "*Erro ao salvar dados!*");
            model.addAttribute("style", "text-align: center;  color: Tomato;");
            return "add/estoque";
        }

        model.addAttribute("style", "text-align: center; color: #6cdf49");
        model.addAttribute("mensagem", "Dados salvos no banco!");
        this.estoqueDAO.save(estoque);
        return "add/estoque";
    }

    @PostMapping("/pesquisar")
    public String pesquisarProduto(String nomePesquisa, Model model) {
        List<Estoque> resultado = this.estoqueDAO.findByProduto_NomeContainingIgnoreCaseOrderByDataValidadeDesc(nomePesquisa);

        model.addAttribute("estoques", resultado);

        return "listar/estoques";
    }

    @GetMapping("listar/estoques")
    public String listarEstoques(Model model) {
        model.addAttribute("estoques", this.estoqueDAO.findAll());

        return "listar/estoques";
    }

    @GetMapping("deletar/estoque")
    public String deletarEstoque(@RequestParam EstoqueId id) {
        Estoque estoque = this.estoqueDAO.getOne(id);
        this.estoqueDAO.deleteById(estoque.getId());

        return "redirect:/listar/estoques";
    }
}
