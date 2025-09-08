package com.devflaviosantos.propostaapp.controller;

import com.devflaviosantos.propostaapp.dtos.PropostaRequestDto;
import com.devflaviosantos.propostaapp.dtos.PropostaResponseDto;
import com.devflaviosantos.propostaapp.services.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;
aty<PropostaResponseDto> salvarProposta(@RequestBody PropostaRequestDto propostaRequestDto) {
        PropostaResponseDto responseDto = propostaService.salvarProposta(propostaRequestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.getId())
                .toUri())
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterProposta() {
         return ResponseEntity.ok(propostaService.obterProposta());
    }
}
