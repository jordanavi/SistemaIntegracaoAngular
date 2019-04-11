var app = angular.module('todoApp', [])
.controller('ConteudoController', function($scope,$http) {
  
  var url = 'http://localhost:9000/conteudos';
  var urlAreaConhecimento = 'http://localhost:9000/areaConhecimentos';
  var urlDisciplina = 'http://localhost:9000/disciplinas';
  
  $scope.nomeTela = "Cadastro de Conteudo";

  $scope.pesquisar = function() {
    $http.get(url).then(function (response) {
        $scope.conteudo = response.data;
    }, function (error) {
        alert(error);
        console.log(error);
    });
}

$scope.salvar = function() {
    if (typeof $scope.conteudo.codigo == 'undefined') {
        if(typeof $scope.conteudo.nome == 'undefined'){
            alert('Digite o codigo do conteudo');
        }else{
            $http.post(url,$scope.conteudo).then(function (response) {
                $scope.conteudo.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        }
    } else {
        $http.put(url,$scope.conteudo).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        });
    } 
}

$scope.excluir = function() {
    if (typeof $scope.conteudo.codigo == 'undefined') {
        alert('Escolha um codigo de conteudo');
    } else {
        urlExcluir = url+"/"+$scope.conteudo.codigo;
        $http.delete(urlExcluir).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        }); 
    }
}

$scope.novo = function() {
  $scope.conteudo = {};
}        

$scope.seleciona = function(conteudo) {
  $scope.conteudo = conteudo;
}

$scope.pesquisar();
$scope.novo();

$scope.itensDisciplina = [
    $http.get(urlDisciplina).then(function (res) {
        $scope.disciplinas = res.data;
        console.log("Disciplinas DATA: ", res.data);
    }, function (error) {
        alert(error);
        console.log(error);
    })
  ];
  $scope.itensDisciplina.unshift({descricao: 'Selecione a Opção', idCategoria: 0});
  $scope.disciplina = $scope.itensCategoria[0];

areasConhecimento
  $scope.itensAreaConhecimento = [
    $http.get(urlAreaConhecimento).then(function (rest) {
        $scope.areaConhecimento = rest.data;
        console.log("Areas : ", rest.data);
    }, function (error) {
        alert(error);
        console.log(error);
    })
  ];
  $scope.itensAreaConhecimento.unshift({nome: 'Selecione a Opção', idEditora: 0});
  $scope.areaConhecimento = $scope.itensAreaConhecimento[0];


});

