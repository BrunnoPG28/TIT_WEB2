function tempo() {
    var valor_moeda = document.getElementById("moedas").value;
    var placaVeiculo = document.getElementById("placa").value;
    var troco;

    //limpa os campos de resposta
    document.getElementById("resposta").textContent = "";  
    document.getElementById("localStorage").textContent = "";

    if(valor_moeda == "" || placaVeiculo == ""){
        alert("Preencha todos os campos!")
    }
    else{
        
        if (valor_moeda >= 1 && valor_moeda < 1.75) {
            troco = valor_moeda - 1;
            document.getElementById("resposta").innerHTML = "Tempo de permanência: 30 minutos" + "<br>" + "Troco: R$" + troco;
            
            localStorage.setItem("placa",document.getElementById("placa").value);
            localStorage.setItem("tempoPermanencia","30 min");
            document.getElementById("localStorage").innerHTML = "Testando o localStorage: " + "<br>" + localStorage.getItem("placa") + ": " + localStorage.getItem("tempoPermanencia");
        }
        else if(valor_moeda >= 1.75 && valor_moeda < 3){
            troco = valor_moeda - 1.75;
            document.getElementById("resposta").innerHTML = "Tempo de permanência: 60 minutos" + "<br>" + "Troco: R$" + troco;
            
            localStorage.setItem("placa",document.getElementById("placa").value);
            localStorage.setItem("tempoPermanencia","60 min");
            document.getElementById("localStorage").innerHTML = "Testando o localStorage: " + "<br>" + localStorage.getItem("placa") + ": " + localStorage.getItem("tempoPermanencia");
        } 
        else if (valor_moeda >= 3){
            troco = valor_moeda - 3;
            document.getElementById("resposta").innerHTML = "Tempo de permanência: 120 minutos" + "<br>" + "Troco: R$" + troco;
            
            localStorage.setItem("placa",document.getElementById("placa").value);
            localStorage.setItem("tempoPermanencia","120 min");
            document.getElementById("localStorage").innerHTML = "Testando o localStorage: " + "<br>" + localStorage.getItem("placa") + ": " + localStorage.getItem("tempoPermanencia");
        } 
        else if(valor_moeda < 1){
            document.getElementById("resposta").innerHTML = "Valor insuficiente!";
        }
    }
        
        
    }
    var mostrar = document.getElementById("mostrartempo");
    mostrar.addEventListener("click", tempo);