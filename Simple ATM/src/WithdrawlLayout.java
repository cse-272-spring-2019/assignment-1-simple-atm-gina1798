


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WithdrawlLayout extends KeypadLayout {
	
	private Stage stage;
	private BankCard bankCard;
	private HomepageLayout homepageLayout;
	private DoneLayout doneLayout;
	private AlertBox alertBox=new AlertBox();

	WithdrawlLayout(Stage stage,BankCard bankCard) {
		this.stage=stage;
		this.bankCard=bankCard;
	}
	
	public void prepareOkButton(Button okButton,TextField numberField)
	{
		okButton.setOnAction(e->{
			
			String stringAmount=numberField.getText();
			numberField.clear();
			if(stringAmount.isEmpty())
				alertBox.display("You have to enter an amount!");
			else {
				double amount= Double.parseDouble(stringAmount);
				boolean check=bankCard.withdraw(amount);
				
				if(check) {
					doneLayout.setMessage(amount + " pounds have been successfully withdrawn.");
					doneLayout.prepareScene();
					stage.setScene(doneLayout.getScene());
				}
			}

		});	
	}
	
	public void prepareCancelButton(Button cancelButton,TextField numberField)
	{
		cancelButton.setOnAction(e->{
			numberField.clear();
			homepageLayout.prepareScene();
			stage.setScene(homepageLayout.getScene());
		});
	}
	
	public void setHomepageLayout(HomepageLayout homepageLayout) {
		this.homepageLayout = homepageLayout;
	}

	public void setDoneLayout(DoneLayout doneLayout) {
		this.doneLayout = doneLayout;
	}
}
