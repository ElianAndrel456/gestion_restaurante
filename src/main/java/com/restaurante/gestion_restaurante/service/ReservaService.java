package com.restaurante.gestion_restaurante.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.gestion_restaurante.DAO.ReservasDAO;
import com.restaurante.gestion_restaurante.model.Reserva;
import com.restaurante.gestion_restaurante.model.enums.ReservaEstado;

@Service
public class ReservaService {
  @Autowired
  private ReservasDAO reservasDAO;

  public Reserva registrarReserva(Reserva reserva) {

    if (reserva.getNumeroPersonas() > 8) {
      throw new IllegalArgumentException("El máximo de personas por reserva es 8.");
    }

    Timestamp fechaReserva = reserva.getFechaReserva();
    LocalDateTime fechaHora = fechaReserva.toLocalDateTime();
    int hora = fechaHora.getHour();

    if (hora < 12 || hora > 23) {
      throw new IllegalArgumentException("El horario de atención es de 12:00 a 23:00 horas.");
    }

    Reserva reservaExistente = reservasDAO.findByNombreCliente(reserva.getNombreCliente());
    if (reservaExistente != null && reservaExistente.getEstado() == ReservaEstado.CONFIRMADA) {
      throw new IllegalArgumentException("El cliente " + reserva.getNombreCliente()
          + " ya tiene una reserva activa. No se permiten reservas duplicadas.");
    }

    reservasDAO.save(reserva);

    return reserva;

  }

  public List<Reserva> listarReservas() {
    return reservasDAO.findAll().stream()
        .filter(reserva -> reserva.getEstado() == ReservaEstado.CONFIRMADA)
        .toList();
  }

  public Reserva obtenerReservaPorNombreDeCliente(String nombreCliente) {
    return reservasDAO.findByNombreCliente(nombreCliente);
  }

  public Reserva cancelarReserva(String nombreCliente) {
    Reserva reserva = obtenerReservaPorNombreDeCliente(nombreCliente);
    if (reserva != null) {
      reserva.setEstado(ReservaEstado.CANCELADA);
      reservasDAO.save(reserva);
      return reserva;
    } else {
      throw new IllegalArgumentException("No se encontró una reserva para el cliente: " + nombreCliente);
    }

  }

}