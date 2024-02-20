package PantallasService;

import Controllers.AppController;
import Service.ArticuloException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BorrarArticuloService extends AppController {
	@FXML
	private TextField tfCodigo;

	@FXML
	public void borrar() {
		try {
			service.borrarArticulo(service.consultarArticulo(tfCodigo.getText()));
			alertInformativa("Articulo con el codigo " + tfCodigo.getText() + " borrado correctamente");
			tfCodigo.setText("");
		} catch (ArticuloException e) {
			alertInformativa(e.getMessage());
		}
	}

	@FXML
	public void atras() {
		irGestoriarArticulos();
	}
}
