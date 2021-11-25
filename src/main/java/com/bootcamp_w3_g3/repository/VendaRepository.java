package com.bootcamp_w3_g3.repository;

import com.bootcamp_w3_g3.model.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
