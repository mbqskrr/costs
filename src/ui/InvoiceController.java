package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
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
	
	@FXML
	private Label lblDate;
	
	@FXML
    private Button btnMore;

	private Invoice iv;
	
	public void function(Employee e, Company c, String date) {
		iv = new Invoice(e, c);
		/*iv.setEmployee(e);
		iv.setCompany(c);*/
		lblDate.setText(date);
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
	
	@FXML
    void more(ActionEvent event) {
		
		try {
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("ProvisionsGUI.fxml"));
			Parent root2;
			root2 = (Parent) fxmlLoader1.load();
			ProvisionsController pc = fxmlLoader1.getController();
			pc.getInfo(iv.getEmployee().getSalary(), getIncome(lblIncome.getText()), lblEmployee.getText(), lblID.getText());
			Stage stage = new Stage();
			stage.setScene(new Scene(root2));
			stage.setTitle("Provisiones");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }

	private int getIncome(String income) {
		int ic;
		String temp = "";
		for (int i = 1; i <income.length(); i++) {
			temp+=income.charAt(i);
		}
		ic = Integer.parseInt(temp);
		return ic;
	}

}
