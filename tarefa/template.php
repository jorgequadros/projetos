<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Trabalhando com banco de dados</title>
</head>
<body>
<h1>Gerenciador de Tarefa.</h1>

<?php include('formulario.php');?>
<?php if($exibe_tabela) : ?>
<?php include('tabela.php'); ?>
<?php endif;  ?>

</body>
</html>