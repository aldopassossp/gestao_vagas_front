package br.com.aldopassos.front_gestao_vagas.inicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PrimeiraPaginaController {
    
    @GetMapping("/home")
    public String primeiraPaginaHtml(Model model){
        
        model.addAttribute("mensagemDaController", "Primeira mensagem vindo da controller");
        return "primeiraPagina";
    }

    @GetMapping("/login")
    public String loginCandidate(){
        return "candidate/login";
    }

//    @PostMapping("/create")
//    public String cadastoCandidate(Pessoa pessoa){
//        System.out.println("Nome do candidato " + pessoa.nome);
//        System.out.println("E-mail do candidato " + pessoa.email);
//        System.out.println("Usuário do candidato " + pessoa.usuario);
//        return "redirect:/home";
//    }

    @PostMapping("/create")
    public String cadastoCandidate(Model model, Pessoa pessoa){
        System.out.println("Nome do candidato " + pessoa.nome);
        System.out.println("E-mail do candidato " + pessoa.email);
        System.out.println("Usuário do candidato " + pessoa.usuario);

        model.addAttribute("pessoa", pessoa);

        return "candidate/info";
    }

    record Pessoa(String usuario, String email, String nome){

    }

}
