<?php

include "config.php";
include "banco.php";
include "ajudantes.php";

$tem_erros = false;
$erros_validacao = array();

if(tem_post()){
    $tarefa_id = $_POST['tarefa_id'];

    if(!isset($_FILES['anexo'])){
        $tem_erros = true;
        $erros_validacao['anexo'] = 'Você deve selecionar um arquivo para anexar';
    }else{
        if(tratar_anexo($_FILES['anexo'])){
            $anexo = array();
            $anexo['tarefa_id'] = $tarefa_id;
            $anexo['nome'] = $_FILES['anexo']['name'];
            $anexo['arquivo'] = "anexos\/" . $_FILES['anexo']['name'];

        }else{
            $tem_erros = true;
            $erros_validacao['anexo']='Envie apenas anexos nos formatos ZIP ou PDF.';
        }
    }

    if(!$tem_erros){
       gravar_anexo($conexao, $anexo);

       if(isset($_POST['lembrete']) && $_POST['lembrete'] == 1){
            enviar_email($tarefa);
       }
    }
}

if (isset($_GET['id'])){
    $tarefa = buscar_tarefa($conexao, $_GET['id']);
    $anexos = buscar_anexos($conexao, $_GET['id']);
}else{

    $tarefa = array(
        'id' => 0,
        'nome' => (isset($_POST['nome'])) ? $_POST['nome'] :'',
        'descricao' => (isset($_POST['descricao'])) ? $_POST['descricao'] :'',
        'prazo' => (isset($_POST['prazo'])) ? traduz_data_para_banco($_POST['prazo']) :'',
        'prioridade' => (isset($_POST['prioridade'])) ? $_POST['prioridade'] : 1,
        'concluida' => (isset($_POST['concluida'])) ? $_POST['concluida'] : 0,
        'lembrete' => (isset($_POST['lembrete'])) ? $_POST['lembrete'] : 0
    );
}


function buscar_anexos($conexao, $tarefa_id)
{
    $sql = "select * from anexos where tarefa_id = {$tarefa_id}";
    $resultado = mysqli_query($conexao, $sql);

    $anexos = array();

    while($anexo = mysqli_fetch_assoc($resultado)){
        $anexos[] = $anexo;
    }

    return $anexos;
}

function buscar_tarefa($conexao, $id)
{

    $sqlBusca = 'select * from tarefa where id = ' . $id;
    $resultado = mysqli_query($conexao, $sqlBusca);
    if (!$resultado){
        return "";
    }else{
        return mysqli_fetch_assoc($resultado);

    }

}

function gravar_anexo($conexao,$anexo)
{
    $sqlGravar = "insert into anexos(tarefa_id, nome, arquivo) values (
        {$anexo['tarefa_id']},
        '{$anexo['nome']}',
        '{$anexo['arquivo']}')";
    
    mysqli_query($conexao, $sqlGravar);
}

include "template_tarefa.php";