import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.*;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.collections.CollectionUtils;

public class Mate1TC01 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private String email = "abcdefghij";
  private int profileChangeCheck=0, ripOffTextAboutMe=0, ripOffTextPartnerSearch=0;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.mate1.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSetUp() throws Exception {	
	  	 
	driver.get(baseUrl + "/"); 
	int TestCase = 2; //Flip the TestCase numbers to run a particular test case at a time
	switch(TestCase){
	
		case 1:
			//Invoking Test Case 1:
			newProfilePostalCodeEmpty();
			break;
		case 2: 	
			//Invoking Test Case 2:
			profileSetUpNicknameEmpty();
			break;
		case 3:
			//Invoking Test Case 3:
			profileSetUpEmailIllegal();
			break;
		case 4:
			//Invoking Test Case 4;	
			profileSetUpEmailAlpha();
			break;
		case 5:	
			//Invoking Test Case 5:
			profileSetUpEmailEmpty();
			break;
			
		case 6:	
			//Invoking Test Case 6:	
			profileSetUpPasswordEmpty();
			break;
			
		case 7:	
			//Invoking Test Case 7:				
			profileSetUpCorrect();
			break;
			
		case 8:	
			//Invoking Test Case 8:			
			profileEditViewSetUp();
			break;
	
	}
}
  
  //Test Case 1: Postal Code Missing - Error
  private void newProfilePostalCodeEmpty() throws InterruptedException {
		
		    driver.manage().window().maximize();
		  	driver.findElement(By.cssSelector("li")).click();
		    new Select(driver.findElement(By.id("profileGender"))).selectByVisibleText("Woman");
		    driver.findElement(By.cssSelector("option[value=\"3\"]")).click();
		    new Select(driver.findElement(By.id("profileLookingGender"))).selectByVisibleText("Man");
		    driver.findElement(By.cssSelector("#profileLookingGender > option[value=\"2\"]")).click();
		    driver.findElement(By.id("profileLookingMinAge")).click();
		    new Select(driver.findElement(By.id("profileLookingMinAge"))).selectByVisibleText("20");
		    driver.findElement(By.cssSelector("option[value=\"20\"]")).click();
		    new Select(driver.findElement(By.id("profileLookingMaxAge"))).selectByVisibleText("36");
		    driver.findElement(By.cssSelector("#profileLookingMaxAge > option[value=\"36\"]")).click();
		    driver.findElement(By.cssSelector("#country > option[value=\"39\"]")).click();
		    driver.findElement(By.id("submit")).click();
		    
		    System.out.println("ERROR: Postal Code is Empty");
		    Thread.sleep(5000);
		    
		    }
  
  // Test Case 2: Nickname missing: Error
  private void profileSetUpNicknameEmpty() throws InterruptedException {
		profilePage1();
				
		new Select(driver.findElement(By.id("DOBMonth"))).selectByVisibleText("January");
	    driver.findElement(By.cssSelector("option[value=\"01\"]")).click();
	    driver.findElement(By.id("DOBDay")).click();
	    new Select(driver.findElement(By.id("DOBDay"))).selectByVisibleText("04");
	    driver.findElement(By.cssSelector("#DOBDay > option[value=\"02\"]")).click();
	    driver.findElement(By.id("DOBYear")).click();
	    new Select(driver.findElement(By.id("DOBYear"))).selectByVisibleText("1994");
	    driver.findElement(By.cssSelector("option[value=\"1994\"]")).click();
		
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("dilli@def.com");
		
		driver.findElement(By.id("emailConfirmation")).click();
		driver.findElement(By.id("emailConfirmation")).clear();
		driver.findElement(By.id("emailConfirmation")).sendKeys("dilli@def.com");
		
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("target");
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input.submitButton.green")).click();
		Thread.sleep(3000);
		System.out.println("ERROR: NickName is Empty");
		
}
  
  //Test Case 3: Illegal Email Address - Error
  private void profileSetUpEmailIllegal() throws InterruptedException {
		
		profilePage1();
		driver.findElement(By.id("nickName")).click();
		driver.findElement(By.id("nickName")).clear();
		driver.findElement(By.id("nickName")).sendKeys("Neel");
		
		new Select(driver.findElement(By.id("DOBMonth"))).selectByVisibleText("January");
	    driver.findElement(By.cssSelector("option[value=\"01\"]")).click();
	    new Select(driver.findElement(By.id("DOBDay"))).selectByVisibleText("04");
	    driver.findElement(By.cssSelector("#DOBDay > option[value=\"02\"]")).click();
	    new Select(driver.findElement(By.id("DOBYear"))).selectByVisibleText("1994");
	    driver.findElement(By.cssSelector("option[value=\"1994\"]")).click();
		
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("abc");
		
		driver.findElement(By.id("emailConfirmation")).click();
		driver.findElement(By.id("emailConfirmation")).clear();
		driver.findElement(By.id("emailConfirmation")).sendKeys("dilli@def.com");
			
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("abcd");
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input.submitButton.green")).click();
		Thread.sleep(3000);
		System.out.println("ERROR: Email Address is Illegal");


	}
  
