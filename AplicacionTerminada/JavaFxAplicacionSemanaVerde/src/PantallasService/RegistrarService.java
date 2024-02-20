package PantallasService;

import Controllers.AppController;
import Modelo.Trabajador;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrarService extends AppController {
	@FXML
	private TextField tfUsuario;
	@FXML
	private PasswordField contraseña;
	@FXML
	private PasswordField repetirContraseña;
	@FXML
	private CheckBox cbSuperUsuario;

	@FXML
	public void atras() {
		irIniciarSesion();
	}

	@FXML
	public void crearTrabajador() {
		if (contraseña.getText().isBlank() || repetirContraseña.getText().isBlank()) {
			alert("Las contraseñas no pueden estar vacias");
			limpiarContraseñas();
			return;
		} else if (contraseña.getText().equals(repetirContraseña.getText())) {
			if (service.consultarTrabajadorSinContreseña(tfUsuario.getText()) != null) {
				alert("Ya existe un usuario con ese nombre");
				limpiarNombre();
			} else {

				service.insertarTrabajador(
						new Trabajador(tfUsuario.getText(), contraseña.getText(), cbSuperUsuario.isSelected()));
				alertInformativa("USUARIO CREADO CORRECTAMENTE");
				irIniciarSesion();
			}

		} else {
			alert("Contraseñas no validas");
			limpiarContraseñas();
			return;
		}
	}

	public void limpiarContraseñas() {
		contraseña.setText("");
		repetirContraseña.setText("");
	}

	public void limpiarNombre() {
		tfUsuario.setText("");
	}

}
