<table >
    <tr>

        <th>Tarefa</th>
        <th>Descrição</th>
        <th>Prazo</th>
        <th>Prioridade</th>
        <th>Concluída</th>
        <th colspan="2"> Opção</th>
        
    </tr>

    <?php foreach ($tarefas->tarefas as $tarefa) : ?>
            
            <tr>
                <td><a href="tarefa.php?id=<?php echo $tarefa['id'];?>"><?php echo $tarefa['nome']; ?></a></td>
                
                <td><?php echo $tarefa['descricao']; ?></td>
                <td><?php echo traduz_data_para_exibir($tarefa['prazo']); ?></td>
                <td><?php echo traduz_prioridade($tarefa['prioridade']); ?></td>
                <td><?php echo traduz_concluida_exibir($tarefa['concluida']); ?></td>
                <!--O campo com os links para editar e remover -->
                <td>
                <a href="editar.php?id=<?php echo $tarefa['id'];?>">Editar</a>
                </td>
                <td>
                <a href="remover.php?id=<?php echo $tarefa['id'];?>">Excluir</a>
                </td>
            </tr>
    
     <?php endforeach;
        
        $tarefas=array();

        if(isset($_GET['nome']) && $_GET['nome'] !=''){
            $tarefas['nome'] = $_GET['nome'];
            if(isset($_GET['descricao']) && $_GET['descricao']!=''){
                $tarefas['descricao'] = $_GET['descricao'];
                if(isset($_GET['prioridade']) && $_GET['prioridade']!=''){
                    $tarefas['prioridade'] = $_GET['prioridade'];
                    if(isset($_GET['prazo']) && $_GET['prazo']!=''){
                        $tarefas['prazo'] = traduz_data_para_banco($_GET['prazo']);
                        if(isset($_GET['concluida'])){
                            $tarefas['concluida'] = 1;
                            if(!$tem_erros){
                                gravar_tarefa($conexao, $tarefas);  
                                header('Location: tarefas.php');
                                die();
                            }
                        }else{
                            $tarefas['concluida'] = 0;
                            gravar_tarefa($conexao, $tarefas);
                        }
                    }
                }
            }
        } ?>
</table>