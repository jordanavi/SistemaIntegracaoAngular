var app = angular.module('todoApp', [])
.controller('EditoraController', function($scope,$http) {
  
  var url = 'http://localhost:9000/editoras';
  
  $scope.nomeTela = "Cadastro de Editora";

  $scope.pesquisar = function() {
    $http.get(url).then(function (response) {
        $scope.editoras = response.data;
    }, function (error) {
        alert(error);
        console.log(error);
    });
}

$scope.salvar = function() {
    if (typeof $scope.editora.idEditora == 'undefined') {
        if(typeof $scope.editora.nome == 'undefined'){
            alert('Digite uma descrição');
        }else{
            $http.post(url,$scope.editora).then(function (response) {
                $scope.editoras.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        }
    } else {
        $http.put(url,$scope.editora).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        });
    } 
}

$scope.excluir = function() {
    if (typeof $scope.editora.idEditora == 'undefined') {
        alert('Escolha um editora');
    } else {
        urlExcluir = url+"/"+$scope.editora.idEditora;
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
  $scope.editora = {};
}        

$scope.seleciona = function(editora) {
  $scope.editora = editora;
}

$scope.pesquisar();
   $scope.novo();
});