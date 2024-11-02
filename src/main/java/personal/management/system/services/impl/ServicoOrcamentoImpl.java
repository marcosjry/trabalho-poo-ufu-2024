package personal.management.system.services.impl;

import personal.management.system.models.Orcamento;
import personal.management.system.services.ServicoOrcamento;
import personal.management.system.services.ServicoUsuario;

import java.util.List;
import java.util.ArrayList;

public class ServicoOrcamentoImpl implements ServicoOrcamento {

    private List<Orcamento> orcamentos = new ArrayList<>();
    ServicoUsuario servicoUsuario = new ServicoUsuarioImpl();

    @Override
    public void adicionarOrcamento(Orcamento orcamento) throws Exception {
        if(orcamento != null) {
            this.orcamentos.add(orcamento);
            this.servicoUsuario.getLoggedUser().getOrcamentos().add(orcamento);
            System.out.println(servicoUsuario.getLoggedUser().getOrcamentos());
        } else {
            throw new Exception("Não foi possível adicionar o orçamento.");
        }

    }

    @Override
    public List<Orcamento> getOrcamentos() {
        return this.orcamentos;
    }

    @Override
    public List<String> getCategorias() {
        List<String> categorias = new ArrayList<>();
        for(Orcamento o: this.orcamentos) {
            categorias.add(o.getCategoria());
        }
        return categorias;
    }
}