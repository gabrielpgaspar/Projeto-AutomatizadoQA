package automatizado.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.build.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControleDeProdutoTest extends BaseTest {
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controlleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){

        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controlleProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controlleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveSerPossivelAbrirModalAoClicarNoBotaoAdicionar(){
        controlleProdutoPage.buttonAdicionar.click();
        //TODO: Remover esse clique assim que o sistema for corrigido.
        controlleProdutoPage.buttonAdicionar.click();

        String titulo = controlleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);

        controlleProdutoPage.buttonSair.click();
        controlleProdutoPage.buttonSair.click();
    }

    @Test
    public void TC002_naoDeveSerPossivelCadastrarProdutoSemPreencherTodosOsCampos(){
        
        String mensagem = "Todos os campos são obrigatórios para o cadastro";
        controlleProdutoPage.buttonAdicionar.click();

        //Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

        // Aqui estamos testando se o produto é adicionado sem codigo.
        produtoBuilder
        .adicionarCodigo("")
        .builder();

        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem quantidade.
        produtoBuilder
        .adicionarCodigo("0005")
        .adicionarQuantidade(null)
        .builder();

        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem nome.
        produtoBuilder
        .adicionarQuantidade(15)
        .adicionarNome("")
        .builder();

        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
        
        //Aqui estamos testando se o produto é adicionado sem valor.
        produtoBuilder
        .adicionarNome("Shampoo")
        .adicionarValor(null)
        .builder();

        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        // Aqui estamos testamos se o produto é adicionado sem data. 
        produtoBuilder
        .adicionarValor(14.7)
        .adicionarData("")
        .builder();

        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        controlleProdutoPage.buttonSair.click();
        controlleProdutoPage.buttonSair.click();

    }

    @Test
    public void TC003_deveSerPossivelCadastrarProdutoPadrao(){
       
        controlleProdutoPage.buttonAdicionar.click();

        //Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

        produtoBuilder
        .builder();
        String titulo = controlleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);
       
        controlleProdutoPage.buttonSalvar.click();
        controlleProdutoPage.buttonSalvar.click();
    
    }

    @Test
    public void TC004_deveSerPossivelCadastrarCampoNoValorUmValor(){
       
        controlleProdutoPage.buttonAdicionar.click();

        //Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

        String titulo = controlleProdutoPage.tituloModal.getText();

        produtoBuilder
        .adicionarValor(18.7)
        .builder();

        assertEquals("Produto", titulo);

        controlleProdutoPage.buttonSalvar.click();
    }

    @Test
    public void TC005_deveSerPossivelCadastrarNoCampoQuantidadeUmaQuantidade(){
       
        controlleProdutoPage.buttonAdicionar.click();

        //Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

        String titulo = controlleProdutoPage.tituloModal.getText();

        produtoBuilder
        .adicionarQuantidade(8)
        .builder();

        assertEquals("Produto", titulo);

        controlleProdutoPage.buttonSalvar.click();
    }

    @Test
    public void TC006_deveSerPossivelCadastrarNoCampoNomeUmNome(){
       
        controlleProdutoPage.buttonAdicionar.click();

        //Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

        String titulo = controlleProdutoPage.tituloModal.getText();

        produtoBuilder
        .adicionarNome("Detergente")
        .builder();

        assertEquals("Produto", titulo);

        controlleProdutoPage.buttonSalvar.click();
    }

}
