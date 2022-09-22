package Model;

public class TarefaAgenda {

	int id;
	String titulo;
	String descricao;
	String data;
	public TarefaAgenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TarefaAgenda(int id, String titulo, String descricao, String data) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id>0) {
			this.id = id;
		}
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(!titulo.equals("")){
			this.titulo = titulo;
		}
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(!descricao.equals("")) {
			this.descricao = descricao;
		}
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		if(!data.equals("")) {
			this.data = data;
		}
	}
	
		
}
