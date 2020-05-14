package ui;

import java.io.IOException;

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
	private Button btnSelect;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnEdit;

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
	private TextField txtCuenta;

	@FXML
	private TextField txtCobro;

	@FXML
	private TextField txtEarned;

	@FXML
	private Tab tabEmployee;

	@FXML
	private Tab tabPayroll;

	private Company c;

	public void initialize() {
		c = new Company();
	}

	@FXML
	void showTabs(ActionEvent event) {
		c.setName(txtCompany.getText());
		c.setNit(txtNIT.getText());
		lblCompanyName.setText(c.getName());
		tabEmployee.setDisable(false);
		tabPayroll.setDisable(false);
		tabCompany.setDisable(true);
		try {
			c.importReport(";");
		} catch (IOException e) {
			e.printStackTrace();
		}
		tableView.setItems(getEmployees());
		System.out.println(c.getEmployeeArray().get(0));
	}
	
	public ObservableList<Employee> getEmployees(){
		ObservableList<Employee> emp = FXCollections.observableArrayList();
		for (int i = 0; i < c.getEmployeeArray().size()-1; i++) {
			emp.add(c.getEmployeeArray().get(i));
		}
		return emp;
	}

}
