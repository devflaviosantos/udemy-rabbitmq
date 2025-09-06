package com.devflaviosantos.propostaapp.controller;

import com.devflaviosantos.propostaapp.dtos.PropostaRequestDto;
import com.devflaviosantos.propostaapp.dtos.PropostaResponseDto;
import com.devflaviosantos.propostaapp.services.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> salvarProposta(@RequestBody PropostaRequestDto propostaRequestDto) {
        PropostaResponseDto responseDto = propostaService.salvarProposta(propostaRequestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.getId())
                .toUri())
                .body(responseDto);
    }
}
