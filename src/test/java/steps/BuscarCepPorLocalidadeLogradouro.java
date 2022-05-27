package steps;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.BuscarCepPorLocalidadeLogradouroPage;
import pages.ListaDeCepPage;

import java.time.Duration;

public class BuscarCepPorLocalidadeLogradouro {
    BuscarCepPorLocalidadeLogradouroPage page = new BuscarCepPorLocalidadeLogradouroPage();
    ListaDeCepPage listaDeCepPage = new ListaDeCepPage();

    @Dado("que estou na página de busca por CEP")
    public void queEstouNaPaginaDeBuscaPorCEP() {
        DriverFactory.getDriver().get("https://buscacepinter.correios.com.br/app/localidade_logradouro/index.php");
    }

    @Quando("clico  em buscar")
    public void clicoEmBuscar() {
        page.buttonSearch();
    }


    @E("preencho o campo UF com {string}")
    public void preenchoOCampoUFCom(String UF) {
        page.setUF(UF);
    }

    @E("preencho o campo localidade com {string}")
    public void preenchoOCampoLocalidadeCom(String locality) {
        page.setLocality(locality);
    }

    @E("preencho o campo tipo com {string}")
    public void preenchoOCampoTipoCom(String type) {
        page.setType(type);
    }

    @E("preencho o campo logradouro com {string}")
    public void preenchoOCampoLogradouroCom(String logradouro) {
        page.setLogradouro(logradouro);
    }

    @E("preencho o campo NumeroLoteAptoCasa com {string}")
    public void preenchoOCampoNumeroLoteAptoCasaCom(String number) {
        page.setNumberLogradouro(number);
    }

    @E("clico no botão Nova Busca")
    public void clicoNoBotaoVoltar() {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        listaDeCepPage.buttonNewSearch();
    }

    @Então("visualizo o CEP do endereço {string}")
    public void visualizoOCEPDoEndereco(String CEP) {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String enderecoRetornado = listaDeCepPage.getCEP();
        Assert.assertTrue(enderecoRetornado.contains(CEP));
    }

    @Então("visualizo a mensagem de erro {string}")
    public void visualizoAMensagemDeErro(String errorMensage) {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(errorMensage, page.getMessageError());
    }

    @Então("retorna uma mensagem informando {string}")
    public void apareceUmaMensagemInformando(String text) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(text, listaDeCepPage.getResultMessage());
    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
    }
}
