package com.github.victormarchidev.mscartoes.application;

import com.github.victormarchidev.mscartoes.domain.Cartao;
import com.github.victormarchidev.mscartoes.domain.CartaoCliente;
import com.github.victormarchidev.mscartoes.representation.CartaoSaveRequest;
import com.github.victormarchidev.mscartoes.representation.CartoesPorClienteResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
public class CartoesController {

    private final CartaoService service;
    private final ClienteCartaoService clienteService;

    public CartoesController(CartaoService service, ClienteCartaoService clienteService) {
        this.service = service;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastrarCartao(@RequestBody CartaoSaveRequest request){
        var cartao = request.toModel();
        service.save(cartao);
        System.out.println(cartao.toString());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> list = service.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf")
                                                                                   String  cpf){
        List<CartaoCliente> lista = clienteService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> resultList = lista.stream()
                .map(CartoesPorClienteResponse::fromModel)
                .toList();
        return ResponseEntity.ok(resultList);
    }


}