//Test Case 4: Illegal characters in Email Address - Error
  private void profileSetUpEmailAlpha() throws InterruptedException {
		
		profilePage1();
		driver.findElement(By.id("nickName")).click();
		driver.findElement(By.id("nickName")).clear();
		driver.findElement(By.id("nickName")).sendKeys("Neel");
		
		new Select(driver.findElement(By.id("DOBMonth"))).selectByVisibleText("January");
	    driver.findElement(By.cssSelector("option[value=\"01\"]")).click();
	    new Select(driver.findElement(By.id("DOBDay"))).selectByVisibleText("04");
	    driver.findElement(By.cssSelector("#DOBDay > option[value=\"02\"]")).click();
	    new Select(driver.findElement(By.id("DOBYear"))).selectByVisibleText("1994");
	    driver.findElement(By.cssSelector("option[value=\"1994\"]")).click();
		
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("abc+2@def.com");
		
		driver.findElement(By.id("emailConfirmation")).click();
		driver.findElement(By.id("emailConfirmation")).clear();
		driver.findElement(By.id("emailConfirmation")).sendKeys("dilli@def.com");
			
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("abcd");
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input.submitButton.green")).click();
		Thread.sleep(3000);
		System.out.println("ERROR: Email Address contains illegal characters");


	}
  
  // Test Case 5: Email Field Empty - Error
  private void profileSetUpEmailEmpty() throws InterruptedException {
		profilePage1();
		driver.findElement(By.id("nickName")).click();
		driver.findElement(By.id("nickName")).clear();
		driver.findElement(By.id("nickName")).sendKeys("Neel");	
		
		//driver.findElement(By.id("DOBMonth")).click();
	    new Select(driver.findElement(By.id("DOBMonth"))).selectByVisibleText("January");
	    driver.findElement(By.cssSelector("option[value=\"01\"]")).click();
	    new Select(driver.findElement(By.id("DOBDay"))).selectByVisibleText("04");
	    driver.findElement(By.cssSelector("#DOBDay > option[value=\"02\"]")).click();
	    new Select(driver.findElement(By.id("DOBYear"))).selectByVisibleText("1994");
	    driver.findElement(By.cssSelector("option[value=\"1994\"]")).click();
	    
	    driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		
		driver.findElement(By.id("emailConfirmation")).click();
		driver.findElement(By.id("emailConfirmation")).clear();
		driver.findElement(By.id("emailConfirmation")).sendKeys("dilli@def.com");
			
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("abcd");
			
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input.submitButton.green")).click();
		System.out.println("ERROR: Email is empty");

	}
  
  //Test Case 6: Password Empty - Error
  private void profileSetUpPasswordEmpty() throws InterruptedException {
		
		profilePage1();
		driver.findElement(By.id("nickName")).click();
		driver.findElement(By.id("nickName")).clear();
		driver.findElement(By.id("nickName")).sendKeys("Neel");
		
		new Select(driver.findElement(By.id("DOBMonth"))).selectByVisibleText("January");
	    driver.findElement(By.cssSelector("option[value=\"01\"]")).click();
	    new Select(driver.findElement(By.id("DOBDay"))).selectByVisibleText("04");
	    driver.findElement(By.cssSelector("#DOBDay > option[value=\"02\"]")).click();
	    new Select(driver.findElement(By.id("DOBYear"))).selectByVisibleText("1994");
	    driver.findElement(By.cssSelector("option[value=\"1994\"]")).click();
	    
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("dilli@def.com");
		
		driver.findElement(By.id("emailConfirmation")).click();
		driver.findElement(By.id("emailConfirmation")).clear();
		driver.findElement(By.id("emailConfirmation")).sendKeys("dilli@def.com");
		
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input.submitButton.green")).click();
		Thread.sleep(3000);
		System.out.println("ERROR: Password Missing");


	}
  
  // Test Case 7: Postal Code, Title, Education Empty: ERROR
  private void profileSetUpCorrect() throws InterruptedException {
	    profilePage1();
		driver.findElement(By.id("nickName")).click();
		driver.findElement(By.id("nickName")).clear();
		driver.findElement(By.id("nickName")).sendKeys("Neel");
		String emailShuffled = shuffleEmail(email);
				
		new Select(driver.findElement(By.id("DOBMonth"))).selectByVisibleText("January");
	    driver.findElement(By.cssSelector("option[value=\"01\"]")).click();
	    new Select(driver.findElement(By.id("DOBDay"))).selectByVisibleText("04");
	    driver.findElement(By.cssSelector("#DOBDay > option[value=\"02\"]")).click();
	    new Select(driver.findElement(By.id("DOBYear"))).selectByVisibleText("1994");
	    driver.findElement(By.cssSelector("option[value=\"1994\"]")).click();
	    
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(emailShuffled+"@def.com");
		
		driver.findElement(By.id("emailConfirmation")).click();
		driver.findElement(By.id("emailConfirmation")).clear();
		driver.findElement(By.id("emailConfirmation")).sendKeys(emailShuffled+"@def.com");
			
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("target");
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input.submitButton.green")).click();
		
		driver.findElement(By.id("headline")).click();
		driver.findElement(By.id("headline")).clear();
				
		driver.findElement(By.id("country")).click();
	    new Select(driver.findElement(By.id("country"))).selectByVisibleText("Canada");
		driver.findElement(By.cssSelector("option[value=\"39\"]")).click();
		
	    driver.findElement(By.id("postalCode")).click();
	    driver.findElement(By.id("postalCode")).clear();
	   	    
	    new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Artist");
	    driver.findElement(By.cssSelector("#occupation > option[value=\"15\"]")).click();
	    
	    new Select(driver.findElement(By.id("relationship"))).selectByVisibleText("Single");
	    driver.findElement(By.cssSelector("#relationship > option[value=\"3\"]")).click();
	    
	   // driver.findElement(By.id("income")).click();
	    new Select(driver.findElement(By.id("income"))).selectByVisibleText("$25,000-$50,000");    
	    driver.findElement(By.cssSelector("#income > option[value=\"4\"]")).click();
	    
	    //driver.findElement(By.id("religion")).click();
	    new Select(driver.findElement(By.id("religion"))).selectByVisibleText("Other");
	    driver.findElement(By.cssSelector("#religion > option[value=\"3\"]")).click();
	    
	    //driver.findElement(By.id("fbCloseButton")).click();
	    new Select(driver.findElement(By.id("height"))).selectByVisibleText("5ft. 6in.");
	    driver.findElement(By.cssSelector("#height > option[value=\"166\"]")).click();
	    
	    //driver.findElement(By.id("ethnicity")).click();
	    new Select(driver.findElement(By.id("ethnicity"))).selectByVisibleText("Asian");
	    driver.findElement(By.cssSelector("#ethnicity > option[value=\"5\"]")).click();
	    
	    //driver.findElement(By.id("bodyType")).click();
	    new Select(driver.findElement(By.id("bodyType"))).selectByVisibleText("Average");
	    driver.findElement(By.cssSelector("#bodyType > option[value=\"5\"]")).click();
	    
	    //driver.findElement(By.id("eyeColor")).click();
	    new Select(driver.findElement(By.id("eyeColor"))).selectByVisibleText("Black");
	    driver.findElement(By.cssSelector("#eyeColor > option[value=\"8\"]")).click();
	    
	    //driver.findElement(By.id("hairColor")).click();
	    new Select(driver.findElement(By.id("hairColor"))).selectByVisibleText("Black");
	    driver.findElement(By.cssSelector("#hairColor > option[value=\"7\"]")).click();
	    
	    //driver.findElement(By.id("smoking")).click();
	    new Select(driver.findElement(By.id("smoking"))).selectByVisibleText("Often");
	    driver.findElement(By.cssSelector("#smoking > option[value=\"5\"]")).click();
	    
	    //driver.findElement(By.id("alcohol")).click();
	    new Select(driver.findElement(By.id("alcohol"))).selectByVisibleText("Occasionally");
	    driver.findElement(By.cssSelector("#alcohol > option[value=\"4\"]")).click();
	    
	    driver.findElement(By.cssSelector("input.submitButton.green")).click();
	    Thread.sleep(5000);
	    
	    System.out.println("ERROR: Postal Code, Title, Education Missing");

	}
  
 
