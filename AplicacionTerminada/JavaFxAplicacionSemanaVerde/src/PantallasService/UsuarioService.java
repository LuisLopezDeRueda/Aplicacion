package PantallasService;

import Controllers.AppController;
import Modelo.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UsuarioService extends AppController {

	@FXML
	private TextField tfdni;
	private Boolean correcto;
	@FXML
	private Button btArticulo;
	@FXML
	private Label lblDNI;

	public UsuarioService() {
		correcto = false;
	}

	@FXML
	public void initialize() {
		usuario = new Cliente();
	}

	@FXML
	public void gestionarArticulos() {
		irGestoriarArticulos();
	}

	public void empezar() {
		if (trabajador.getSuperUsuario()) {
			btArticulo.setVisible(true);
		} else {
			btArticulo.setVisible(false);
		}
	}

	@FXML
	public void clienteExistente() {
		if (correcto) {
			Cliente cliente = service.consultarCliente(codificar(tfdni.getText()));
			if (cliente != null) {
				setUsuario(cliente);
				irCobrar();
			} else {
				alertInformativa("No hay usuario con ese dni");
			}
		} else {
			tfdni.setDisable(false);
			lblDNI.setVisible(true);
			correcto = true;
		}
	}

	@FXML
	public void atras() {
		irIniciarSesion();
	}

	@FXML
	public void noUsuario() {
		irCobrar();
	}

	@FXML
	public void crearClietne() {
		irCrearCliente();
	}

}
