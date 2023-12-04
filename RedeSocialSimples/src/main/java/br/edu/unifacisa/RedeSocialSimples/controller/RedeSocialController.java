package br.edu.unifacisa.RedeSocialSimples.controller;

import br.edu.unifacisa.RedeSocialSimples.repository.ComentarioRepository;
import br.edu.unifacisa.RedeSocialSimples.repository.PostagemRepository;
import br.edu.unifacisa.RedeSocialSimples.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.HTML;

@Controller
public class RedeSocialController {
    private PostagemRepository postRepository;
    private UsuarioRepository userRepository;

    private ComentarioRepository comentRepository;

    public RedeSocialController (PostagemRepository postRepository, UsuarioRepository userRepository, ComentarioRepository comentRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.comentRepository = comentRepository;
    }
}
