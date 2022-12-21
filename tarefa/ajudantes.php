<?php

function validar_data($data){
    
    $padrao = '/^[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{4}$/';

    $resultado = preg_match($padrao,$data);

    if(!$resultado){
        return false;
    }

    $dados = explode('/',$data);
    
    $dia = $dados[0];
    $mes = $dados[1];
    $ano = $dados[2];

    return true;
}

function validar_datas($data){
    $partes = explode('/',$data);

    if(count($partes) != 3){
        return false;
    }

    $dia = $partes[0];
    $mes = $partes[1];
    $ano = $partes[2];

    if(strlen($dia) < 1 or strlen($dia) > 2){
        return false;
    }

    if(strlen($mes) < 1 or strlen($mes) > 2){
        return false;
    }

    if(strlen($ano) != 4){
        return false;
    }

    return true;
}

function tem_post(){
    if(count($_POST)>0){
        return true;
    }
    return false;
}

function traduz_prioridade($codigo){
    $prioridade ='';
    switch ($codigo) {
        case 1:
            $prioridade = 'Baixa';
            break;
        
        case 2:
            $prioridade = 'Média';
            break;

        case 3:
            $prioridade = 'Alta';
            break;
        default:
            echo "";
    }

    return $prioridade;

}

function traduz_concluida_exibir($valor){
    $conclusao = '';
    switch ($valor) {
        case 0:
            $conclusao = 'não';
            break;
        
        case 1:
            $conclusao = 'Sim';
            break;
        default:
            echo "";
    }

    return $conclusao;
}

function traduz_data_para_banco($data){
    if($data==""){
        return "";
    }

    $dados = explode("/",$data);

    $data_mysql = "{$dados[2]}-{$dados[1]}-{$dados[0]}";
    
    return $data_mysql;
}

function traduz_data_para_exibir($data){
    if($data == "" || $data == "0000-00-00" ){
        return "";
    }

    $dado = explode("-",$data);

    $data_exibir = "{$dado[2]}/{$dado[1]}/{$dado[0]}";

    return $data_exibir;
}

function tratar_anexo($anexo){
    $padrao = '/^.+(\.pdf|\.zip)$/';
    $resultado = preg_match($padrao, $anexo['name']);
    
    if(!$resultado){
        return false;
    }

    move_uploaded_file($anexo['tmp_name'],"anexos/{$anexo['name']}");

    return true;
}

function traduz_lembrete_exibir($valor){
    $lembrete = '';
    switch ($valor) {
        case 0:
            $lembrete = 'não';
            break;
        
        case 1:
            $lembrete = 'Sim';
            break;
        default:
            echo "";
    }

    return $lembrete;
}