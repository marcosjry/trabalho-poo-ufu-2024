package personal.management.system.services;

import personal.management.system.models.User;

import java.util.List;

public interface ServicoUsuario {

    void cadastrarUsuario(User usuario) throws Exception;

    boolean logarUsuario(User usuario) throws Exception;

    void editarUsuario(User user);

    void setUsuarios(List<User> usuarios);

    List<User> getUsuarios();

    User getLoggedUser();
}
