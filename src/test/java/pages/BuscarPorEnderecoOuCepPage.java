package pages;

import core.BasePage;

public class BuscarPorEnderecoOuCepPage extends BasePage {

    public void setAdress (String adress){
        write("//input[@id=\"endereco\"]", adress);
    }

    public void setTypeCEP(String typeCEP){
        selectCombo("//select[@name=\"tipoCEP\"]", typeCEP);
    }

    public void buttonSearch(){
        click("//button[@id=\"btn_pesquisar\"]");
    }

    public String getMessageError(){
        return getText("//div[@class=\"mensagem\"]");
    }

    public String getTitleHomePage(){
        return getText("//*[@id=\"titulo_tela\"]");
    }

    public String getMensageAlert(){
        return getText("//div[@id=\"alerta\"]");
    }

}
