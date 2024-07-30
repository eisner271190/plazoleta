/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.repositories;

import com.plazoleta.demo.infraestructure.jpa.entity.PedidoEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author usuario
 */
@Repository
public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {
    @Query("SELECT p FROM PedidoEntity p WHERE p.id_cliente = :idCliente AND p.estado IN :estados")
    List<PedidoEntity> findByClienteAndEstado(@Param("idCliente") int idCliente, @Param("estados") List<String> estados);
}
