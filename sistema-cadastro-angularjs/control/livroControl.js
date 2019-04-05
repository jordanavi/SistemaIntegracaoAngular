var app = angular.module('todoApp', [])
.controller('LivroController', function($scope,$http) {
  
  var url = 'http://localhost:9000/livros';
  var urlEditoras = 'http://localhost:9000/editoras';
  var urlCategorias = 'http://localhost:9000/categorias';
  
  $scope.nomeTela = "Cadastro de Livro";

  $scope.pesquisar = function() {
    $http.get(url).then(function (response) {
        $scope.livros = response.data;
    }, function (error) {
        alert(error);
        console.log(error);
    });
}

$scope.salvar = function() {
    if (typeof $scope.livro.codigo == 'undefined') {
        if(typeof $scope.livro.isbn == 'undefined'){
            alert('Digite o codigo do livro');
        }else{
            $http.post(url,$scope.livro).then(function (response) {
                $scope.livros.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        }
    } else {
        $http.put(url,$scope.livro).then(function () {
            $scope.pesquisar();
            $scope.novo();
        }, function (error) {
            alert(error);
            console.log(error);
        });
    } 
}

$scope.excluir = function() {
    if (typeof $scope.livro.codigo == 'undefined') {
        alert('Escolha um codigo de livro');
    } else {
        urlExcluir = url+"/"+$scope.livro.codigo;
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
  $scope.livro = {};
}        

$scope.seleciona = function(livro) {
  $scope.livro = livro;
}

$scope.pesquisar();
$scope.novo();

$scope.itensCategoria = [
    $http.get(urlCategorias).then(function (res) {
        $scope.categorias = res.data;
        console.log("Categorias DATA: ", res.data);
    }, function (error) {
        alert(error);
        console.log(error);
    })
  ];
  $scope.itensCategoria.unshift({descricao: 'Selecione a Opção', idCategoria: 0});
  $scope.categoria = $scope.itensCategoria[0];


  $scope.itensEditoras = [
    $http.get(urlEditoras).then(function (rest) {
        $scope.editoras = rest.data;
        console.log("Editoras : ", rest.data);
    }, function (error) {
        alert(error);
        console.log(error);
    })
  ];
  $scope.itensEditoras.unshift({nome: 'Selecione a Opção', idEditora: 0});
  $scope.editora = $scope.itensEditoras[0];


});

