var app = angular.module('todoApp', [])
.controller('EditoraController', function($scope,$http) {
  
  var url = 'http://localhost:9000/areaConhecimento';
  
  $scope.nomeTela = "Cadastro de Área de Conhecimento";

  $scope.pesquisar = function() {
    $http.get(url).then(function (response) {
        $scope.areaConhecimento = response.data;
    }, function (error) {
        alert(error);
        console.log(error);
    });
}

$scope.salvar = function() {
    if (typeof $scope.editora.idAreaConhecimento == 'undefined') {
        if(typeof $scope.areaConhecimento.nome == 'undefined'){
            alert('Digite uma área de conhecimento');
        }else{
            $http.post(url,$scope.areaConhecimento).then(function (response) {
                $scope.areaConhecimentos.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        }
    } else {
        $http.put(url,$scope.areaConhecimento).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        });
    } 
}

$scope.excluir = function() {
    if (typeof $scope.areaConhecimento.idAreaConhecimento == 'undefined') {
        alert('Escolha uma area de conhecimento');
    } else {
        urlExcluir = url+"/"+$scope.areaConhecimento.idAreaConhecimento;
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
  $scope.areaConhecimento = {};
}        

$scope.seleciona = function(areaConhecimento) {
  $scope.areaConhecimento = areaConhecimento;
}

$scope.pesquisar();
   $scope.novo();
});