/*'###############################################################################
'-------------------------------------------------------------------------------
' Case Study: Case Study 2
' Script Name: TS_BookFlight
' Brief Functional Description: Book a return Journey
' Created On: 08-04-2016
' Created By: 11105218
' Comments/Remmark: Script for the round travel of single passenger
'-------------------------------------------------------------------------------
'###############################################################################
*/





package caseStudy.java;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CaseStudy2_TestScript {

	public static Logger logger=Logger.getLogger(CaseStudy2_TestScript.class);
	
	
	public static String start_Excel(int sheetno,int rowno,int colno) throws IOException{
		File src=new File("C:\\Users\\sunny.c.gupta\\workspace\\CaseStudy_Sunny\\Excelinput\\CaseStudy2.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(sheetno);
		String data=sheet.getRow(rowno).getCell(colno).getStringCellValue();
		return data;
		
		
		}
	public static String convert(String str)
	{
		StringBuffer sb=new StringBuffer(str);
		
		for(int i=0;i<sb.length();i++){
			
			if(sb.charAt(i)<48 || sb.charAt(i)>57)
			{
				sb.deleteCharAt(i);
				i--;
			}
			
		}
		return sb.toString();
	 }
	
	
	@Test
	public static void executeScripts()throws IOException {
		
		
     
         WebDriver driver=new FirefoxDriver();
		logger.warn("Starting the browser");
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		WebElement txtuname=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
		Assert.assertEquals(true,txtuname.isDisplayed());
		logger.warn("Username is displayed successfully");
		
		WebDriverWait wait=new WebDriverWait(driver,40);
		WebElement txtpwd=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input"));
        WebElement btnsign=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input"));
	    txtuname.clear();
	    txtuname.sendKeys("mercury");
	    txtpwd.clear();
	    txtpwd.sendKeys("mercury");
	    btnsign.click();
	    WebElement txtflightdetails=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/font/font/b/font/font")));
	     String txtflight=txtflightdetails.getText();
	    Assert.assertEquals("Preferences",txtflight);
	   logger.warn("Navigation sucessfull");	
	    WebElement Rdtriptype=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]"));
	    if(Rdtriptype.isSelected())
	    {
	    	Select ddpassenger=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select")));
	    	ddpassenger.selectByIndex(1);
	    	Select dddepartingfrom=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select")));
	    	dddepartingfrom.selectByIndex(1);
	    	Select dddepartingmonth=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[1]")));
	    	dddepartingmonth.selectByIndex(6);
	    	Select dddepartingdate=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[2]")));
	    	dddepartingdate.selectByIndex(6);
	    	Select ddarrivingin=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select")));
	    	ddarrivingin.selectByIndex(2);
	    	Select ddreturningmonth=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[1]")));
	    	ddreturningmonth.selectByIndex(7);
	    	Select ddreturningdate=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[2]")));
	    	ddreturningdate.selectByIndex(6);	
	    }
	    else{
	    	Rdtriptype.click();
	    	Select ddpassenger=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select")));
	    	ddpassenger.selectByIndex(1);
	    	Select dddepartingfrom=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select")));
	    	dddepartingfrom.selectByIndex(1);
	    	Select dddepartingmonth=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[1]")));
	    	dddepartingmonth.selectByIndex(6);
	    	Select dddepartingdate=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[2]")));
	    	dddepartingdate.selectByIndex(6);
	    	Select ddarrivingin=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select")));
	    	ddarrivingin.selectByIndex(2);
	    	Select ddreturningmonth=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[1]")));
	    	ddreturningmonth.selectByIndex(7);
	    	Select ddreturningdate=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[2]")));
	    	ddreturningdate.selectByIndex(6);	    	
	    	
	    }
	    WebElement rdserviceclass=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input"));
	    WebElement btncontinue=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input"));
	    if(rdserviceclass.isSelected())
	    {
	    	Select ddairline=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select")));
	    	ddairline.selectByIndex(1);
	    	btncontinue.click();
	    }
	    else{
	    	rdserviceclass.click();
	    	Select ddairline=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select")));
	    	ddairline.selectByIndex(1);
	    	btncontinue.click();
	    	
	    }
	    String selectflightpage=driver.getTitle();
	    Assert.assertTrue(selectflightpage.contains("Select a Flight: Mercury Tours"));
	    logger.warn("Select a flight page is display");
	    WebElement Rddepartingflight=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")));
	    Rddepartingflight.click();
	    WebElement Rdarrivingflight=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input"));
	    Rdarrivingflight.click();
	    WebElement btnselectioncontinue=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input"));
	    btnselectioncontinue.click();  
	     	     
	    
	   	 WebElement txtfirstname1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/input")));
		    txtfirstname1.sendKeys(start_Excel(0,1,0));
		    WebElement txtlastname1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")));
		    txtlastname1.sendKeys(start_Excel(0,1,1));
		    Select ddmeal1=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]/select")));
		    ddmeal1.selectByIndex(3);
	      WebElement txtfirstname2= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[1]/input")));
	      txtfirstname2.sendKeys(start_Excel(0,2,0));
	    WebElement txtlastname2=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[2]/input"));
	    txtlastname2.sendKeys(start_Excel(0,2,1));
	    Select ddmeal2=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[3]/select")));
	    ddmeal2.selectByIndex(4);
	    
	    
	    Select ddcardtype=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[1]/select")));
	    ddcardtype.selectByIndex(3);
	    WebElement txtcardnumber=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input")); 
	    txtcardnumber.sendKeys(start_Excel(0,1,2));
	    WebElement txtDepCost=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]/font"));
	    String DepCosting= txtDepCost.getText();
	    int DepCost=Integer.parseInt(DepCosting);
	    WebElement txtArrCost=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[3]/font"));
	    String ArrCosting= txtArrCost.getText();
	    int ArrCost=Integer.parseInt(ArrCosting);
	    WebElement txtNumOfPass=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/font"));
	    String NumOfPassengers= txtNumOfPass.getText();
	    int NumOfPass=Integer.parseInt(NumOfPassengers);
	    WebElement txtTaxes=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/font"));
	    	   String Taxing= txtTaxes.getText();
	    	  String Taxing1=convert(Taxing);
	    	  int Taxes=Integer.parseInt(Taxing1);
	    	    
	    	 WebElement txtTotal=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/font"));
	    	    String Totaling= txtTotal.getText();
	    	    String Totaling1=convert(Totaling);
	    	    int Total=Integer.parseInt(Totaling1);
	    	 
	    	    if(Total==(DepCost+ArrCost)*NumOfPass+Taxes){
	    	    	
	    	    	logger.warn("Total is properly summed");
	    	    }
	    	    else{
	    	    	logger.warn("Total mismatch");
	    	    }
	    
	    Select ddcardexpmonth=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[3]/select[1]")));
	    ddcardexpmonth.selectByIndex(3);
	    Select ddcardexpyear=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[3]/select[2]")));
	    ddcardexpyear.selectByIndex(9);
	    WebElement txtcardfname=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[1]/input"));
	    txtcardfname.sendKeys("Alan");
	    WebElement txtcardmname=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[2]/input"));
	    txtcardmname.sendKeys("jake");
	    WebElement txtcardlname=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[3]/input"));
	    txtcardlname.sendKeys("salt");
	    WebElement btnsecurepurchase=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[24]/td/input"));
	    btnsecurepurchase.click();
	    WebElement txtitinerarymsg= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")));
	      String itinerarymsg=txtitinerarymsg.getText();
	    Assert.assertTrue(itinerarymsg.contains("itinerary has been booked!"));
	    logger.warn("Flight is successfully booked");
	    WebElement btnsignoff=driver.findElement(By.linkText("SIGN-OFF"));
	    btnsignoff.click();
	    logger.warn("Signing off the Application");
	    driver.quit();
	   
	    
	}

}

