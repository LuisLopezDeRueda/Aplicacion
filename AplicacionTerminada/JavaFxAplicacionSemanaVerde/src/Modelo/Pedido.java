package Modelo;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Pedido {
	private UUID uidPedido;
	private Cliente cliente;
	private Date fecha;
	private Boolean Cliente;

	public void setCliente(Boolean cliente) {
		Cliente = cliente;
	}

	public UUID getUidPedido() {
		return uidPedido;
	}

	public void setUidPedido(UUID uidPedido) {
		this.uidPedido = uidPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pedido [uidPedido=" + uidPedido + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(uidPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(uidPedido, other.uidPedido);
	}

}
