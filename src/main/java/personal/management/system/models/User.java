package personal.management.system.models;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String nome;
    private String email;
    private String senha;
    private List<Transacao> transacoes = new ArrayList<>();
    private List<Agendamento> agendamentos = new ArrayList<>();
    private List<Orcamento> orcamentos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public List<Orcamento> getOrcamentos() {
        return this.orcamentos;
    }

}
