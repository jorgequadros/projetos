package persistencia;

public class PessoaDao {

	private String[] pessoas = new String[100];
	
	private int proximaPosicao() {
		int tamanho = pessoas.length;
		for (int i = 0; i < tamanho; i++) {
			if(pessoas[i]==null) {
				return i;
			}
		}
		return tamanho;
		
	}
	
	public String adicionaPessoa(String pessoa) {
		int proximaPosicao = proximaPosicao();
		if(proximaPosicao < pessoas.length) {
			pessoas[proximaPosicao]=pessoa;
			return "Pessoa Inserida!";
		}else {
			return "Base de Dados cheias";
		}
	}
	
	public void excluirPessoa(int posicao) {
		int tamanho = pessoas.length;
		for (int i = posicao+1; i < tamanho; i++) {
			pessoas[i-1] = pessoas[i];
		}
		pessoas[tamanho-1]=null;
	}
	
	public String consultaPessoa(int posicao) {
		return pessoas[posicao];
	}
	
	public String[] consultaPessoas() {
		int proximaPosicao = proximaPosicao();
		String pessoasAux[] = new String[proximaPosicao];
		for (int i = 0; i < proximaPosicao; i++) {
			pessoasAux[i] = pessoas[i];
		}
		return pessoasAux;
	}
}
