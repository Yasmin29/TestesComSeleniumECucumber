package steps;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.BuscarPorEnderecoOuCepPage;
import pages.ListaDeEnderecosOuCepPage;

import java.time.Duration;

public class BuscarPorEnderecoOuCep {
    BuscarPorEnderecoOuCepPage buscarPorEnderecoOuCepPage = new BuscarPorEnderecoOuCepPage();
    ListaDeEnderecosOuCepPage listaPage = new ListaDeEnderecosOuCepPage();

    @Dado("que estou na página de busca por CEP ou endereço")
    public void queEstouNaPaginaDeBuscaPorCEPOuEndereço() {
        DriverFactory.getDriver().get("https://buscacepinter.correios.com.br/app/endereco/index.php");
    }
    @E("informo o endereço {string}")
    public void informoOEndereco(String adress) {
        buscarPorEnderecoOuCepPage.setAdress(adress);
    }

    @E("informo o CEP {string}")
    public void informoOCep(String CEP) {
        buscarPorEnderecoOuCepPage.setAdress(CEP);
    }

    @E("o tipo do cep como {string}")
    public void oTipoDoCepComo(String type) {
        buscarPorEnderecoOuCepPage.setTypeCEP(type);
    }

    @E("seleciono Nova Busca")
    public void selecionoNovaBusca() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        listaPage.buttonNewSearch();
    }

    @E("preencho um  campo apenas com {string}")
    public void preenchoUmCampoApenasCom(String adress) {
        buscarPorEnderecoOuCepPage.setAdress(adress);
    }

    @E("não informo um CEP ou endereço")
    public void naoInformoUmCEPOuEndereco() {
        buscarPorEnderecoOuCepPage.setAdress("");
    }

    @E("visualizo o CEP {string}")
    public void visualizoOCEP(String CEP) {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String enderecoRetornado = listaPage.getFirstLine();
        Assert.assertTrue(enderecoRetornado.contains(CEP));
    }

    @Quando("clico em buscar")
    public void clicoEmBuscar() {
        buscarPorEnderecoOuCepPage.buttonSearch();
    }

    @Então("retorna a mensagem {string}")
    public void retornaAMensagem(String text) {
        Assert.assertEquals(text, buscarPorEnderecoOuCepPage.getMessageError());
    }

    @Então("retorna mensagem de alerta {string}")
    public void retornaMensagemDeAlerta(String text) {
        Assert.assertEquals(text, buscarPorEnderecoOuCepPage.getMensageAlert());
    }

    @Então("volto para página inicial")
    public void voltoParaPaginaInicial() {
        Assert.assertEquals("Busca CEP", buscarPorEnderecoOuCepPage.getTitleHomePage());
    }

    @Então("visualizo o endereço {string}")
    public void visualizoOEndereco(String adress) {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String enderecoRetornado = listaPage.getFirstLine();
        Assert.assertTrue(enderecoRetornado.contains(adress));
    }

    @Então("visualiza uma lista de endereços com nomes semelhantes a {string} com seus respectivos CEPS")
    public void visualizaUmaListaDeEnderecosComNomesSemelhantesA(String adress) {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String enderecoRetornado = listaPage.getFirstLine();
        Assert.assertTrue(enderecoRetornado.contains(adress));
    }
    @Então("aparece uma mensagem informando {string}")
    public void apareceUmaMensagemInformando(String text) throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(5000);
        Assert.assertEquals(text, listaPage.getResultMessage());
    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
    }
}
