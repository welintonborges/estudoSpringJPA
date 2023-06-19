package com.springjpa.estudandospringjpa.repositories;

import com.springjpa.estudandospringjpa.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Optional<Pedido> findById(Integer id);

}
