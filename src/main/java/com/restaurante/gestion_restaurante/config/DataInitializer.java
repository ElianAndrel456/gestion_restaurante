package com.restaurante.gestion_restaurante.config;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restaurante.gestion_restaurante.DAO.ReservasDAO;
import com.restaurante.gestion_restaurante.model.Reserva;
import com.restaurante.gestion_restaurante.model.enums.ReservaEstado;

@Component
public class DataInitializer implements CommandLineRunner {

  @Autowired
  private ReservasDAO reservasDAO;

  @Override
  public void run(String... args) throws Exception {
    // Solo cargar datos si la tabla está vacía
    if (reservasDAO.count() == 0) {
      cargarDatosPrueba();
    }
  }

  private void cargarDatosPrueba() {
    // Reservas CONFIRMADAS (futuras)
    Reserva reserva1 = Reserva.builder()
        .nombreCliente("Juan Pérez")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(19, 30))))
        .numeroPersonas(4)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    Reserva reserva2 = Reserva.builder()
        .nombreCliente("María González")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(20, 0))))
        .numeroPersonas(2)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    Reserva reserva3 = Reserva.builder()
        .nombreCliente("Carlos Rodríguez")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(3), LocalTime.of(18, 45))))
        .numeroPersonas(6)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    Reserva reserva4 = Reserva.builder()
        .nombreCliente("Ana Martínez")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(4), LocalTime.of(21, 0))))
        .numeroPersonas(3)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    Reserva reserva5 = Reserva.builder()
        .nombreCliente("Luis García")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(5), LocalTime.of(19, 15))))
        .numeroPersonas(5)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    // Reservas CANCELADAS
    Reserva reserva6 = Reserva.builder()
        .nombreCliente("Carmen Sánchez")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(6), LocalTime.of(20, 30))))
        .numeroPersonas(2)
        .estado(ReservaEstado.CANCELADA)
        .build();

    Reserva reserva7 = Reserva.builder()
        .nombreCliente("Roberto Jiménez")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.of(18, 0))))
        .numeroPersonas(8)
        .estado(ReservaEstado.CANCELADA)
        .build();

    // Reservas FINALIZADAS (fechas pasadas)
    Reserva reserva8 = Reserva.builder()
        .nombreCliente("Elena Vargas")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(19, 30))))
        .numeroPersonas(4)
        .estado(ReservaEstado.FINALIZADA)
        .build();

    Reserva reserva9 = Reserva.builder()
        .nombreCliente("Miguel Torres")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.of(20, 0))))
        .numeroPersonas(3)
        .estado(ReservaEstado.FINALIZADA)
        .build();

    Reserva reserva10 = Reserva.builder()
        .nombreCliente("Isabel Moreno")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().minusDays(3), LocalTime.of(18, 45))))
        .numeroPersonas(7)
        .estado(ReservaEstado.FINALIZADA)
        .build();

    // Reservas adicionales para más variedad
    Reserva reserva11 = Reserva.builder()
        .nombreCliente("Francisco López")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(8), LocalTime.of(21, 15))))
        .numeroPersonas(1)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    Reserva reserva12 = Reserva.builder()
        .nombreCliente("Patricia Ruiz")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(9), LocalTime.of(19, 0))))
        .numeroPersonas(10)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    Reserva reserva13 = Reserva.builder()
        .nombreCliente("Daniel Herrera")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(10), LocalTime.of(20, 45))))
        .numeroPersonas(2)
        .estado(ReservaEstado.CANCELADA)
        .build();

    Reserva reserva14 = Reserva.builder()
        .nombreCliente("Sofia Castro")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().minusDays(4), LocalTime.of(18, 30))))
        .numeroPersonas(5)
        .estado(ReservaEstado.FINALIZADA)
        .build();

    Reserva reserva15 = Reserva.builder()
        .nombreCliente("Alejandro Morales")
        .fechaReserva(Timestamp.valueOf(LocalDateTime.of(LocalDate.now().plusDays(11), LocalTime.of(20, 15))))
        .numeroPersonas(6)
        .estado(ReservaEstado.CONFIRMADA)
        .build();

    reservasDAO.save(reserva1);
    reservasDAO.save(reserva2);
    reservasDAO.save(reserva3);
    reservasDAO.save(reserva4);
    reservasDAO.save(reserva5);
    reservasDAO.save(reserva6);
    reservasDAO.save(reserva7);
    reservasDAO.save(reserva8);
    reservasDAO.save(reserva9);
    reservasDAO.save(reserva10);
    reservasDAO.save(reserva11);
    reservasDAO.save(reserva12);
    reservasDAO.save(reserva13);
    reservasDAO.save(reserva14);
    reservasDAO.save(reserva15);

  }
}
