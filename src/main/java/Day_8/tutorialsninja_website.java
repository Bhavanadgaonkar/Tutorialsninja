package Day_8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class tutorialsninja_website {
	//Launch the application http://tutorialsninja.com/demo/index.php
	WebDriver chromedriver;

	@Test(priority=1)
	public void browser_launch() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhava\\eclipse-workspace\\tutorialsninja_pgm\\src\\test\\resources\\drivers\\chromedriver.exe");
		chromedriver=new ChromeDriver();
		chromedriver.get("http://tutorialsninja.com/demo/index.php");
		chromedriver.manage().window().maximize();
		Thread.sleep(1000);
	
	}
	@Test(priority=2)
	public void website_details() throws InterruptedException {
		 // 2.Select the currency in the left top corner to Euro
			WebElement currencyDetailsEle=chromedriver.findElement(By.xpath("//span[contains(text(),'Currency')]"));
			currencyDetailsEle.click();
		    WebElement currencyEle=chromedriver.findElement(By.xpath("//button[contains(text(),'€ Euro')]"));
	        currencyEle.click();
	        
	     // 3.Try to order a canon EOS 5 D camera and collect the error message occurred due to a bug in select option.
	        WebElement canonEle=chromedriver.findElement(By.linkText("Canon EOS 5D"));
	        canonEle.click();
	        WebElement devicedetails=chromedriver.findElement(By.id("input-option226"));
	        devicedetails.click();
	       
	
	        
	    // 4 Move to the home screen, Click on iphone and go to details screen 
	        chromedriver.navigate().back();
	        WebElement iphoneEle=chromedriver.findElement(By.linkText("iPhone"));//Click on i_phone
	        iphoneEle.click();
	        WebElement qtyEle=chromedriver.findElement(By.id("input-quantity")); //change the quantity to two then add to cart
	        qtyEle.clear();
	        qtyEle.sendKeys("2");
	   //5 Click on the cart icon (black color) in the right side top then click view cart
	        WebElement addTocartEle=chromedriver.findElement(By.id("button-cart"));
	        addTocartEle.click();
	        System.out.println("Successfully Added into the cart .....");
	        WebElement cartEle=chromedriver.findElement(By.xpath("//div[3]/div/button"));
	        cartEle.click();
	        Thread.sleep(1000);
	        WebElement viewCartEle=chromedriver.findElement(By.linkText("View Cart"));
	        viewCartEle.click();
	        
	    //Change the quantity of iphone to 3 and click update button 
	        WebElement changeqtycartEle=chromedriver.findElement(By.xpath("//td/div/input"));
	        changeqtycartEle.clear();
	        changeqtycartEle.sendKeys("3");
	        WebElement updateEle=chromedriver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
	        updateEle.click();
	        
	     // Print the Eco tax and VAT Amount in console and click Checkout button
	        
	        WebElement ecoTaxdetails=chromedriver.findElement(By.xpath("//body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]"));
	        System.out.println("Eco Tax (-2.00):"+ecoTaxdetails.getText());
	        Thread.sleep(500);
	        WebElement vatTaxDetails=chromedriver.findElement(By.xpath("//body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]"));
	        System.out.println("VAT (20%):"+vatTaxDetails.getText());
	        WebElement checkoutEle=chromedriver.findElement(By.xpath("//a[contains(text(),'Checkout')]"));
	        checkoutEle.click();
	        
	    // Print the error message and remove the product from the cart
	        WebElement errormsg=chromedriver.findElement(By.xpath("//body/div[@id='checkout-cart']/div"));
	        System.out.println(errormsg.getText());
	        WebElement delEle=chromedriver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[2]/i[1]"));
	        delEle.click();
	        Thread.sleep(1000);
	     //Move to the home screen and click on Mac book, check the default quantity is 1 and click add to cart then verify success message
	        WebElement continueEle=chromedriver.findElement(By.xpath("//body/div[@id='error-not-found']/div[1]/div[1]/div[1]/div[1]"));
	        continueEle.click();
	        WebElement macBookEle=chromedriver.findElement(By.linkText("MacBook"));//Click on macbook
	        macBookEle.click();
	        WebElement macqtyEle=chromedriver.findElement(By.id("input-quantity"));//check the quantity to one then add to cart
	       macqtyEle.click();
	        WebElement macTocartEle=chromedriver.findElement(By.id("button-cart"));
	        macTocartEle.click();
	        JavascriptExecutor js = (JavascriptExecutor) chromedriver;
			js.executeScript("window.scrollBy(350,0)", "");
			WebElement successmsgEle=chromedriver.findElement(By.xpath("//body/div[@id='product-product']/div"));
			System.out.println(successmsgEle.getText());
	       WebElement maccartEle=chromedriver.findElement(By.xpath("//div[3]/div/button"));
	        maccartEle.click();
	        Thread.sleep(1000);
	    //Click on the shopping cart link in the top and apply ABCD123 as coupon code to check, print error message
	        WebElement macviewCartEle=chromedriver.findElement(By.linkText("View Cart"));
	        macviewCartEle.click();
	        WebElement couponEle=chromedriver.findElement(By.linkText("Use Coupon Code"));
	        couponEle.click();
	        Thread.sleep(500);
	        WebElement couponCodeEle=chromedriver.findElement(By.id("input-coupon"));
	        couponCodeEle.sendKeys("ABCD123");
	        WebElement couponApplyEle=chromedriver.findElement(By.id("button-coupon"));
	        couponApplyEle.click();
	        JavascriptExecutor jse = (JavascriptExecutor) chromedriver;
		    jse.executeScript("window.scrollBy(0,350)", "");
		    //WebElement codeerrormsg=chromedriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	        //System.out.println(codeerrormsg.getText());
	        //Thread.sleep(1000);
		//Enter AXDFGH123 as gift certificate and perform apply to check, print error message    
	        WebElement giftEle=chromedriver.findElement(By.linkText("Use Gift Certificate"));
	        giftEle.click();
	        jse.executeScript("window.scrollBy(0,350)", "");
	        WebElement giftCodeEle=chromedriver.findElement(By.id("input-voucher"));
	        giftCodeEle.sendKeys("AXDFGH123");
	        WebElement giftApplyEle=chromedriver.findElement(By.id("button-voucher"));
	        giftApplyEle.click();
	        JavascriptExecutor jse1 = (JavascriptExecutor) chromedriver;
			jse1.executeScript("window.scrollBy(350,0)", "");
			WebElement codeerrormsgEle=chromedriver.findElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
	        System.out.println(codeerrormsgEle.getText());
		//Clear both textbox values and proceed to checkout
			WebElement maccheckout1Ele=chromedriver.findElement(By.xpath("//a[contains(text(),'Checkout')]"));
	        maccheckout1Ele.click();
	        Thread.sleep(1000);
	}
	        @Test(priority=4)
	        public void registration_details() throws InterruptedException {
	     //Select register account option and enter all account and billing details, click continue
	       
	        WebElement registerAccEle=chromedriver.findElement(By.xpath("//input[@value='register']"));
	        registerAccEle.click(); 
	        Thread.sleep(1000);
	        Actions action=new Actions(chromedriver);
	        WebElement regaccEle=chromedriver.findElement(By.id("button-account"));
	        action.moveToElement(regaccEle);
	        regaccEle.click();
	        Thread.sleep(1000);
	     //enter all account and billing details, click continue
	        WebElement firstnmEle=chromedriver.findElement(By.id("input-payment-firstname"));
	        firstnmEle.sendKeys("Bhavana");
	        WebElement lastnmEle=chromedriver.findElement(By.id("input-payment-lastname"));
	        lastnmEle.sendKeys("Selenium");
	        WebElement mailEle=chromedriver.findElement(By.id("input-payment-email"));
	        mailEle.sendKeys("vaz5678901@gmail.com");
	        WebElement mobileNoEle=chromedriver.findElement(By.id("input-payment-telephone"));
	        mobileNoEle.sendKeys("9876543210");
	        WebElement passwordEle=chromedriver.findElement(By.id("input-payment-password"));
	        passwordEle.sendKeys("abc1234");
	        WebElement passwordConfirmEle=chromedriver.findElement(By.id("input-payment-confirm"));
	        passwordConfirmEle.sendKeys("abc1234");
	        WebElement companyEle=chromedriver.findElement(By.id("input-payment-company"));
	        companyEle.sendKeys("TCS");
	        WebElement address1Ele=chromedriver.findElement(By.id("input-payment-address-1"));
	        address1Ele.sendKeys("14,Geeta Bunglow");
	        WebElement address2Ele=chromedriver.findElement(By.id("input-payment-address-2"));
	        address2Ele.sendKeys("Near Water Tank");
	        WebElement cityEle=chromedriver.findElement(By.id("input-payment-city"));
	        cityEle.sendKeys("Mumbai");
	        WebElement pincodeEle=chromedriver.findElement(By.id("input-payment-postcode"));
	        pincodeEle.sendKeys("477008");
	        WebElement countryEle=chromedriver.findElement(By.id("input-payment-country"));
	        Select country=new Select(countryEle);
	        country.selectByVisibleText("India");
	        Thread.sleep(500);
	        WebElement regionEle=chromedriver.findElement(By.id("input-payment-zone"));
	        Select region =new Select(regionEle);
	        region.selectByVisibleText("Maharashtra");
	        WebElement newsletterEle=chromedriver.findElement(By.id("newsletter")); 
	        newsletterEle.click();
	        
	        WebElement privacyEle=chromedriver.findElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/input[1]")); 
	        privacyEle.click();
	        WebElement buttonEle=chromedriver.findElement(By.id("button-register")); 
	        buttonEle.click();
	       
	      //Add comments, click continue and check the error message related to payment method  
	       
	        Thread.sleep(1000);
	        WebElement commentEle=chromedriver.findElement(By.xpath("//textarea[@name='comment']")); 
	        commentEle.click();
	        commentEle.sendKeys("We Like the Product.........Please increase Product's quantity..???");
	        WebElement tickcheckboxEle=chromedriver.findElement(By.xpath("//input[@name='agree']"));
	        tickcheckboxEle.click();
	        WebElement paymentbuttonEle=chromedriver.findElement(By.id("button-payment-method"));
	        paymentbuttonEle.click();
	        Thread.sleep(500);
	        WebElement errormsgEle=chromedriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	        System.out.println(errormsgEle.getText());
	        } 
	      //Click on contact us hyperlink and submit a contact request and click continuePart -2
	        @Test(priority=5)
	        public void billingdetails() throws InterruptedException {
	        WebElement billingDetailsEle=chromedriver.findElement(By.xpath("//a[normalize-space()='Step 2: Billing Details']"));
	        billingDetailsEle.click();
	        WebElement existingaddressEle=chromedriver.findElement(By.xpath("//label[normalize-space()='I want to use an existing address']"));
	        existingaddressEle.click();
	        Actions action2=new Actions(chromedriver);
	        WebElement buttonpayEle=chromedriver.findElement(By.id("button-payment-address"));
	        action2.moveToElement(buttonpayEle);
	        buttonpayEle.click();
	        WebElement contactusEle=chromedriver.findElement(By.linkText("Contact Us"));
	        contactusEle.click();
	        Thread.sleep(500);
	        WebElement enquiryEle=chromedriver.findElement(By.id("input-enquiry"));
	        enquiryEle.sendKeys("payment details not displayed .....not able to place the order..........");
	        Actions action1=new Actions(chromedriver);
	        WebElement enquirybuttonEle=chromedriver.findElement(By.xpath("//input[@value='Submit']"));
	        action1.moveToElement(enquirybuttonEle);
	        enquirybuttonEle.click();
	     	        
	        
	       }
	     
	        
	                 
	               
	
	        }
				
	
			

