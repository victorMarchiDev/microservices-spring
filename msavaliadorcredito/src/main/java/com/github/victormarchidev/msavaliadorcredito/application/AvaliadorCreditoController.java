package com.github.victormarchidev.msavaliadorcredito.application;

import com.github.victormarchidev.msavaliadorcredito.application.ex.DadosClienteNotFoundException;
import com.github.victormarchidev.msavaliadorcredito.application.ex.ErroComunicacaoMicroservicesException;
import com.github.victormarchidev.msavaliadorcredito.domain.model.DadosAvaliacao;
import com.github.victormarchidev.msavaliadorcredito.domain.model.RetornoAvaliacaoCliente;
import com.github.victormarchidev.msavaliadorcredito.domain.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf){
        try {
           SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
           return ResponseEntity.ok(situacaoCliente);

        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus()))
                    .body(e.getMessage());
        }

    }

    @PostMapping(value = "/avaliacao")
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dados){
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService
                    .realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus()))
                    .body(e.getMessage());
        }
    }

}
