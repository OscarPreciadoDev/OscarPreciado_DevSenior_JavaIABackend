package com.devSenior.atiende.ticket;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String clienteNombre;

	@Column(nullable = false, length = 120)
	private String clienteContacto;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private CanalTicket canal;

	@Column(nullable = false, length = 2000)
	private String mensaje;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private EstadoTicket estado;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private PrioridadTicket prioridad;

	@Column(nullable = false)
	private LocalDateTime fechaCreacion;

	@Column(nullable = false)
	private LocalDateTime fechaActualizacion;

	public Ticket() {
	}

	@PrePersist
	public void alCrear() {
		LocalDateTime ahora = LocalDateTime.now();
		fechaCreacion = ahora;
		fechaActualizacion = ahora;
	}

	@PreUpdate
	public void alActualizar() {
		LocalDateTime anterior = fechaActualizacion;
		fechaActualizacion = LocalDateTime.now();
		// #region agent log
		agenteLog("H1", "Ticket.alActualizar", "callback PreUpdate",
				"{\"id\":" + id
						+ ",\"identidad\":" + System.identityHashCode(this)
						+ ",\"fechaCreacion\":\"" + fechaCreacion
						+ "\",\"anterior\":\"" + anterior
						+ "\",\"nueva\":\"" + fechaActualizacion
						+ "\",\"igualACreacion\":" + fechaActualizacion.equals(fechaCreacion) + "}");
		// #endregion
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public String getClienteContacto() {
		return clienteContacto;
	}

	public void setClienteContacto(String clienteContacto) {
		this.clienteContacto = clienteContacto;
	}

	public CanalTicket getCanal() {
		return canal;
	}

	public void setCanal(CanalTicket canal) {
		this.canal = canal;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public EstadoTicket getEstado() {
		return estado;
	}

	public void setEstado(EstadoTicket estado) {
		this.estado = estado;
	}

	public PrioridadTicket getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadTicket prioridad) {
		this.prioridad = prioridad;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	// #region agent log
	private static void agenteLog(String hypothesisId, String location, String message, String dataJson) {
		try (var escritor = java.nio.file.Files.newBufferedWriter(
				java.nio.file.Path.of("c:\\Users\\oprec\\Documents\\_ Code\\DEV SENIOR\\JAVA IA ENGINNER\\JAVA IA BACKEND DEVELOPER\\REPOSITORIO\\MODULO 5\\.cursor\\debug-5231f2.log"),
				java.nio.charset.StandardCharsets.UTF_8,
				java.nio.file.StandardOpenOption.CREATE,
				java.nio.file.StandardOpenOption.APPEND)) {
			escritor.write("{\"sessionId\":\"5231f2\",\"runId\":\"pre-fix\",\"hypothesisId\":\"" + hypothesisId
					+ "\",\"location\":\"" + location + "\",\"message\":\"" + message + "\",\"data\":" + dataJson
					+ ",\"timestamp\":" + System.currentTimeMillis() + "}\n");
		} catch (Exception ignorada) {
		}
	}
	// #endregion
}
