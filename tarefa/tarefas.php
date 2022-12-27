<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gerenciamento de Tarefas</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Gerenciamento de Tarefas</h1>
    <form action="">
        <fieldset>
            <legend>Nova Tarefa</legend>
            <label for="nome">Tarefa : </label>
            <input type="text" name="nome"></input>
            <label for="descricao">Descrição : </label>
            <textarea name="descricao" id="" cols="30" rows="10"></textarea>
            <label for="prazo">Prazo : </label>
            <input type="text" name="prazo"></input>
            <fieldset>
                <legend>Prioridade:</legend>
                <input type="radio" name="prioridade" value="baixa" checked></input>Baixa
                <input type="radio" name="prioridade" value="media"></input>Media
                <input type="radio" name="prioridade" value="alta"></input>Alta
            </fieldset>
            <label>Tarefa Concluída :
                <input type="checkbox" name="concluida" value="1">Sim</input>
                <input type="checkbox" name="concluida" value="0">Não</input>
            </label>
            <input type="submit" value="Cadastrar">

        </fieldset>
    </form>
    <?php
        
        session_start();
        
        if(array_key_exists('nome',$_GET) && $_GET['nome']!=''){//Verifica se o indíce nome existe, outra maneira e a função isset()
            $tarefa=[];
            $tarefa['nome'] = $_GET['nome'];

            if(array_key_exists('descricao',$_GET) && $_GET['descricao']!=''){
                $tarefa['descricao'] = $_GET['descricao'];
            }

            if(array_key_exists('prazo',$_GET) && $_GET['prazo']!=''){
                $tarefa['prazo'] = $_GET['prazo'];
            }

            if(array_key_exists('prioridade',$_GET) && $_GET['prioridade']!=''){
                $tarefa['prioridade'] = $_GET['prioridade'];
            }

            if(array_key_exists('concluida',$_GET) && $_GET['concluida']!=''){
                $tarefa['concluida'] = $_GET['concluida'];
            }
        }
     
        if(array_key_exists('nome',$_GET)){//Verifica se o indíce nome existe, outra maneira e a função isset()
            $_SESSION['lista_tarefas'][]= $tarefa;
        }
    ?>
    <table>
        <tr>
            <th>Tarefas</th>
            <th>Descrição</th>
            <th>Prazo</th>
            <th>Prioridade</th>
            <th>Concluída</th>
        </tr>
        <?php foreach ($_SESSION['lista_tarefas'] as $tarefa) : ?>
        <tr>
            <td><?php echo $tarefa['nome']; ?></td>
            <td><?php echo $tarefa['descricao']; ?></td>
            <td><?php echo $tarefa['prazo']; ?></td>
            <td><?php echo $tarefa['prioridade']; ?></td>
            <td><?php echo $tarefa['concluida']; ?></td>
        </tr>
        <?php endforeach; 
        session_destroy(); ?>
    </table>
</body>
</html>