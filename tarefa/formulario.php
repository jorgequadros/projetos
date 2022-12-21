<form method="POST">
    <input type="hidden" name="id" value="<?php echo $tarefa['id'];?>"/>
    
    <fieldset>
        
        <legend>Nova tarefa</legend>
        <label for="nome">Nome: <?php if($tem_erros && isset($erros_validacao['nome'])) : ?>
        <span class="erro"><?php echo $erros_validacao['nome'];?></span><?php endif; ?>
            <input type="text" name="nome" id="nome" value="<?php echo $tarefa['nome']; ?>" />
        </label>
        
        <label for="descricao">Descrição (Opcional):
            <textarea name="descricao" cols="30" rows="10"><?php echo $tarefa['descricao']; ?></textarea>
        </label>
        
        <label> Prazo (Opcional):  <?php if($tem_erros && isset($erros_validacao['prazo'])) : ?>
        <span class="erro"><?php echo $erros_validacao['prazo'];?></span><?php endif; ?>
            <input type="text" name="prazo" id="" value="<?php echo traduz_data_para_exibir($tarefa['prazo']);?>"/>
        </label>

        <fieldset>
            <legend>Prioridade</legend>
            
                <input type="radio" name="prioridade" value="1" id="" <?php echo ($tarefa['prioridade'] == 1) ? 'checked' : ''; ?>/>Baixa
                <input type="radio" name="prioridade" value="2" id="" <?php echo ($tarefa['prioridade'] == 2) ? 'checked' : ''; ?>/>Média
                <input type="radio" name="prioridade" value="3" id="" <?php echo ($tarefa['prioridade'] == 3) ? 'checked' : ''; ?>/>Alto
            
        </fieldset>
        <label for="concluida">Tarefa concluída: 
            <input type="checkbox" name="concluida" value="1" id="" <?php echo ($tarefa['concluida'] == 1) ? 'checked' : ''; ?>/>
        </label>
        <label>Lembrete por E-mail:
            <input type="checkbox" name="lembrete" value="1" <?php echo ($tarefa['lembrete'] == 1) ? 'checked' : ''; ?>/>
        </label>
        <input type="submit" value="<?php echo (isset($tarefa['id']) && $tarefa['id'] > 0 && $tarefa['id'] != '' ? 'Atualizar' : 'Cadastrar');?>"/>
    </fieldset>
</form>