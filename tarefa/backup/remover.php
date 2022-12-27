<?php 
include "config.php";
include "banco.php";

remover_tarefa($conexao, $_POST['id']);

function remover_tarefa($conexao, $id){
    $sqlRemover = "delete from tarefa where id = {$id}";
    mysqli_query($conexao, $sqlRemover);
}

header('Location: tarefas.php');
die();

?>