package br.edu.ifpe.controllers;

import br.edu.ifpe.models.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifpe.DAO.CategoriaDAO;
import br.edu.ifpe.models.Categoria;

import javax.validation.Valid;


@Controller
public class CategoriaController {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @GetMapping("add/categoria")
    public String adicionarCategoria(Categoria categoria) {
        return "add/categoria";
    }

    @GetMapping("editar/categoria")
    public String editarCategoria(@RequestParam Integer id, Model model) {
        Categoria categoria = this.categoriaDAO.getOne(id);
        model.addAttribute("categoria", categoria);

        return "add/categoria";
    }

    @PostMapping("add/categoria")
    public String salvarCategoria(@Valid Categoria categoria, BindingResult results, Model model) {
        if(results.hasErrors()) {
            model.addAttribute("mensagem", "*Erro ao salvar dados!*");
            model.addAttribute("style", "text-align: center;  color: Tomato;");
            return "add/categoria";
        }

        model.addAttribute("style", "text-align: center; color: #6cdf49");
        model.addAttribute("mensagem", "Dados salvos no banco!");
        this.categoriaDAO.save(categoria);
        return "add/categoria";
    }

    @GetMapping("listar/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", this.categoriaDAO.findAll());

        return "listar/categorias";
    }

    @GetMapping("deletar/categoria")
    public String deletarCategoria(@RequestParam Integer id,  Categoria categoria) {

        categoria = this.categoriaDAO.getOne(id);
        this.categoriaDAO.deleteById(categoria.getId());

        return "redirect:/listar/categorias";
    }

}
