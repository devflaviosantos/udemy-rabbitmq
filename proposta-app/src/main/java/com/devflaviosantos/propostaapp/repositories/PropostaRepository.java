package com.devflaviosantos.propostaapp.repositories;

import com.devflaviosantos.propostaapp.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    Optional<Proposta> findById(Long id);
}
