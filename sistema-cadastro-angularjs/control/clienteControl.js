var app = angular.module('todoApp', [])
.controller('ClienteController', function($scope,$http) {
  
  var url = 'http://localhost:9000/clientes';
  
  $scope.nomeTela = "Cadastro de Professores";

  $scope.pesquisar = function() {
    $http.get(url).then(function (response) {
        $scope.clientes = response.data;
    }, function (error) {
        alert(error);
        console.log(error);
    });
}

$scope.salvar = function() {
    if (typeof $scope.cliente.codigo == 'undefined') {
        if (typeof $scope.cliente.nome == 'undefined') {
            alert('Digite o nome do professor');
        }else{
            $http.post(url,$scope.cliente).then(function (response) {
                $scope.clientes.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        }         
    } else {
        $http.put(url,$scope.cliente).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        });
    } 
}

$scope.excluir = function() {
    if (typeof $scope.cliente.codigo == 'undefined') {
        alert('Escolha um professor');
    } else {
        urlExcluir = url+"/"+$scope.cliente.codigo;
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
  $scope.cliente = {};
}        

$scope.seleciona = function(cliente) {
  $scope.cliente = cliente;
}

$scope.pesquisar();
$scope.novo();

});