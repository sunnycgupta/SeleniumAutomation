/*'###############################################################################
'-------------------------------------------------------------------------------
' Case Study: Case Study 1
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

import javax.print.DocFlavor.STRING;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

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


public class CaseStudy1_TestScript {

	public static String start_Excel(int sheetno,int rowno,int colno) throws IOException
	{
		
		File src=new File("C:\\Users\\sunny.c.gupta\\workspace\\CaseStudy_Sunny\\Excelinput\\CaseStudy1.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(sheetno);
		String data=sheet.getRow(rowno).getCell(colno).getStringCellValue();
		return data;
	
	}
	
	@Test
	public static void executeScript()throws IOException {
		
		            
            File Result1 = new File("C:\\Users\\sunny.c.gupta\\workspace\\CaseStudy_Sunny\\CaseStudy1_Results\\TestResult1.txt");
            FileOutputStream fos = new FileOutputStream(Result1);
            OutputStreamWriter osw = new OutputStreamWriter(fos);    
            Writer w = new BufferedWriter(osw);
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		WebElement txtuname=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
		Assert.assertEquals(true,txtuname.isDisplayed());
		 w.write("Username is displayed successfully");
		 w.write("\r\n");
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
	    w.write("Navigation sucessfull");
	    w.write("\r\n");	
	    WebElement Rdtriptype=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]"));
	    if(Rdtriptype.isSelected())
	    {
	    	Select ddpassenger=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select")));
	    	ddpassenger.selectByIndex(0);
	    	Select dddepartingfrom=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select")));
	    	dddepartingfrom.selectByIndex(1);
	    	List<WebElement> Totalvalues=dddepartingfrom.getOptions();
	    	
	    	int totalcount=Totalvalues.size();
	    	String[] dropdownvalues=new String[totalcount];
	    	for(int i=0;i<totalcount;i++)
	    	{
	    		dropdownvalues[i]=Totalvalues.get(i).getText();
	    		w.write(dropdownvalues[i]);
	    		w.write("\r\n");
	    	}
	    	
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
	    	Select ddpassenger=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]")));
	    	ddpassenger.selectByIndex(0);
	    	Select dddepartingfrom=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select")));
	    	dddepartingfrom.selectByIndex(1);
	    	List<WebElement> Totalvalues=dddepartingfrom.getOptions();
	    	
	    	int totalcount=Totalvalues.size();
	    	String[] dropdownvalues=new String[totalcount];
	    	for(int i=0;i<totalcount;i++)
	    	{
	    		dropdownvalues[i]=Totalvalues.get(i).getText();
	    		w.write(dropdownvalues[i]);
	    	}
	    	
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
	    w.write("Select a flight page is display");
	    w.write("\r\n");
	    WebElement Rddepartingflight=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")));
	    Rddepartingflight.click();
	    WebElement Rdarrivingflight=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input"));
	    Rdarrivingflight.click();
	    WebElement btnselectioncontinue=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input"));
	    btnselectioncontinue.click();
	    WebElement txtfirstname=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/input")));
	    txtfirstname.sendKeys(start_Excel(0,1,0));
	    WebElement txtlastname=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")));
	    txtlastname.sendKeys(start_Excel(0,1,1));
	    Select ddmeal=new Select(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]/select")));
	    ddmeal.selectByIndex(3);	    
	    Select ddcardtype=new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td/table/tbody/tr[2]/td[1]/select"))));
	    ddcardtype.selectByIndex(2);
	    WebElement txtcardnumber=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td/table/tbody/tr[2]/td[2]/input"))); 
	    txtcardnumber.sendKeys(start_Excel(0,1,2));
	    Select ddcardexpmonth=new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td/table/tbody/tr[2]/td[3]/select[1]"))));
	    ddcardexpmonth.selectByIndex(3);
	    Select ddcardexpyear=new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td/table/tbody/tr[2]/td[3]/select[2]")));
	    ddcardexpyear.selectByIndex(9);
	    WebElement txtcardfname=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[1]/input"));
	    txtcardfname.sendKeys("Adam");
	    WebElement txtcardmname=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input"));
	    txtcardmname.sendKeys("john");
	    WebElement txtcardlname=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[3]/input"));
	    txtcardlname.sendKeys("smith");
	    WebElement btnsecurepurchase=driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[23]/td/input"));
	    btnsecurepurchase.click();
	    
	    WebElement txtitinerarymsg=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]"));
	    String itinerarymsg=txtitinerarymsg.getText();
	    Assert.assertTrue(itinerarymsg.contains("itinerary has been booked!"));
	    w.write("Flight is successfully booked");
	    w.write("\r\n");
	    WebElement btnsignoff=driver.findElement(By.linkText("SIGN-OFF"));
	    btnsignoff.click();
	    driver.quit();
	    w.close();
	    
	}

}
