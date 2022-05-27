package pages;

import core.BasePage;

public class ListaDeEnderecosOuCepPage extends BasePage {
    public void buttonNewSearch(){
        click("//button[@id=\"btn_voltar\"]");
    }

    public String getFirstLine(){
        return getText("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]");
    }

    public String getResultMessage(){
        return getText("//div[@id=\"mensagem-resultado\"]");
    }
}
