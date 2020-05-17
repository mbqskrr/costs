package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Provisions;

public class ProvisionsController {
	@FXML
	private Label lblEmp;

	@FXML
	private Label lblID;

	@FXML
	private Label lblVaction;

	@FXML
	private Label lblLayoff;

	@FXML
	private Label lblILO;

	@FXML
	private Label lblPS;

	@FXML
	private Label lblEmp1;

	@FXML
	private Label lblID1;
	
	private Provisions provisions;
	
	public void initialize() {
		
	}
	
	public void getInfo(int eSalary, int accured, String name, String id) {
		provisions = new Provisions(eSalary, accured);
		lblEmp.setText(name);
		lblID.setText(id);
		lblVaction.setText("$"+provisions.vacation());
		lblLayoff.setText("$"+provisions.layoffs());
		lblILO.setText("$"+provisions.interestsLo());
		lblPS.setText("$"+provisions.premiumServices());
	}
}