// Test Case 8: Validating the view and edit profile - Changing fields in mini-profile to see the changes displayed
  private void profileEditViewSetUp() throws InterruptedException {
	  	profilePage1();
	  	String emailShuffled = shuffleEmail(email);
		driver.findElement(By.id("nickName")).click();
		driver.findElement(By.id("nickName")).clear();
		driver.findElement(By.id("nickName")).sendKeys("Neel");
		
		new Select(driver.findElement(By.id("DOBMonth"))).selectByVisibleText("January");
	    driver.findElement(By.cssSelector("option[value=\"01\"]")).click();
	    new Select(driver.findElement(By.id("DOBDay"))).selectByVisibleText("04");
	    driver.findElement(By.cssSelector("#DOBDay > option[value=\"02\"]")).click();
	    new Select(driver.findElement(By.id("DOBYear"))).selectByVisibleText("1994");
	    driver.findElement(By.cssSelector("option[value=\"1994\"]")).click();
	    
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(emailShuffled+"@def.com");
		
		driver.findElement(By.id("emailConfirmation")).click();
		driver.findElement(By.id("emailConfirmation")).clear();
		driver.findElement(By.id("emailConfirmation")).sendKeys(emailShuffled+"@def.com");
			
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("target");
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input.submitButton.green")).click();
		
		driver.findElement(By.id("headline")).click();
		driver.findElement(By.id("headline")).clear();
		driver.findElement(By.id("headline")).sendKeys("I am fine!!!");
				
		driver.findElement(By.id("country")).click();
	    new Select(driver.findElement(By.id("country"))).selectByVisibleText("Canada");
		driver.findElement(By.cssSelector("option[value=\"39\"]")).click();
		
		driver.findElement(By.id("postalCode")).click();
	    driver.findElement(By.id("postalCode")).clear();
	    driver.findElement(By.id("postalCode")).sendKeys("H3S1H4");
	    
	    new Select(driver.findElement(By.id("education"))).selectByVisibleText("Graduate degree");
	    driver.findElement(By.cssSelector("#education > option[value=\"7\"]")).click();
	   	    
	    new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Artist");
	    driver.findElement(By.cssSelector("#occupation > option[value=\"15\"]")).click();
	    
	    new Select(driver.findElement(By.id("relationship"))).selectByVisibleText("Single");
	    driver.findElement(By.cssSelector("#relationship > option[value=\"3\"]")).click();
	    
	   // driver.findElement(By.id("income")).click();
	    new Select(driver.findElement(By.id("income"))).selectByVisibleText("$25,000-$50,000");    
	    driver.findElement(By.cssSelector("#income > option[value=\"4\"]")).click();
	    
	    //driver.findElement(By.id("religion")).click();
	    new Select(driver.findElement(By.id("religion"))).selectByVisibleText("Other");
	    driver.findElement(By.cssSelector("#religion > option[value=\"3\"]")).click();
	    
	    //driver.findElement(By.id("fbCloseButton")).click();
	    new Select(driver.findElement(By.id("height"))).selectByVisibleText("5ft. 6in.");
	    driver.findElement(By.cssSelector("#height > option[value=\"166\"]")).click();
	    
	    //driver.findElement(By.id("ethnicity")).click();
	    new Select(driver.findElement(By.id("ethnicity"))).selectByVisibleText("Asian");
	    driver.findElement(By.cssSelector("#ethnicity > option[value=\"5\"]")).click();
	    
	    //driver.findElement(By.id("bodyType")).click();
	    new Select(driver.findElement(By.id("bodyType"))).selectByVisibleText("Average");
	    driver.findElement(By.cssSelector("#bodyType > option[value=\"5\"]")).click();
	    
	    //driver.findElement(By.id("eyeColor")).click();
	    new Select(driver.findElement(By.id("eyeColor"))).selectByVisibleText("Black");
	    driver.findElement(By.cssSelector("#eyeColor > option[value=\"8\"]")).click();
	    
	    //driver.findElement(By.id("hairColor")).click();
	    new Select(driver.findElement(By.id("hairColor"))).selectByVisibleText("Black");
	    driver.findElement(By.cssSelector("#hairColor > option[value=\"7\"]")).click();
	    
	    //driver.findElement(By.id("smoking")).click();
	    new Select(driver.findElement(By.id("smoking"))).selectByVisibleText("Often");
	    driver.findElement(By.cssSelector("#smoking > option[value=\"5\"]")).click();
	    
	    //driver.findElement(By.id("alcohol")).click();
	    new Select(driver.findElement(By.id("alcohol"))).selectByVisibleText("Occasionally");
	    driver.findElement(By.cssSelector("#alcohol > option[value=\"4\"]")).click();
	    
	    driver.findElement(By.cssSelector("input.submitButton.green")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("I promise to upload a photo later")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("close")).click();
	    viewEditProfile();
	    

	}

