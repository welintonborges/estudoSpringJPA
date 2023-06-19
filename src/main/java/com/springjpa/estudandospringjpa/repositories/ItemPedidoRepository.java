package com.springjpa.estudandospringjpa.repositories;

import com.springjpa.estudandospringjpa.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

    Optional<ItemPedido> findById(Integer id);

}
