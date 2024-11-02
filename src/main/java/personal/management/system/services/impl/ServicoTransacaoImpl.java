package personal.management.system.services.impl;

import personal.management.system.models.Transacao;
import personal.management.system.services.ServicoTransacao;
import personal.management.system.services.ServicoUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicoTransacaoImpl implements ServicoTransacao {

    List<Transacao> listaTransacao = new ArrayList<>();
    ServicoUsuario servicoUsuario = new ServicoUsuarioImpl();

    @Override
    public boolean verifyInput(String descricao, String valor, String tipo, String categoria) {
        return !descricao.isEmpty() && !valor.isEmpty() && !tipo.isEmpty() && !categoria.isEmpty();
    }

    @Override
    public Transacao adicionarTransacao(String descricao, float valor, String tipo, String categoria, LocalDate data) {
        Transacao novaTransacao = new Transacao();
        novaTransacao.setDescricao(descricao);
        novaTransacao.setTipo(tipo);
        novaTransacao.setValor(valor);
        novaTransacao.setData(data);
        novaTransacao.setCategoria(categoria);
        listaTransacao.add(novaTransacao);

        return novaTransacao;
    }

    @Override
    public List<Transacao> getListaTransacao() {
        return this.servicoUsuario.getLoggedUser().getTransacoes();
    }
}
