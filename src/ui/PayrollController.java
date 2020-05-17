package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Company;
import model.Employee;

public class PayrollController {

	@FXML
	private Tab tabCompany;

	@FXML
	private TextField txtCompany;

	@FXML
	private TextField txtNIT;

	@FXML
	private Button btnNext;

	@FXML
	private Button btnModify;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnDelete;

	@FXML
	private TableView<Employee> tableView;

	@FXML
	private TableColumn<Employee, String> nameColumn;

	@FXML
	private TableColumn<Employee, Integer> salaryColumn;

	@FXML
	private TableColumn<Employee, String> idColumn;

	@FXML
	private TableColumn<Employee, String> chargeColumn;

	@FXML
	private TableColumn<Employee, String> depencyColumn;

	@FXML
	private TableColumn<Employee, String> doaColumn;

	@FXML
	private DatePicker jDate;

	@FXML
	private Label lblCompanyName;

	@FXML
	private TextField txtEmployee;

	@FXML
	private TextField txtCategory;

	@FXML
	private TextField txtPeriod;

	@FXML
	private TextField txtEarned;

	@FXML
	private Tab tabEmployee;

	@FXML
	private Tab tabPayroll;

	/*@FXML
	private Tab tabProvisions;*/

	@FXML
	private Label lblNIT;

	@FXML
	private Button btnInvoice;

	@FXML
	private TextField jtDays;

	@FXML
	private TextField jtMorningH;

	@FXML
	private TextField jtEveningH;

	@FXML
	private TextField jtSundayM;

	@FXML
	private TextField jtComission;

	@FXML
	private TextField jtSundayE;

	@FXML
	private Pane mainPane;

	@FXML
	private BorderPane borderPane;

	private Company c;

	public void initialize() {
		c = new Company();
	}

	@FXML
	void showTabs(ActionEvent event) {
		c.setName(txtCompany.getText());
		c.setNit(txtNIT.getText());
		lblCompanyName.setText(c.getName());
		lblNIT.setText(c.getNit());
		tabEmployee.setDisable(false);
		//tabProvisions.setDisable(false);
		tabCompany.setDisable(true);
		try {
			c.importReport(";");
		} catch (IOException e) {
			e.printStackTrace();
		}
		configureTable();
		tableView.setItems(getEmployees());
		// cbPeriod.setItems(cbItems());
		constraints();
	}

	@FXML
	void delete(ActionEvent event) {
		ObservableList<Employee> selected, all;
		all = tableView.getItems();
		selected = tableView.getSelectionModel().getSelectedItems();
		selected.forEach(all::remove);
		try {
			c.exportReport();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void addScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
		Parent addContactPane = fxmlLoader.load();
		borderPane.getChildren().clear();
		borderPane.setCenter(addContactPane);
	}

	@FXML
	void addUser(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Registrado exitosamente!");
		alert.showAndWait();
	}

	@FXML
	void modifyScreen(ActionEvent event) {

	}

	@FXML
	void invoiceScreen(ActionEvent event) throws IOException {
		// if (jtComission.getText() != null && jtDays.getText() != null &&
		// jtEveningH.getText() != null
		// && jtMorningH.getText() != null && jtSundayE.getText() != null &&
		// jtSundayM.getText() != null) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InvoiceGUI.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			InvoiceController ic = fxmlLoader.getController();
			Employee e = c.getIdMap().get(txtEmployee.getText());
			// System.out.println(e);
			e.setWorkedDays(Integer.parseInt(jtDays.getText()));
			e.setCommissions(Integer.parseInt(jtComission.getText()));
			e.setMorningHours(Integer.parseInt(jtMorningH.getText()));
			e.setEveningHours(Integer.parseInt(jtEveningH.getText()));
			e.setSundayMHours(Integer.parseInt(jtSundayM.getText()));
			e.setSundayEHours(Integer.parseInt(jtSundayE.getText()));
			LocalDate d = jDate.getValue();
			String date = d.toString();
			ic.function(e, c, date);
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.setTitle("Factura");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void select(MouseEvent event) {
		String id = tableView.getSelectionModel().getSelectedItem().getId();
		txtEmployee.setText(id);
		tabPayroll.setDisable(false);
	}

	public ObservableList<Employee> getEmployees() {
		ObservableList<Employee> emp = FXCollections.observableArrayList();
		/*
		 * for (int i = 0; i < c.getEmployeeArray().size(); i++) { if
		 * (c.getEmployeeArray().get(i).getState()) {
		 * emp.add(c.getEmployeeArray().get(i));
		 * 
		 * } }
		 */
		for (Employee employee : c.getIdMap().values()) {
			if (employee.getState()) {
				emp.add(employee);
			}
		}
		return emp;

	}

	private void configureTable(){
		nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
		chargeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("charge"));
		depencyColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("dependency"));
		doaColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("dateOfAdmission"));
	}
	
	private void constraints() {
		jtDays.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (!newValue.matches("\\d*")) {
					jtDays.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		jtMorningH.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (!newValue.matches("\\d*")) {
					jtMorningH.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		jtEveningH.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (!newValue.matches("\\d*")) {
					jtEveningH.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		jtSundayM.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (!newValue.matches("\\d*")) {
					jtSundayM.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		jtSundayE.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (!newValue.matches("\\d*")) {
					jtSundayE.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		jtComission.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (!newValue.matches("\\d*")) {
					jtComission.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}

	/*
	 * private ObservableList<String> cbItems() { ObservableList<String> list =
	 * FXCollections.observableArrayList("Mes", "Quincena"); return list; }
	 */
}
