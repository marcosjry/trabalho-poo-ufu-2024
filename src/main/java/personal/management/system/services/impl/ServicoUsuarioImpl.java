package personal.management.system.services.impl;

import personal.management.system.models.User;
import personal.management.system.services.ServicoUsuario;

import java.util.ArrayList;
import java.util.List;

public class ServicoUsuarioImpl implements ServicoUsuario {

    private List<User> usuarios = new ArrayList<>();

    private User usuarioLogado = new User();

    //Função para cadastrar um Usuário.
    @Override
    public void cadastrarUsuario(User usuario) throws Exception {

        for(User usuarioCadastrado : usuarios) { //Verificando se o email já está cadastrado.
            if(usuarioCadastrado.getEmail().equals(usuario.getEmail())) {
                throw new Exception("Erro! Usuário já cadastrado.");
            }
        }
        this.usuarios.add(usuario);
    }

    //Função para realizar login do usuário.
    public boolean logarUsuario(User usuario) {
        for(User usuarioCadastrado : usuarios) {
            if(usuarioCadastrado.getEmail().equals(usuario.getEmail()) && usuarioCadastrado.getSenha().equals(usuario.getSenha())) {
                usuarioLogado = usuarioCadastrado;
                return true;
            }
        }
        return false;
    }

    //Função para deslogar o usuário.
    public void deslogarUsuario() {
        usuarioLogado = null;
    }

    //Função para verificar se o usuário está logado.
    /*
    public void garantirAutenticacao() throws Exception {
        if(usuarioLogado == null) {
            throw new Exception("Erro! Usuário não logado.");
        }
    }
    */

    @Override
    public void editarUsuario(User user) {
        usuarioLogado.setNome(user.getNome());
        usuarioLogado.setEmail(user.getEmail());
        usuarioLogado.setSenha(user.getSenha());
    }

    public User getLoggedUser() {
        return this.usuarioLogado;
    }

    @Override
    public List<User> getUsuarios() {
        return this.usuarios;
    }

    @Override
    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }
}