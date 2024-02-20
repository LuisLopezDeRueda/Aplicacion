package PantallasService;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import Controllers.AppController;
import Modelo.Articulo;
import Modelo.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FacturaService extends AppController {
	@FXML
	private TableView<Articulo> tabla;
	private ObservableList<Articulo> lista;
	@FXML
	private TableColumn<Articulo, Integer> columCanti;
	@FXML
	private TableColumn<Articulo, String> columnaNombre;
	@FXML
	private TableColumn<Articulo, Double> columnaPrecio;
	@FXML
	private Label labelPrecio;
	@FXML
	private Label labelDinero;
	@FXML
	private RadioButton rndEfectivo;
	@FXML
	private RadioButton rndTarjeta;

	@FXML
	private Label lblDescuento;
	private Double precioTotal;

	@FXML
	public void initialize() {
		columCanti.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("cantidad"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
		columnaPrecio.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("precio"));
		lista = FXCollections.observableArrayList();
		lista = getLista();
		tabla.setItems(lista);
	}

	public void actualizarPrecio(Double precio) {

		if (getUsuario() == null) {
			precioTotal = precio;
			labelDinero.setText(precio.toString());
		} else {
			precioTotal = precio * 0.95;
			labelDinero.setText(precio.toString());
			lblDescuento.setText(
					"Descuento por ser cliente: " + new DecimalFormat("#.##").format(new BigDecimal(precio * 0.05)));
		}

	}

	@FXML
	public void salir() {
		CobrarService controler = (CobrarService) irCobrar();
		controler.actualizarLista(lista);
	}

	@FXML
	public void terminarCompra() {
		if (rndEfectivo.isSelected() || rndTarjeta.isSelected()) {
			Venta factura = new Venta();
			factura.setCliente(usuario);
			factura.setArticulos(lista);
			factura.setPrecioTotal(precioTotal);
			service.insertarVenta(factura);
			alertInformativa("Pago terminado correctamente");
			UsuarioService services = (UsuarioService) irUsuario();
			services.empezar();
		} else {
			alertInformativa("Inserte una forma de pago");
		}
	}

	@FXML
	public void tarjeta() {
		rndEfectivo.setSelected(false);
	}

	@FXML
	public void efectivo() {
		rndTarjeta.setSelected(false);
	}

}
