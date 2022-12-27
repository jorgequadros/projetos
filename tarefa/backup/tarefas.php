<!DOCTYPE html>
<?php session_start();?>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gerenciamento de Tarefas</title>
</head>
<body>
    <h1>Gerenciamento de Tarefas</h1>
    <form action="">
        <fieldset>
            <legend>Nova Tarefa</legend>
            <label for="nome">Tarefa : </label>
            <input type="text" name="nome"></input>
            <input type="submit" value="Cadastrar">
        </fieldset>
    </form>
    <?php 
        if(array_key_exists('nome',$_GET)){//Verifica se o indíce nome existe, outra maneira e a função isset()
            $_SESSION['lista_tarefas'][] = $_GET['nome'];
        }
    
        $lista_tarefas=[];
     
        if(array_key_exists('nome',$_GET)){//Verifica se o indíce nome existe, outra maneira e a função isset()
            $lista_tarefas = $_SESSION['lista_tarefas'];
        }
    ?>
    <table>
        <tr><th>Tarefas</th></tr>
        <tr><td>Nome</td></tr>
        <?php foreach ($lista_tarefas as $tarefa) : ?>
        <tr><td><?php echo $tarefa; ?></td></tr>
        <?php endforeach; ?>
    </table>
</body>
</html>