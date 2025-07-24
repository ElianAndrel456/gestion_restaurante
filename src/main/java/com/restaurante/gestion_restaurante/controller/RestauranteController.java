package com.restaurante.gestion_restaurante.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.restaurante.gestion_restaurante.model.Reserva;
import com.restaurante.gestion_restaurante.service.ReservaService;

@Controller
public class RestauranteController {

  @Autowired
  private ReservaService reservaService;

  public RestauranteController() {
  }

  public void listarReservas() {
    try {
      List<Reserva> reservas = reservaService.listarReservas();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

      for (Reserva reserva : reservas) {
        System.out.println("----");
        System.out.println("Reserva por: " + reserva.getNombreCliente());
        System.out.println("Fecha y hora de reserva: " + dateFormat.format(reserva.getFechaReserva()));
        System.out.println("Número de personas: " + reserva.getNumeroPersonas());
        System.out.println("Estado de reserva: " + reserva.getEstado());
        System.out.println("----");
      }
    } catch (Exception e) {
      System.out.println("Error al listar reservas: " + e.getMessage());
    }
  }

  public void registrarReserva(Reserva reserva) {
    try {
      Reserva nuevaReserva = reservaService.registrarReserva(reserva);
      System.out.println("Reserva registrada con éxito:");
      System.out.println("ID de la reserva: " + nuevaReserva.getId());
    } catch (Exception e) {
      System.out.println("Error al registrar la reserva: " + e.getMessage());
    }

  }

  public void actualizarReserva(String clientName) {
    try {
      Reserva reserva = reservaService.cancelarReserva(clientName);
      System.out.println("La reserva del cliente " + reserva.getNombreCliente() + " ha sido cancelada.");
      System.out.println("El id de la reserva es: " + reserva.getId());
      System.out.println("----");

    } catch (Exception e) {
      System.out.println("Error al actualizar la reserva: " + e.getMessage());

    }

  }

  public void obtenerReservaPorNombreDeCliente(String nombreCliente) {
    try {
      Reserva reserva = reservaService.obtenerReservaPorNombreDeCliente(nombreCliente);
      System.out.println("----");
      System.out.println("Reserva por: " + reserva.getNombreCliente());
      System.out.println("Fecha de reserva: " + reserva.getFechaReserva());
      System.out.println("Número de personas: " + reserva.getNumeroPersonas());
      System.out.println("Estado de reserva: " + reserva.getEstado());
      System.out.println("----");

    } catch (Exception e) {
      System.out.println("Error al obtener la reserva: " + e.getMessage());

    }
  }

}
