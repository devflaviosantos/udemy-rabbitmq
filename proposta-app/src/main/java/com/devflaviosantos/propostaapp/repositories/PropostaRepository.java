package com.devflaviosantos.propostaapp.repositories;

import com.devflaviosantos.propostaapp.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropostaRepository extends JpaRepository<Proposta, Integer> {
    Optional<Proposta> findById(Long id);
}
