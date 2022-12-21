<?php 

require 'bibliotecas\PHPMailer\src\PHPMailer.php';
require 'bibliotecas\PHPMailer\src\SMTP.php';
require 'bibliotecas\PHPMailer\src\Exception.php';

use PHPMailer\PHPMailer\PHPMailer;

include "config.php";
include "banco.php";
include "ajudantes.php";
include "classes/Tarefas.php";

$tarefas = new  Tarefas($conexao);

$tarefa = array();

$tem_erros = false;
$exibe_tabela = false;

if (isset($_GET['id'])){
    $tarefas->busca_tarefa($_GET['id']);
    $tarefa = $tarefas->tarefa;
    
}else{
    $tarefa = array(
        'id' => 0,
        'nome' => '',
        'descricao' => '',
        'prazo' => '',
        'prioridade' => 1,
        'concluida' => '',
        'lembrete' => 0
    );
}

if(isset($_POST['nome']) && $_POST['nome'] !=''){
        
    $tarefa['id'] = $_POST['id'];
    $tarefa['nome'] = $_POST['nome'];

    if(isset($_POST['descricao'])){
        $tarefa['descricao'] = $_POST['descricao'];
    }else{
        $tarefa['descricao'] = '' ;
    }
    
    if(isset($_POST['prazo'])){
        $tarefa['prazo'] = $_POST['prazo'];
    }else{
        $tarefa['prazo'] = '' ;
    }

    $tarefa['prioridade'] = $_POST['prioridade'];

    if(isset($_POST['concluida'])){
        $tarefa['concluida'] = $_POST['concluida'];
    }else{
        $tarefa['concluida'] = '' ;
    }
    
    if(isset($_POST['lembrete']) && $_POST['lembrete'] == '1'){
        enviar_email($tarefa);
    }
    
    $tarefas->editar_tarefa($tarefa);

}



function buscar_tarefas($conexao){
    
    $sqlBusca = 'select * from tarefa';
    $resultado = mysqli_query($conexao,$sqlBusca);
    $tarefa = array();
    
    while ($tarefas = mysqli_fetch_assoc($resultado)) {
        $tarefa[] = $tarefas;
    }

    return $tarefa;
}

function gravar_tarefa($conexao, $tarefas){
    $sqlGravar = "Insert into tarefa (nome, descricao, prazo, concluida, prioridade) values (
        '{$tarefas['nome']}',
        '{$tarefas['descricao']}',
        '{$tarefas['prazo']}',
        '{$tarefas['concluida']}',
        {$tarefas['prioridade']})";

    mysqli_query ($conexao,$sqlGravar);
}

function editar_tarefa($conexao, $id){
    
    if (isset($_POST['nome'])) {
        $nome = $_POST['nome'];
        $descricao = $_POST['descricao'];
        $prioridade = $_POST['prioridade'];
        $prazo = traduz_data_para_banco($_POST['prazo']);
        
        
        if(isset($_POST['concluida']) || $_POST['concluida']=''){
            $concluida = 1;
        }else{
            $concluida = 0;
        }
        
        if(isset($_POST['lembrete']) || $_POST['lembrete']=''){
            $lembrete = 1;
            
        }else{
            $lembrete = 0;
        }

        $sqlEditar = "Update tarefa Set nome = '" . $nome . "', descricao = '" . $descricao . "', prioridade = " . $prioridade .", prazo = '" . $prazo . "', concluida = " . $concluida . ", lembrete = " . $lembrete . " where id = " . $_GET['id']; 
        $resultado = mysqli_query($conexao, $sqlEditar);
        header('Location: tarefas.php');
        die();//termina o processo desta pagina
        
    }

}

include "template.php";

editar_tarefa($conexao, $tarefa);

function enviar_email($tarefa, $anexos=array())
{
    $corpo = preparar_corpo_email($tarefa, $anexos);

    $email = new PHPMailer();

    $email->isSMTP() ;
    $email-> Host = "smtp.gmail.com";
    $email-> Port = 587;
    $email-> SMTPSecure = 'tls';
    $email-> SMTPAuth = true;
    $email-> Username = "jorge.quadros33@gmail.com";
    $email-> Passoword = "Gml105899";
    $email-> setFrom("jorge.quadros7@outlook.com","Avisador de Tarefas!");
    $email-> addAddress(EMAIL_NOTIFICACAO);
    $email-> Subject = "Aviso de tarefa: {$tarefa['nome']}";
    $email-> msgHTML($corpo);

    foreach ($anexos as $anexo) {
        $email-> addAttachment("anexos/{$anexo['arquivo']}");
    }

    $email-> send();
}

function preparar_corpo_email($tarefa,$anexos)
{
    ob_start();
    include "template_email.php";
    $corpo = ob_get_contents();
    ob_end_clean();
    return $corpo;

}