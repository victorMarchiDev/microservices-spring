package com.github.victormarchidev.mscartoes.application;

import com.github.victormarchidev.mscartoes.domain.Cartao;
import com.github.victormarchidev.mscartoes.representation.CartaoSaveRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cartoes")
public class CartoesController {

    private final CartaoService service;

    public CartoesController(CartaoService service) {
        this.service = service;
    }

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastrarCartao(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        service.save(cartao);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
