package com.Cucumber.MavenCucumberPrototype;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsIE {

	WebDriver driver = null;
	
	private Scenario scenario = null;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
	
    }
    
	@Given("^Abrir browser$")
	public void entrar_no_IE() throws Throwable {
		File fileIE = new File("webdrivers//IEDriverServer.exe");
		
		System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());
	        
	     DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	     capabilities.setCapability("ie.ensureCleanSession", true);
	     //capabilities.setCapability("ignoreZoomSetting", true);
	


	     driver = new InternetExplorerDriver(capabilities);
	     Thread.sleep(3000);
	     driver.get("http://10.141.3.41:6800/spl/loginPage.jsp#rdr2");
	     
	     System.out.println("Está a bombar entrar_no_IE()");
	     
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	     Thread.sleep(8000);	
		
	}

	@When("^Fazer login$")
	public void fazer_login() throws Throwable {
		 WebDriverWait wait = new WebDriverWait(driver, 30);  
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));
		 driver.findElement(By.id("userId"));
	     driver.findElement(By.id("userId")).sendKeys("smile1");
	     driver.findElement(By.id("password"));
	     driver.findElement(By.id("password")).sendKeys("smile001");
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.findElement(By.id("loginButton")).click();
	     Thread.sleep(2000);
	     System.out.println("Login feito com sucesso");
	}
	@When("^Escolher link$")
	public void escolher_link() throws Throwable {
		 driver.findElement(By.xpath("html/body/a[1]")).click();//Escolher a primeira opção
		 System.out.println("Encontrado o link com sucesso");
	     Thread.sleep(30000);
	     System.out.println(driver.getTitle());
	     
	     Assert.assertEquals("Control Central", driver.getTitle());
	     System.out.println("Página carregada");
	}
	@When("^Fazer logout$")
	public void fazer_logout() throws Throwable {
		 System.out.println("Vamos fazer logout");
		 driver.get("http://10.141.3.41:6800/spl/logout.jsp");
		 Thread.sleep(4000);
	     System.out.println("Logout efetuado com sucesso");
	}
	
	@Then("^Fechar browser$")
	public void fechar_o_IE() throws Throwable {
		driver.close();
		System.out.println("O browser foi fechado com sucesso!");
	}
	
	
	// 2º Caso de teste 
	
	
	@When("^Fazer login com dados invalidos$")
	public void fazer_login_dados_invalidos() throws Throwable {
		 WebDriverWait wait = new WebDriverWait(driver, 30);  
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));
		 driver.findElement(By.id("userId"));
	     driver.findElement(By.id("userId")).sendKeys("duarte");
	     driver.findElement(By.id("password"));
	     driver.findElement(By.id("password")).sendKeys("joao");
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.findElement(By.id("loginButton")).click();
	     Thread.sleep(2000);
	     System.out.println("Tentativa de login efetuada");
	}
	
	
	@When("^Validar mensagem de insucesso$")
	public void validar_mensagem_insucesso() throws Throwable {
		 driver.findElement(By.id("mainMessage"));
		 System.out.println("Mensagem de incesso encontrada");
	     Thread.sleep(30000);
	    
	     System.out.println("Vamos fechar o browser");
	}
	
}
