package pages;

import core.BasePage;

public class ListaDeCepPage extends BasePage {

    public void buttonNewSearch(){
        click("//button[@id=\"btn_nbusca\"]");
    }

    public String getCEP(){
        return getText("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[4]");
    }

    public String getResultMessage(){
        return getText("//div[@id=\"mensagem-resultado\"]");
    }
}
