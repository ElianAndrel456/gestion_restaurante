package com.restaurante.gestion_restaurante.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.gestion_restaurante.model.Reserva;

public interface ReservasDAO extends JpaRepository<Reserva, UUID> {
  Reserva findByNombreCliente(String nombreCliente);

}
