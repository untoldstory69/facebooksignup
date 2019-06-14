package FacebookSignUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FacebookSignUpPages.SignUpPage;
import lib.ExcelDataConfig;

public class SignUp {
	
public WebDriver driver;


//TestSetup
	@BeforeTest
	public void beforeTest()
	{
		//configuring browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\untoldstory\\eclipse-workspace1\\External_Jars\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	
	//ActualTest
	@Test
	public void signUp() throws Exception
	{
		driver.get("https://www.facebook.com/");
		
		SignUpPage signUp = PageFactory.initElements(driver, SignUpPage.class);
		
		String currentDir = System.getProperty("user.dir");
		
	//using absoulte path for test data	
		ExcelDataConfig excel = new ExcelDataConfig(currentDir + "\\src\\testData\\testData.xls");
		
		//getting data from sheet1
		int rows = excel.getRowCount(0);
		  
		  for (int i = 1; i < rows; i++)
		  {
			  String fName = excel.getData(0, i, 0);
			  String sName = excel.getData(0, i, 1);
			  String email = excel.getData(0, i, 2);
			  String reEmail = excel.getData(0, i, 3);
			  String newPwd = excel.getData(0, i, 4);
			  String day = excel.getData(0, i, 5);
			  String month = excel.getData(0, i, 6);
			  String year = excel.getData(0, i, 7);
			  String responseMessage = excel.getData(0, i, 8);
			  
			  signUp.signUpUser(fName, sName, email, reEmail, newPwd, day, month, year, responseMessage);
		  }
		 		
	}
	
	//TestTearDown
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}

}
