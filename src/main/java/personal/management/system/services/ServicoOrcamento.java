package personal.management.system.services;

import personal.management.system.models.Orcamento;

import java.util.List;

public interface ServicoOrcamento {

    void adicionarOrcamento(Orcamento orcamento) throws Exception;

    List<Orcamento> getOrcamentos();

    List<String> getCategorias();
}
