package biblioteca.controller;

import biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String inicio() {
        return "livros/inicio";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "livros/lista";
    }

    @PostMapping("/adicionar")
    public String adicionar(@RequestParam String titulo,
                            @RequestParam String autor,
                            @RequestParam String isbn) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setIsbn(isbn);
        livros.add(livro);
        return "redirect:/livros/lista";
    }

    @PostMapping("/remover/{indice}")
    public String remover(@PathVariable int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/livros/lista";
    }
}
