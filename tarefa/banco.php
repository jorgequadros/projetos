<?php 

$conexao = mysqli_connect(BD_SERVIDOR, BD_USUARIO, BD_SENHA, BD_BANCO);

if (mysqli_connect_errno($conexao)){
    echo "<h1>Problemas para conectar no banco. Verifique os dados!</h1>";
    die();
}

?>