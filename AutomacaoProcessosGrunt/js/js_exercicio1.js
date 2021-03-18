var vendas = []; //array para armazenar todas as vendas 

var totalVendas = 0;

function listarVendas() {
    var resposta = "=>";
    
    for(i = 0 ; i < vendas.length ; i++){
        
        if(i % 3 == 0){  // se o indice for multiplo de 3 ele pula uma linha, pois será uma outra venda
            resposta = resposta.concat("<br>");
        }
        resposta = resposta.concat(vendas[i],", ");
    }
    //exibe a resposta
    document.getElementById("resposta").innerHTML = "Relação de Vendas: (Preço kg/ Consumo/ Valor da venda) " + resposta + "<br>" + "Valor total das vendas: R$" + totalVendas;
}
 var listar = document.getElementById("listar");
 listar.addEventListener("click", listarVendas);

 function gravarVendas(preco_quilo, consumo_cliente, valorPedido) {    
    vendas.push(preco_quilo,consumo_cliente,valorPedido);
    
    return vendas;
}

function preco() {
    var preco_quilo = document.getElementById("buffet").value;
    var consumo_cliente = document.getElementById("consumo").value;

    document.getElementById("resposta").textContent = ""; //limpa o campo resposta
    
    if(preco_quilo == "" || consumo_cliente == ""){
        alert("Preencha todos os campos!");
        return;
    }
    var calculo = (consumo_cliente * preco_quilo)/1000 ; 
    totalVendas = totalVendas + calculo;

    gravarVendas(preco_quilo, consumo_cliente, calculo);

    //exibe a resposta
    document.getElementById("resposta").innerHTML = "O valor a ser pago é igual a R$" + calculo; 
}
 var mostrar = document.getElementById("calcular");
 mostrar.addEventListener("click", preco);

 function limparCampos() {
    // Limpa os conteúdos dos elementos
    document.getElementById("buffet").value = "";
    document.getElementById("consumo").value = "";
    document.getElementById("resposta").textContent = "";
    // posiciona (joga o foco) no elemento buffet
    document.getElementById("buffet").focus();
    }
    var Limpar = document.getElementById("limpar");
    Limpar.addEventListener("click", limparCampos);
