package com.github.victormarchidev.mscartoes.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victormarchidev.mscartoes.domain.Cartao;
import com.github.victormarchidev.mscartoes.domain.CartaoCliente;
import com.github.victormarchidev.mscartoes.domain.DadosSolicitacaoCartao;
import com.github.victormarchidev.mscartoes.infra.repository.CartaoRepository;
import com.github.victormarchidev.mscartoes.infra.repository.ClienteCartaoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {

    private final CartaoRepository repo;
    private final ClienteCartaoRepository repoCli;

    public EmissaoCartaoSubscriber(CartaoRepository repo, ClienteCartaoRepository repoCli) {
        this.repo = repo;
        this.repoCli = repoCli;
    }

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DadosSolicitacaoCartao dados =  mapper.readValue(payload, DadosSolicitacaoCartao.class);
            Cartao cartao =  repo.findById(dados.getIdCartao()).orElseThrow();
            CartaoCliente cartaoCliente = new CartaoCliente();
            cartaoCliente.setCartao(cartao);
            cartaoCliente.setCpf(dados.getCpf());
            cartaoCliente.setLimite(dados.getLimiteLiberado());

            repoCli.save(cartaoCliente);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