private void viewEditProfile() throws InterruptedException {
		
	driver.findElement(By.linkText("My Profile")).click();
	driver.findElement(By.linkText("View Profile")).click();
   //driver.findElement(By.id("photoBlockClose")).click();
	driver.findElement(By.linkText("My Profile")).click();
    driver.findElement(By.linkText("Edit my profile")).click();
    
    new Select(driver.findElement(By.id("ethnicity"))).selectByVisibleText("Mixed Race");
    new Select(driver.findElement(By.id("height"))).selectByVisibleText("4ft. 10in.");
    Thread.sleep(4000);
    driver.findElement(By.id("submit_basic_information")).click();
    Thread.sleep(4000);
    
    driver.findElement(By.id("aboutMyself")).click();
    driver.findElement(By.id("aboutMyself")).clear();
    driver.findElement(By.id("aboutMyself")).sendKeys("this is 5145502181, email kaos@vakko.com, web: www.abc.com");    
    Thread.sleep(4000);
    driver.findElement(By.id("submit_about_myself")).click();
    Thread.sleep(4000);
    
    driver.findElement(By.id("lookingFor")).click();
    driver.findElement(By.id("lookingFor")).clear();
    driver.findElement(By.id("lookingFor")).sendKeys("my url is www.kala.com, 4389439088, email id is abc@kaos.com");    
    Thread.sleep(4000);
    driver.findElement(By.id("submit_who_im_looking_for")).click();
    Thread.sleep(4000);
    
    driver.findElement(By.linkText("My Profile")).click();       
    driver.findElement(By.linkText("View Profile")).click();
    Thread.sleep(3000);
    
    verifyChanges();
    	
}

