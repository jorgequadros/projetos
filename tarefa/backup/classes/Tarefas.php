<?php
    class Tarefas{
        public $tarefas = array();
        public $tarefa;
        public $conexao;
        
        public function __construct($nova_conexao){
            $this->conexao = $nova_conexao;
        }

        public function buscar_tarefas(){
            $sqlBusca = 'select * from tarefa';

            $resultado = mysqli_query($this->conexao,$sqlBusca);
            
            while ($tarefa = mysqli_fetch_assoc($resultado)) {
                $this->tarefas[] = $tarefa;
            }
        }

        public function busca_tarefa($id){
    
            $sqlBusca = 'select * from tarefa where id = ' . $id;
            
            $resultado = mysqli_query($this->conexao, $sqlBusca);
            
            $this->tarefa = mysqli_fetch_assoc($resultado);
            
        }
    
        public function gravar_tarefa($tarefa){
            $sqlGravar = "Insert into tarefa (nome, descricao, prazo, concluida, lembrete, prioridade) values ( 
                '{$tarefa['nome']}',
                '{$tarefa['descricao']}',
                '{$tarefa['prazo']}',
                '{$tarefa['concluida']}',
                {$tarefa['lembrete']},
                {$tarefa['prioridade']})";
            
            mysqli_query ($this->conexao,$sqlGravar);

        }

        public function editar_tarefa($tarefa){
            $sqlEditar = "Update tarefa Set nome = '" 
                . $nome . "', descricao = '" 
                . $descricao . "', prioridade = " 
                . $prioridade .", prazo = '" 
                . $prazo . "', concluida = " 
                . $concluida . ", lembrete = " 
                . $lembrete . " where id = " . $_GET['id']; 

            $resultado = mysqli_query($this->conexao, $sqlEditar);

        }

    }