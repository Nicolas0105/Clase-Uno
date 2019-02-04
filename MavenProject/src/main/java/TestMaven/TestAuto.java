package TestMaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAuto {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		File data = new File("data.txt");
		FileReader fr;
		try {
			fr = new FileReader(data);
			BufferedReader br = new BufferedReader(fr);
			String linea = "";
			while((linea = br.readLine())!=null) {
				try {
					String[] datos = linea.split(","); 
					driver.get("https://www.facebook.com/");
					WebElement txtUsuario = driver.findElement(By.id("email"));
					txtUsuario.sendKeys(datos[0]);
					WebElement txtClave = driver.findElement(By.id("pass"));
					txtClave.sendKeys(datos[1]);
					WebElement btnLogin = driver.findElement(By.id("u_0_2")); 
					btnLogin.click();
					WebElement lblMensaje = driver.findElement(By.xpath("//*[@id='globalContainer']/div[3]/div/div/div"));
					if (lblMensaje.isDisplayed()) {
						System.out.println("Error de Contraseña");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		driver.close();
		
	}

}
