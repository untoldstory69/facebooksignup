package FacebookSignUpPages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage {
	@FindBy (how = How.ID, using = "u_0_l")
	WebElement txtFirtsName;
	
	@FindBy (how = How.ID, using ="u_0_n")
	WebElement txtSurName;
	
	@FindBy (how = How.ID, using = "u_0_q")
	WebElement txtEmailAdd;
	
	@FindBy (how = How.ID, using = "u_0_t")
	WebElement txtReEmailAdd;
	
	@FindBy (how = How.ID, using = "u_0_x")
	WebElement txtNewPwd;
	
	@FindBy (how = How.ID, using = "day")
	WebElement selectDayBirthday;
	
	@FindBy (how = How.ID, using = "month")
	WebElement selectMonthBirthday;
	
	@FindBy (how = How.ID, using = "year")
	WebElement selectYearBirthday;
	
	@FindBy (how = How.NAME, using = "sex")
	WebElement rbGender;
	
	@FindBy (how = How.ID, using = "u_0_15")
	WebElement btnSignup;
	
	@FindBy (how = How.CLASS_NAME, using = "uiHeaderTitle")
	WebElement txtConfirm;
	
	//fill in data for signup user
	public void signUpUser(String firstName, String surName, String emailAdd, String reEmailAdd, String newPwd, String day, String month, String year, String responseMessage)
	{
		txtFirtsName.sendKeys(firstName);
		txtSurName.sendKeys(surName);
		txtEmailAdd.sendKeys(emailAdd);
		txtReEmailAdd.sendKeys(reEmailAdd);
		txtNewPwd.sendKeys(newPwd);
		selectDayBirthday.sendKeys(day);
		selectMonthBirthday.sendKeys(month);
		selectYearBirthday.sendKeys(year);
		rbGender.click();
		btnSignup.click();
		
		assertEquals(responseMessage, txtConfirm.getText());
		
		
		
	}
	

}
