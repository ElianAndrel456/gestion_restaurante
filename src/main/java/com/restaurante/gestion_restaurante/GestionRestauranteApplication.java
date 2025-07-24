
package com.restaurante.gestion_restaurante;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.restaurante.gestion_restaurante.controller.RestauranteController;
import com.restaurante.gestion_restaurante.model.Reserva;
import com.restaurante.gestion_restaurante.model.enums.ReservaEstado;

@SpringBootApplication
public class GestionRestauranteApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GestionRestauranteApplication.class, args);

		RestauranteController restauranteController = context.getBean(RestauranteController.class);

		System.out.println("Aplicación de gestión de restaurante iniciada.");

		Boolean close = false;
		Scanner scanner = new Scanner(System.in);

		while (!close) {
			System.out.println("\n-- Menú de Gestión de Reservas --");
			System.out.println("Seleccione una opción:");
			System.out.println("1. Registrar reserva");
			System.out.println("2. Listar reservas activas");
			System.out.println("3. Cancelar reserva");
			System.out.println("4. Obtener reserva por nombre de cliente");
			System.out.println("5. Salir");
			System.out.print("Opción: ");

			int choose;

			try {
				choose = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Por favor, ingrese un número válido.");
				continue;
			}

			switch (choose) {
				case 1:
					System.out.print("Ingrese el nombre del cliente: ");
					String nombreCliente = scanner.nextLine();
					System.out.print("Ingrese la fecha y hora de reserva (YYYY-MM-DD HH:mm): ");
					String fechaHoraReserva = scanner.nextLine();
					System.out.print("Ingrese el número de personas: ");
					String numeroPersonasStr = scanner.nextLine();

					try {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
						LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraReserva, formatter);
						int numeroPersonas = Integer.parseInt(numeroPersonasStr);

						Reserva nuevaReserva = Reserva.builder()
								.nombreCliente(nombreCliente)
								.fechaReserva(Timestamp.valueOf(fechaHora))
								.numeroPersonas(numeroPersonas)
								.estado(ReservaEstado.CONFIRMADA)
								.build();
						restauranteController.registrarReserva(nuevaReserva);
					} catch (DateTimeParseException e) {
						System.out.println("Error en el formato de fecha y hora: " + e.getMessage());
						System.out.println("Formato correcto: YYYY-MM-DD HH:mm (ejemplo: 2025-07-25 19:30)");
					} catch (Exception e) {
						System.out.println("Error en los datos ingresados: " + e.getMessage());
					}
					break;
				case 2:
					restauranteController.listarReservas();
					break;
				case 3:
					System.out.print("Ingrese el nombre del cliente para cancelar la reserva: ");
					String name = scanner.nextLine();
					restauranteController.actualizarReserva(name);
					break;
				case 4:
					System.out.print("Ingrese el nombre del cliente: ");
					String cliente = scanner.nextLine();
					restauranteController.obtenerReservaPorNombreDeCliente(cliente);
					break;

				case 5:
					System.out.println("Saliendo de la aplicación...");
					close = true;
					break;

				default:
					System.out.println("Opción no válida. Por favor, intente de nuevo.");
					break;
			}
		}

		scanner.close();
		context.close();
	}
}
