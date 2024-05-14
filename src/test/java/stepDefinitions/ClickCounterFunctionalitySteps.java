package stepDefinitions;



import io.cucumber.java.After;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

public class ClickCounterFunctionalitySteps {
    WebDriver driver;
    int expectedCounter;
    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the click counter page with initial count as 0")
    public void iAmOnClickCounterPageWithInitialCountAs0() {
        ///driver.get("https://qaclickcounter.ccbp.tech/");
    	 driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("https://qaclickcounter.ccbp.tech/");
        expectedCounter = 0;
    }

    @When("I click the 'Click Me!' button 5 times")
    public void iClickOnClickMeButtonRepeatedly() {
        for(int i = 0; i < 5; i++) {
            driver.findElement(By.className("button")).click();
            expectedCounter++;
        }
    }

    @Then("the counter should show the count of the clicks")
    public void counterDisplayCountOfClicks() {
        String counterText = driver.findElement(By.className("counter-value")).getText();
        int actualCounter = Integer.parseInt(counterText);
        if(expectedCounter == actualCounter) {
        	Assert.assertTrue(true);
        }else {
        	Assert.fail();
        }
    }
}