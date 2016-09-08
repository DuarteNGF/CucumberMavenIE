package com.Cucumber.MavenCucumberPrototype;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	
	WebDriver driver = null;

	
	@Given("^This is my first dummy given step$")
	public void this_is_my_first_dummy_given_step() throws Throwable {
	   System.out.println("Executed the given step");
	   System.out.println("Testes com Git");
	   System.out.println("Testes com Git e agora GitHub 2tentativa");
	}

	@When("^This is my first dummy when  step$")
	public void this_is_my_first_dummy_when_step() throws Throwable {
		System.out.println("Executed the when step");
	}

	@Then("^This is my first dummy then step$")
	public void this_is_my_first_dummy_then_step() throws Throwable {
		System.out.println("Executed the then step");
	}
	
	@Then("^This is my first dummy then step2$")
	public void this_is_my_first_dummy_then_step2() throws Throwable {
		Assert.assertFalse(true);
	}
	
	
	// Aqui adicionar os Steps para Testes com Web Driver
	
	
	
	@Given("^Entrar no site do olx$")
	public void souldNavigateToOLX() throws Throwable {
		driver = new FirefoxDriver();
		System.out.println("Before method with web tag executed");
	    driver.navigate().to("https://olx.pt/");
	    driver.manage().window().maximize();
	    System.out.println("executed the navigate too OLX");
	}
	    
	@When("^Clicar no link dos \"([^\"]*)\"$")
	public void clicar_no_link_dos(String link) throws Throwable {
		driver.findElement(By.xpath(link)).click();
		System.out.println("executed click link"+link);
	}

	
	@When("^Preencher o formulario$")
	public void ShouldPopulateContacts(DataTable table) throws Throwable {
		System.out.println(table);
		
		List<List<String>> data = table.raw();
		
		System.out.println(data.get(1).get(1));
		
		driver.findElement(By.linkText("-")).click();
		driver.findElement(By.id(data.get(1).get(1))).click();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("-")).click();
	    driver.findElement(By.id(data.get(2).get(1))).click();
	    driver.findElement(By.id("request_description")).clear();
	    driver.findElement(By.id("request_description")).sendKeys(data.get(3).get(1));
	    driver.findElement(By.id("request_anonymous_requester_email")).clear();
	    driver.findElement(By.id("request_anonymous_requester_email")).sendKeys(data.get(4).get(1));
	    driver.findElement(By.id("request_custom_fields_27990841")).click();
	    driver.findElement(By.id("request_custom_fields_27990841")).clear();
	    driver.findElement(By.id("request_custom_fields_27990841")).sendKeys(data.get(5).get(1));
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("footer > input[name=\"commit\"]")).click();
	    Thread.sleep(2000);
	    System.out.println("executed populate form");
	}

	/*@Then("^Validar a mensagem de sucesso \"([^\"]*)\"$")
	public void shouldValidateMessageSucess(String msg) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(msg));
		System.out.println("executed validation message");
		
	}*/
	
	
	@Then("^Validar a mensagem de sucesso OLX \"([^\"]*)\"$")
	public void validar_a_mensagem_de_sucesso_OLX_OLX(String title) throws Throwable {
		Assert.assertTrue(driver.getTitle().contains(title));
		System.out.println("executed validate message");
	}

	@Then("^Fechar o browser$")
	public void shouldCloseBrowser() throws Throwable {
		driver.close();
		System.out.println("After method with web tag executed");
		System.out.println("executed close the browser");
	}
}
