package com.devflaviosantos.propostaapp.mapper;

import com.devflaviosantos.propostaapp.dtos.PropostaRequestDto;
import com.devflaviosantos.propostaapp.dtos.PropostaResponseDto;
import com.devflaviosantos.propostaapp.entities.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(target="usuario.nome", source = "nome")
    @Mapping(target="usuario.sobrenome", source = "sobrenome")
    @Mapping(target="usuario.cpf", source = "cpf")
    @Mapping(target="usuario.telefone", source = "telefone")
    @Mapping(target="usuario.renda", source = "renda")
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);

    @Mapping(target="nome", source = "usuario.nome")
    @Mapping(target="sobrenome", source = "usuario.sobrenome")
    @Mapping(target="cpf", source = "usuario.cpf")
    @Mapping(target="telefone", source = "usuario.telefone")
    @Mapping(target="renda", source = "usuario.renda")
    PropostaResponseDto convertEntytiToDto(Proposta proposta);

    List<PropostaResponseDto> convertListEntityToListDto(Iterable<Proposta> propostas);
}

