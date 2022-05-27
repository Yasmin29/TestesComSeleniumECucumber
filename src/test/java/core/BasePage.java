package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

        public String getText(String xpath){
            return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
        }

        public void write(String xpath, String texto) {
            DriverFactory.getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
        }

        public void click(String xpath){
            DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
        }

        public void selectCombo(String xpath, String texto){
            WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
            Select combo = new Select(element);
            combo.selectByVisibleText(texto);
        }


}

