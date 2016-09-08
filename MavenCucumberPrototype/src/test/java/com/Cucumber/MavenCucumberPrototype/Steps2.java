package com.Cucumber.MavenCucumberPrototype;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps2 {
	WebDriver driver = null;
	
	
	@Given("^Entrar na pagina de testes cucumber$")
	public void entrar_na_pagina_de_testes_cucumber() throws Throwable {
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		
	}

	@When("^Ir ao link \"([^\"]*)\"$")
	public void ir_ao_link(String link) throws Throwable {
		driver.findElement(By.id(link.toLowerCase()+"_link")).click();
	}

	@Then("^Selecionar dropdown e escolher \"([^\"]*)\"$")
	public void selecionar_dropdown_e_escolher(String dropItem) throws Throwable {
	    Select DropDown = new Select(driver.findElement(By.id("start_select")));
	    DropDown.selectByVisibleText(dropItem);
	}

	@Then("^Prencher formulario$")
	public void prencher_formulario() throws Throwable {
	    driver.findElement(By.name("name_field")).sendKeys("Duarte");
	    driver.findElement(By.id("rinfo")).click();
	    driver.findElement(By.id("cdona")).click();
	    driver.findElement(By.name("address_field")).sendKeys("Rua da Batata pordre");
	    driver.findElement(By.name("postcode_field")).sendKeys("2222");
	    driver.findElement(By.name("email_field")).sendKeys("Duarte@Joao.com");
	    driver.findElement(By.id("submit_message")).click();
	}
	
	@Then("^Fechar o browser2$")
	public void shouldCloseBrowser() throws Throwable {
		driver.close();
		System.out.println("After method with web tag executed");
		System.out.println("executed close the browser");
	}

}