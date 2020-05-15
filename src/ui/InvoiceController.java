package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Company;
import model.Employee;
import model.Invoice;

public class InvoiceController {

	/*
	 * @FXML private Label lblCompany;
	 */

	@FXML
	private TextField txtCompany;

	@FXML
	private Label lblNIT;

	@FXML
	private Label lblEmployee;

	@FXML
	private Label lblID;

	@FXML
	private Label lblCharge;

	@FXML
	private Label lblDependency;

	@FXML
	private Label lblSalary;

	@FXML
	private Label lblAux;

	@FXML
	private Label lblDays;

	@FXML
	private Label lblCom;

	@FXML
	private Label lblExtra;

	@FXML
	private Label lblIncome;

	@FXML
	private Label lblDiscountH;

	@FXML
	private Label lblP;

	@FXML
	private Label lblTotalDis;

	@FXML
	private Label lblPayment;

	@FXML
	private Label lblBasic;

	private Invoice iv;

	public void initialize(Employee e, Company c) {
		iv = new Invoice();
		iv.setEmployee(e);
		iv.setCompany(c);
		// lblCompany.setText("Negro");
		lblNIT.setText(c.getNit());
		txtCompany.setText("Negro");
	}

}
