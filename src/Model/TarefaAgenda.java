package Model;

public class TarefaAgenda {

	String titulo;
	String descricao;
	String data;
	
	public TarefaAgenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TarefaAgenda(String titulo, String descricao, String data) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	
}
