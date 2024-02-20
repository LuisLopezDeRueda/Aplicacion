package Modelo;

public class Trabajador {

	private String nombre;
	private String contraseña;
	private Boolean superUsuario;

	public Trabajador() {

	}

	public Trabajador(String nombre, String contraseña, Boolean superUsuario) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.superUsuario = superUsuario;
	}

	public Boolean getSuperUsuario() {
		return superUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setSuperUsuario(Boolean superUsuario) {
		this.superUsuario = superUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Trabajador [Nombre=" + nombre + ", contraseña=" + contraseña + ", superUsuario=" + superUsuario + "]";
	}
}
