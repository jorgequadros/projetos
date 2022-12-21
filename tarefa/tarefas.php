<?php 

require 'bibliotecas\PHPMailer\src\PHPMailer.php';
require 'bibliotecas\PHPMailer\src\SMTP.php';
require 'bibliotecas\PHPMailer\src\Exception.php';

use PHPMailer\PHPMailer\PHPMailer;

include "config.php";
include "banco.php";
include "ajudantes.php";
include "classes/Tarefas.php";

$tarefas = new Tarefas($conexao);

$tarefas->buscar_tarefas();

$exibe_tabela = true;
$tem_erros = false;
$erros_validacao = array();

if(tem_post()){
    $tarefa = array();
    
    if(isset($_POST['nome']) && strlen($_POST['nome']) > 0 ){
        $tarefa['nome'] = $_POST['nome'];
    }else{
        $tem_erros = true;
        $erros_validacao['nome'] = 'O nome da tarefa é obrigatório!';
    }

    if(isset($_POST['descricao'])){
        $tarefa['descricao'] = $_POST['descricao'];
    }else{
        $tarefa['descricao'] = '' ;
    }
    
    if(isset($_POST['prazo']) && strlen($_POST['prazo'])){
        if(validar_data($_POST['prazo'])){
            $tarefa['prazo'] = traduz_data_para_banco($_POST['prazo']);
        } else {
            $tem_erros = true;
            $erros_validacao['prazo'] = 'O Prazo não é uma data válida!';
        }
    }else{
        $_POST['prazo'] = '' ;
    }

    if(isset($_POST['prioridade'])){
        $tarefa['prioridade'] = $_POST['prioridade'];
        
    }else{
        $tarefa['prioridade'] = 0 ;
    }

    if(isset($_POST['concluida'])){
        $tarefa['concluida'] = $_POST['concluida'];
    }else{
        $tarefa['concluida'] = 0 ;
    }

    if(isset($_POST['lembrete'])){
        $tarefa['lembrete'] = $_POST['lembrete'];
    }else{
        $tarefa['lembrete'] = 0 ;
    }
    
    if(isset($_POST['lembrete']) && $_POST['lembrete'] == '1'){
        enviar_email($tarefa);
    }
    
    gravar_tarefa($conexao,$tarefa);
}

if (isset($_POST['id'])){
    $tarefa = busca_tarefa($conexao,$_POST['id']);

}

$tarefa = array(
    'id' => 0,
    'nome' => (isset($_POST['nome'])) ? $_POST['nome'] :'',
    'descricao' => (isset($_POST['descricao'])) ? $_POST['descricao'] :'',
    'prazo' => (isset($_POST['prazo'])) ? traduz_data_para_banco($_POST['prazo']) :'',
    'prioridade' => (isset($_POST['prioridade'])) ? $_POST['prioridade'] : 0,
    'concluida' => (isset($_POST['concluida'])) ? $_POST['concluida'] : 0,
    'lembrete' => (isset($_POST['lembrete'])) ? $_POST['lembrete'] : 0
);

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
    
    $sqlGravar = "Insert into tarefa (nome, descricao, prazo, concluida, lembrete, prioridade) values (
        '{$tarefas['nome']}',
        '{$tarefas['descricao']}',
        '{$tarefas['prazo']}',
        '{$tarefas['concluida']}',
        {$tarefas['lembrete']},
        {$tarefas['prioridade']})";

    mysqli_query ($conexao,$sqlGravar);
}

function busca_tarefa($conexao, $id){
    
    $sqlBusca = 'select * from tarefa where id = ' . $id;
    $resultado = mysqli_query($conexao, $sqlBusca);
    if (!$resultado){
        return "";
    }else{
        return mysqli_fetch_assoc($resultado);

    } 

}

function editar_tarefa($conexao, $id){
    
    $sqlBusca = "Update tarefa Set " .
                "nome = '{$tarefa['nome']}', " .
                "descricao = '{$tarefa['descricao']}', " . 
                "prioridade = '{$tarefa['prioridade']}', " .
                "prazo = '{$tarefa['prazo']}', " .
                "concluida = '{$tarefa['concluida']}', " .
                "where id = {$tarefa['id']}";

    $resultado = mysqli_query($conexao, $sqlBusca);
    if (!$resultado){
        return "";
    }else{
        return mysqli_fetch_assoc($resultado);

    }
}

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

include "template.php";