// Method checking if the edited profile is displayed back to the user and if illegal string like URL and email id are stripped off from "profile essay" sections
private void verifyChanges(){
    
    List <WebElement> allElements= driver.findElements(By.cssSelector("div[id='about_myself'] p"));
   	for (WebElement element1: allElements) {
   		if(element1.getText().contains("www.")||element1.getText().contains(".com"));
   			ripOffTextAboutMe++;
   	}
   	   	
   	List <WebElement> allElements2= driver.findElements(By.cssSelector("div[id='who_im_looking_for'] p"));
   	
   	
   	for (WebElement element2: allElements2) {
   		if(element2.getText().contains("www.")||element2.getText().contains(".com"));
   			ripOffTextPartnerSearch++;
   	}
   	       
    List <WebElement> allElement3= driver.findElements(By.cssSelector("ul[class='profileInformation'] li"));
    for (WebElement element3: allElement3) {
    		//System.out.println(element3.getText());
    		if(element3.getText().contains("Mixed")|| element3.getText().contains("4ft. 10in."))
    			profileChangeCheck++;
    	}
    
    if(profileChangeCheck>0)	
    	System.out.println("SUCCESS: The changes made in the basic profile are visible");
    
    if(ripOffTextAboutMe!=0)	
    	System.out.println("SUCCESS: The About Myself section has ripped off any illegal strings like URL and Email id");
    
    if(ripOffTextPartnerSearch!=0)
    	System.out.println("SUCCESS: The What I am Looking For section has ripped off any illegal strings like URL and Email id");
    
    
}

