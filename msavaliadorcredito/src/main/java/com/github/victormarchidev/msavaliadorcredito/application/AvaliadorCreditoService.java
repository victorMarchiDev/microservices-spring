package com.github.victormarchidev.msavaliadorcredito.application;

import com.github.victormarchidev.msavaliadorcredito.domain.model.CartaoCliente;
import com.github.victormarchidev.msavaliadorcredito.domain.model.DadosCliente;
import com.github.victormarchidev.msavaliadorcredito.domain.model.SituacaoCliente;
import com.github.victormarchidev.msavaliadorcredito.infra.clients.CartoesResourceClient;
import com.github.victormarchidev.msavaliadorcredito.infra.clients.ClienteResourceClient;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;
    private final CartoesResourceClient cartoesClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesClient.getCartoesCliente(cpf);
        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .cartoes(cartoesResponse.getBody())
                .build();
    }

}
