package personal.management.system.services;

import personal.management.system.models.Transacao;

import java.time.LocalDate;
import java.util.List;

public interface ServicoTransacao {
    boolean verifyInput(String descricao, String valor, String tipo, String categoria);

    Transacao adicionarTransacao(String descricao, float valor, String tipo, String categoria, LocalDate data);

    List<Transacao> getListaTransacao();
}
