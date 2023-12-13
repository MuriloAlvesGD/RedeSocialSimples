package br.edu.unifacisa.RedeSocialSimples.controller;

import br.edu.unifacisa.RedeSocialSimples.model.Postagem;
import br.edu.unifacisa.RedeSocialSimples.model.Usuario;
import br.edu.unifacisa.RedeSocialSimples.repository.PostagemRepository;
import br.edu.unifacisa.RedeSocialSimples.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Controller
public class RedeSocialController {

    @Autowired
    private PostagemRepository postRepository;

    @Autowired
    private UsuarioRepository userRepository;


    @GetMapping ()
    public String inicio(Model model){
        return loginUsuario(model);
    }

    @GetMapping("/login")
    public String loginUsuario (Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @GetMapping("/login/sair")
    public String logout (Model model) {
        model.addAttribute("usuario", null);
        return loginUsuario(model);
    }


    @PostMapping("/login")
    public String acessarConta (@ModelAttribute Usuario usuario, Model model) {
        String email = usuario.getEmail();
        String password = usuario.getPassword();
        Usuario user = userRepository.findFirstUsuarioByEmailAndPassword(email, password);
        if (!(user==null)){
            return forYou(user, model);
        }
        return "login";
    }


    @GetMapping("/login/signIn")
    public String novoUsuario (Model model) {
        model.addAttribute("usuarioCadastrar", new Usuario());
        return "signIn";
    }
    @PostMapping("/login/signIn")
    public String cadastrarUsuario (@ModelAttribute Usuario usuarioCadastrar, Model model) {
        userRepository.save(usuarioCadastrar);
        return loginUsuario(model);
    }

    @GetMapping ("/forYou")
    public String forYou (Usuario usuario,Model model) {
        List<Usuario> otherUsers = userRepository.findUsuariosSuggestions(usuario.getUserID());
        List<Postagem> postagems = postRepository.findFriendPostsOrderByPostDateDesc(usuario.getUserID());

        model.addAttribute("otherUser", new Usuario());
        model.addAttribute("otherUsers", otherUsers);
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuario", usuario);
        model.addAttribute("postagem", new Postagem());
        model.addAttribute("postagems", postagems);
        model.addAttribute("searchUser", new Usuario());

        return "forYou";
    }

    @PostMapping("/forYou/folow/{userID}/{friendID}")
    public String Seguir (@PathVariable Integer userID, @PathVariable Integer friendID, Model model){
        Usuario usuarioA = userRepository.findUsuariosByUserID(userID);
        Usuario usuarioB = userRepository.findUsuariosByUserID(friendID);
        System.out.println(usuarioA.getUserName());
        System.out.println(usuarioB.getUserName());
        usuarioA.getUsuariosB().add(usuarioB);
        userRepository.save(usuarioA);

        return forYou(usuarioA, model);
    }

    @GetMapping("/profile")
    public String profile (Usuario userProfile,Usuario usuario, Model model){
        List<Postagem> postagems = postRepository.findPostsOrderByPostDateDesc(userProfile.getUserID());

        model.addAttribute("postagem", new Postagem());
        model.addAttribute("postagems", postagems);
        model.addAttribute("userProfile", new Usuario());
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuario", usuario);
        return "perfilUser";
    }

    @GetMapping("/profile/sair/{id}")
    public String logout (@PathVariable Integer id, Model model) {
        Usuario usuarioTemp = userRepository.findUsuariosByUserID(id);
        return forYou(usuarioTemp,model);
    }

    @PostMapping("/profile/{id}")
    public String searchProfile (@PathVariable Integer id, @ModelAttribute Usuario searchUser, Model model){
        Usuario userProfile = userRepository.findFirstUsuarioByUserName(searchUser.getUserName());
        Usuario usuario = userRepository.findUsuariosByUserID(id);
        return profile(userProfile, usuario, model);
    }

    @GetMapping("/newPost/{id}")
    public String acessarPostagem (@PathVariable Integer id, Model model){
        Usuario usuario = userRepository.findUsuariosByUserID(id);
        if (!(usuario.equals(null))) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("novaPostagem", new Postagem());
            return "newPost";
        } else {
            return novoUsuario(model);
        }
    }

    @PostMapping("/newPost/{id}")
    public String novaPostagem (@PathVariable Integer id, @ModelAttribute Postagem novaPostagem, Model model) {
        Usuario usuario = userRepository.findUsuariosByUserID(id);
        novaPostagem.setPostDate(LocalDateTime.now(ZoneId.of("UTC-3")));
        novaPostagem.setAuthor(usuario);
        postRepository.save(novaPostagem);
        return forYou(usuario, model);
    }
}
