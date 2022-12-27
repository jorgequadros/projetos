<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Gerenciador de Tarefa</title>
</head>
<body>
    <h1>Tarefa: <?php echo $tarefa['nome'];?> </h1>
    <a href="tarefas.php">Voltar para a lista de tarefas.</a></p>
    <p>
        <strong>Concluída: </strong><?php echo traduz_concluida_exibir($tarefa['concluida'])?>
    </p>
    <p>
        <strong>Descrição: </strong><?php echo $tarefa['descricao'];?>
    </p>
    <p>
        <strong>Prazo: </strong><?php echo traduz_data_para_exibir($tarefa['prazo']);?>
    </p>
    <p>
        <strong>Prioridade: </strong><?php traduz_prioridade($tarefa['prioridade']);?>
    </p>
    <h2>Anexos</h2>
    <?php if(count($anexos) > 0) : ?>
    <table>
        <tr>
            <th>Arquivo</th>
            <th>Opções</th>
        </tr>
        <?php foreach ($anexos as $anexo) : ?>
        <tr>
            <td><?php echo $anexo['nome']?></td>
            <td><a href="<?php echo $anexo['arquivo']?>">Download</a></td>
        </tr>
        <?php endforeach;?>
    </table>
    <?php else :?>
        <p>Não há anexos para esta tarefa.</p>
    <?php endif;?>
    <h2>Novo Anexo</h2>
    <form action="" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Novo anexo.</legend>
            <input type="hidden" name="tarefa_id" value="<?php echo $tarefa['id'];?>">
            <label for=""><?php if($tem_erros && isset($erros_validacao['anexo'])):?><span class="erro"><?php echo $erros_validacao['anexo'];?></span>
            <?php endif;?>
            <input type="file" name="anexo" id="">
            </label>
            <input type="submit" value="Cadastrar">
        </fieldset>
    </form>
</body>
</html>