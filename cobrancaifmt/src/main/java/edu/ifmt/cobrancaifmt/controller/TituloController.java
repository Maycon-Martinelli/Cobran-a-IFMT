package edu.ifmt.cobrancaifmt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifmt.cobrancaifmt.model.Titulo;
import edu.ifmt.cobrancaifmt.repository.Titulos;

@Controller
@RequestMapping("/titulos")
class TituloController {
    
    @Autowired // Injeção de dependência do repositório
    private Titulos titulos;

    @RequestMapping("/novo")//mapeamento da url
    public String novo(){//método que retona uma Sting com o nome da view
        return "CadastroTitulo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo) {

        titulos.save(titulo);
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("mensagem", "Foi salvo com sucesso!");

        return mv;
    }



}
