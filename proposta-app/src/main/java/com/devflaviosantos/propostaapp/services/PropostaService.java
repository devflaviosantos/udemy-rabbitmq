package com.devflaviosantos.propostaapp.services;

import com.devflaviosantos.propostaapp.dtos.PropostaRequestDto;
import com.devflaviosantos.propostaapp.dtos.PropostaResponseDto;
import com.devflaviosantos.propostaapp.entities.Proposta;
import com.devflaviosantos.propostaapp.mapper.PropostaMapper;
import com.devflaviosantos.propostaapp.repositories.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PropostaService {

    private PropostaRepository propostaRepository;
    public PropostaResponseDto salvarProposta(PropostaRequestDto propostaRequestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(propostaRequestDto);
        propostaRepository.save(proposta);

        return PropostaMapper.INSTANCE.convertEntytiToDto(proposta);
    }
}
