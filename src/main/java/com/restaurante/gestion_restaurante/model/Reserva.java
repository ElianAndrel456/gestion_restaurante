package com.restaurante.gestion_restaurante.model;

import java.sql.Timestamp;
import java.util.UUID;

import com.restaurante.gestion_restaurante.model.enums.ReservaEstado;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "reservas")
public class Reserva {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String nombreCliente;
  private Timestamp fechaReserva;
  private int numeroPersonas;
  @Enumerated(EnumType.STRING)
  public ReservaEstado estado;

}
