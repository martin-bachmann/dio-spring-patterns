package dio.myfirstwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.myfirstwebapi.handler.BusinessException;
import dio.myfirstwebapi.model.Usuario;
import dio.myfirstwebapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UsuarioController {
  @Autowired
  private UsuarioRepository repository;

  @GetMapping
  public List<Usuario> getUsers() {
    return repository.listAll();
  }

  @GetMapping("/{id}")
  public Usuario findById(@PathVariable Integer id) {
    return repository.findById(id);
  }

  @DeleteMapping("{id}")
  public Usuario deleUsuario(@PathVariable Integer id) {
    return repository.findById(id);
  }

  @PostMapping
  public void postUsers(@RequestBody Usuario usuario) {
    if (usuario.getLogin() == null)
      throw new BusinessException("O campo login é obrigatório");
    repository.save(usuario);
  }
}
