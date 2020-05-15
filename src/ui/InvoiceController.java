package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Company;
import model.Employee;
import model.Invoice;

public class InvoiceController implements Initializable{

	/*
	 * @FXML private Label lblCompany;
	 */

	@FXML
	private Label lblCompany;

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
	
	public void function(Employee e, Company c) {
		iv = new Invoice(e, c);
		/*iv.setEmployee(e);
		iv.setCompany(c);*/
		lblEmployee.setText(e.getName());
		lblID.setText(e.getId());
		lblCharge.setText(e.getCharge());
		lblDependency.setText(e.getDependency());
		lblNIT.setText(c.getNit());
		lblCompany.setText(c.getName());
		lblSalary.setText("$"+e.getSalary());
		lblAux.setText("$"+iv.auxTrans());
		lblDays.setText(""+e.getWorkedDays());
		lblBasic.setText("$"+iv.basic());
		lblCom.setText("$"+e.getCommissions());
		lblExtra.setText("$"+iv.overtime());
		lblIncome.setText("$"+iv.totalAccrued());
		lblDiscountH.setText("$"+iv.health());
		lblP.setText("$"+iv.pension());
		lblTotalDis.setText("$"+iv.totalDeducted());
		lblPayment.setText("$"+iv.payment());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
