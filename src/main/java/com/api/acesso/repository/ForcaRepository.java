package com.api.acesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.acesso.entity.Forca;

@Repository
public interface ForcaRepository extends JpaRepository<Forca, Long> {

}
