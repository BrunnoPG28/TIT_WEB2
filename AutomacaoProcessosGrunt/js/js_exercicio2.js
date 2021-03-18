function calculaIdade(){ 
    var Pessoa = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        dataNascimento: document.getElementById("data").value
    };
    
    //limpa o campo de resposta
    document.getElementById("resposta").textContent = "";

    var dataAtual = new Date();
    var anoAtual = dataAtual.getFullYear();
    var mesAtual = dataAtual.getMonth() + 1;
    var anoNascParts = Pessoa.dataNascimento.split('/');  //divide a string(data) que o usuário digitou por / 
    var diaNasc = anoNascParts[0];  // dd/
    var mesNasc = anoNascParts[1];  // mm/
    var anoNasc = anoNascParts[2];  // /yyyy
    var idade = anoAtual - anoNasc;
     
    if(Pessoa.dataNascimento == ""){
        alert("Digite uma data de nascimento!");
        document.getElementById("data").focus;
    }
    else{
            //Se mes atual for menor que o nascimento, nao fez aniversario ainda;  
        if(mesAtual < mesNasc){
            idade--; 
        } 
        else {
            //Se estiver no mes do nascimento, verificar o dia
            if(mesAtual == mesNasc){ 
                if(new Date().getDate() < diaNasc ){ 
                //Se a data atual for menor que o dia de nascimento ele ainda nao fez aniversario
                    idade--; 
                }
            }
        } 
        
        //exibe a resposta
        document.getElementById("resposta").innerHTML = "PESSOA CADASTRADA: " + "<br>" + "Nome: " + Pessoa.nome + "<br>" + "CPF: " + Pessoa.cpf + "<br>" + "Data de Nascimento: " + Pessoa.dataNascimento + "<br>" + "Idade: " + idade;
    }
   }
   var cadastrarPessoa = document.getElementById("cadastrar");
   cadastrarPessoa.addEventListener("click", calculaIdade);