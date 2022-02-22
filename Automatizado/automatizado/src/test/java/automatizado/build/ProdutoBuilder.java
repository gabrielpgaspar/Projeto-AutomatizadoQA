package automatizado.build;

import automatizado.page.ControleDeProdutoPO;

/**
* Classe que sabe construir e sabe adicionar um produto na tela.
*/
public class ProdutoBuilder {
    
    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "20/02/2022";

    private ControleDeProdutoPO controleDeProdutoPO;

    /**Construtor do produtoBuilder que recebe a pagina de controle de produtos.*/
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
    *Metodo que sabe adicionar um codico ao builder.
    *@param codigo Codigo que sera adicionado.
    *@return retorna a propria classe ProdutoBuilder.
    */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    /**
    *Metodo que sabe adicionar um nome ao builder.
    *@param nome Nome que sera adicionado.
    *@return retorna a propria classe ProdutoBuilder.
    */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
    *Metodo que sabe adicionar uma quantidade ao builder.
    *@param quantidade Quantidade que sera adicionada.
    *@return retorna a propria classe ProdutoBuilder.
    */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
    *Metodo que sabe adicionar um valor ao builder.
    *@param valor Valor que sera adicionado.
    *@return retorna a propria classe ProdutoBuilder.
    */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    /**
    *Metodo que sabe adicionar uma data ao builder.
    *@param data Data que sera adicionada.
    *@return retorna a propria classe ProdutoBuilder.
    */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
    * Metodo que constroi o produto ,ou seja, pela tela de cadastro de produto.
    */
    public void builder(){

            controleDeProdutoPO.escrever( controleDeProdutoPO.inputCodigo, codigo);
            controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
            controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade == null) ? quantidade.toString() : "");
            controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor == null) ? valor.toString() : "");
            controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
    
            controleDeProdutoPO.buttonSalvar.click();
    }

}
