package br.edu.ifal.usando_cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CookiesController{

    @GetMapping("/")
    public ModelAndView lerCookie(@CookieValue(value = "primeiroAcesso", defaultValue = "sim")
            String primeiroAcesso, HttpServletResponse response) {

                ModelAndView mv = new ModelAndView("index");

                if (primeiroAcesso.equals("sim")) {
                    
                    mv.addObject("msg",  "este é o seu primeiro acesso");
                }else{
                    mv.addObject("msg", "bem vindo de volta " + primeiroAcesso);
                }    
                return mv;       
    }

    @PostMapping(value = "/form")
    public ModelAndView pegarNomeCookie(
        String primeiroAcesso, HttpServletResponse response, String nome) {
          
                Cookie c = new Cookie("primeiroAcesso", nome);
                response.addCookie(c);
              
           return new ModelAndView("redirect:/");
            
    }

}