var app = angular.module('todoApp', [])
.controller('ProfessorController', function($scope,$http) {
  
  var url = 'http://localhost:9000/professores';
  
  $scope.nomeTela = "Cadastro de Professores";

  $scope.pesquisar = function() {
    $http.get(url).then(function (response) {
        $scope.professores = response.data;
    }, function (error) {
        alert(error);
        console.log(error);
    });
}

$scope.salvar = function() {
    alert('to aqui')
    if (typeof $scope.professor.codigo == 'undefined') {
        if (typeof $scope.professor.nome == 'undefined') {
            alert('Digite o nome do professor');
        }else{
            alert('foi '+JSON.stringify($scope.professor))
            $http.post(url,$scope.professor).then(function (response) {
                $scope.professores.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        }         
    } else {
        $http.put(url,$scope.professor).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        });
    } 
}

$scope.excluir = function() {
    if (typeof $scope.professor.codigo == 'undefined') {
        alert('Escolha um professor');
    } else {
        urlExcluir = url+"/"+$scope.professor.codigo;
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
  $scope.professor = {};
}        

$scope.seleciona = function(professor) {
  $scope.professor = professor;
}

$scope.pesquisar();
$scope.novo();
alert('foi')

});