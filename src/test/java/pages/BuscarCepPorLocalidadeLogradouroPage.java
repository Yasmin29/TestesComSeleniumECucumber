package pages;

import core.BasePage;

public class BuscarCepPorLocalidadeLogradouroPage extends BasePage {

    public void setUF(String UF){
        selectCombo("//select[@id=\"uf\"]", UF);
    }

    public void setLocality(String locality){
        write("//input[@id=\"localidade\"]", locality);
    }

    public void setType(String type) {
        selectCombo("//select[@id=\"tipologradouro\"]", type);
    }

    public void setLogradouro(String logradouro){
        write("//input[@id=\"logradouro\"]", logradouro);
    }

    public void setNumberLogradouro(String numberLogradouro){
        write("//input[@id=\"numeroLogradouro\"]", numberLogradouro);
    }

    public void buttonSearch(){
        click("//button[@id=\"btn_pesquisar\"]");
    }

    public String getMessageError(){
        return getText("//div[@class=\"msg\"]");
    }

}
