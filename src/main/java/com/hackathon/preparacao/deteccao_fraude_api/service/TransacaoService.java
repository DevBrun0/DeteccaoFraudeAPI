package com.hackathon.preparacao.deteccao_fraude_api.service;

import com.hackathon.preparacao.deteccao_fraude_api.domain.Destino;
import com.hackathon.preparacao.deteccao_fraude_api.domain.InfoDispositivo;
import com.hackathon.preparacao.deteccao_fraude_api.domain.Localizacao;
import com.hackathon.preparacao.deteccao_fraude_api.domain.Transacao;
import com.hackathon.preparacao.deteccao_fraude_api.factory.GerarTransacoes;
import com.hackathon.preparacao.deteccao_fraude_api.utils.LogicaValidacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    LogicaValidacoes logicaValidacoes;
    GerarTransacoes gerarTransacoes;

    public void validarJSON(Transacao transacao) {
        logicaValidacoes.validarMesmaTitularidade(transacao);
    }

    public void validarValorMedioGastoDiario(Transacao transacao){
        logicaValidacoes.validarValorMedioGastoDiario(transacao);
    }

    public List<Transacao> buscarListaDeGastosPorCliente(@PathVariable String id){
        return gerarTransacoes.gerarTransacoesExemplo();
    }

    public List<Transacao> validarQuantidadeTransferencias(@PathVariable String id){
        return gerarTransacoes.gerarTransacoesExemplo();
    }

}
