package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

	@FXML
	private Tab tabProvisions;

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
		tabPayroll.setDisable(false);
		tabProvisions.setDisable(false);
		tabCompany.setDisable(true);
		try {
			c.importReport(";");
		} catch (IOException e) {
			e.printStackTrace();
		}
		configureTable();
		tableView.setItems(getEmployees());
		// cbPeriod.setItems(cbItems());
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
	void addScreen(ActionEvent event) {

	}

	@FXML
	void modifyScreen(ActionEvent event) {

	}

	@FXML
	void invoiceScreen(ActionEvent event) throws IOException {
		if (jtComission.getText()!=null&&jtDays.getText()!=null&&jtEveningH.getText()!=null&&jtMorningH.getText()!=null&&jtSundayE.getText()!=null&&jtSundayM.getText()!=null) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InvoiceGUI.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setScene(new Scene(root1));
				stage.show();
				InvoiceController ic = fxmlLoader.getController();
				ic.initialize(c.getIdMap().get(txtEmployee.getText()), c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void select(MouseEvent event) {
		String id = tableView.getSelectionModel().getSelectedItem().getId();
		/*String name = tableView.getSelectionModel().getSelectedItem().getName();
		int salary = tableView.getSelectionModel().getSelectedItem().getSalary();
		String charge = tableView.getSelectionModel().getSelectedItem().getCharge();
		String dependency = tableView.getSelectionModel().getSelectedItem().getDependency();
		String dateOfAdmission = tableView.getSelectionModel().getSelectedItem().getDateOfAdmission();
		boolean state = false;
		Employee e = new Employee(name, salary, id, charge, dependency, dateOfAdmission, state);
		iv.setEmployee(e);
		iv.setCompany(new Company(lblCompanyName.getText(), lblNIT.getText()));*/
		txtEmployee.setText(id);
		//Employee e = c.getIdMap().get(id);
		//iv.setEmployee(c.getIdMap().get(id));
		
	}

	/*
	 * @Override public void start(Stage primaryStage) { try { Parent root =
	 * FXMLLoader.load(getClass().getResource("InvoiceGUI.fxml"));
	 * primaryStage.setTitle("Factura"); primaryStage.setScene(new Scene(root));
	 * primaryStage.setResizable(true); primaryStage.show(); } catch (Exception e) {
	 * e.getMessage(); } }
	 */

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

	private void configureTable() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
		chargeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("charge"));
		depencyColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("dependency"));
		doaColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("dateOfAdmission"));
	}

	/*
	 * private ObservableList<String> cbItems() { ObservableList<String> list =
	 * FXCollections.observableArrayList("Mes", "Quincena"); return list; }
	 */

}
