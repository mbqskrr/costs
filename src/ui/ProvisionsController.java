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

	@FXML
	private Label lblHealth;

	@FXML
	private Label lblPension;

	@FXML
	private Label lblARL;

	@FXML
	private Label lblEmp2;

	@FXML
	private Label lblID2;

	@FXML
	private Label lblICBF;

	@FXML
	private Label lblCC;

	@FXML
	private Label lblSENA;

	private Provisions provisions;

	public void initialize() {

	}

	public void getInfo(int eSalary, int accured, String name, String id) {
		provisions = new Provisions(eSalary, accured);
		lblEmp.setText(name);
		lblID.setText(id);
		lblEmp1.setText(name);
		lblID1.setText(id);
		lblEmp2.setText(name);
		lblID2.setText(id);
		lblVaction.setText("$" + provisions.vacation());
		lblLayoff.setText("$" + provisions.layoffs());
		lblILO.setText("$" + provisions.interestsLo());
		lblPS.setText("$" + provisions.premiumServices());
		lblHealth.setText("$"+provisions.heatlh());
		lblPension.setText("$"+provisions.pension());
		lblARL.setText("$"+provisions.arl());
		lblICBF.setText("$"+provisions.icbf());
		lblCC.setText("$"+provisions.cc());
		lblSENA.setText("$"+provisions.sena());
	}
}
