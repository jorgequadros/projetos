<?php

$bdServidor='localhost';
$bdUsuario='root';
$bdSenha='Sql105899@';
$bdBancaDados='tarefa';

$conexao = mysqli_connect($bdServidor, $bdUsuario, $bdSenha, $bdBancaDados);

if(!$conexao){
    echo '<h2>Problemas para conectar no Banco. Erro:</h2>';
    echo mysqli_connect_errno;
}else{
    echo '<h2>Conexão realizada com êxito</h2>';
}