// Profile creation - step 1
private void profilePage1() throws InterruptedException {
	
	  	driver.manage().window().maximize();
	  	driver.findElement(By.cssSelector("li")).click();
	    new Select(driver.findElement(By.id("profileGender"))).selectByVisibleText("Woman");
	    driver.findElement(By.cssSelector("option[value=\"3\"]")).click();
	    new Select(driver.findElement(By.id("profileLookingGender"))).selectByVisibleText("Man");
	    driver.findElement(By.cssSelector("#profileLookingGender > option[value=\"2\"]")).click();
	    driver.findElement(By.id("profileLookingMinAge")).click();
	    new Select(driver.findElement(By.id("profileLookingMinAge"))).selectByVisibleText("20");
	    driver.findElement(By.cssSelector("option[value=\"20\"]")).click();
	    new Select(driver.findElement(By.id("profileLookingMaxAge"))).selectByVisibleText("36");
	    driver.findElement(By.cssSelector("#profileLookingMaxAge > option[value=\"36\"]")).click();
	    driver.findElement(By.cssSelector("#country > option[value=\"39\"]")).click();
	    driver.findElement(By.id(("postalCode"))).click();
	    driver.findElement(By.id(("postalCode"))).clear();
	    driver.findElement(By.id(("postalCode"))).sendKeys("H3S1H4");
	    driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
	
}

// Returns are randomly generated email id, part before the domain name
private String shuffleEmail(String email) {
	
	String shuffledString = ""; 

    while (email.length() != 0)
    {
        int index = (int) Math.floor(Math.random() * email.length());
        char c = email.charAt(index);
        email = email.substring(0,index)+email.substring(index+1);
        shuffledString += c;
    }

    return shuffledString;

}


@After
  public void tearDown() throws Exception {
    driver.quit();
  }
}