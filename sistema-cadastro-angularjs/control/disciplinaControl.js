var app = angular.module('todoApp', [])
.controller('DisciplinaController', function($scope,$http) {
  
  var url = 'http://localhost:9000/disciplina';
  
  $scope.nomeTela = "Cadastro de Disciplinas";

  $scope.pesquisar = function() {
    $http.get(url).then(function (response) {
        $scope.disciplinas = response.data;
    }, function (error) {
        alert(error);
        console.log(error);
    });
}

$scope.salvar = function() {
    if (typeof $scope.disciplina.idDisciplina == 'undefined') {
        if(typeof $scope.disciplina.descricao == 'undefined'){
            alert('Digite uma disciplina');
        }else{
            $http.post(url,$scope.disciplina).then(function (response) {
                $scope.disciplinas.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        }
    } else {
        $http.put(url,$scope.disciplina).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        });
    } 
}

$scope.excluir = function() {
    if (typeof $scope.disciplina.idDisciplina == 'undefined') {
        alert('Escolha uma Disciplina');
    } else {
        urlExcluir = url+"/"+$scope.disciplina.idDisciplina;
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
  $scope.disciplina = {};
}        

$scope.seleciona = function(disciplina) {
  $scope.disciplina = disciplina;
}

$scope.pesquisar();
   $scope.novo();
});