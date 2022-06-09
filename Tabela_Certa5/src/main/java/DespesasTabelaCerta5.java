
public class DespesasTabelaCerta5 {
	private String data;
	private String descricao;
	private Double valor;
	private Boolean edit;
	
	public String getData() {
		return data;
	}
	
	public DespesasTabelaCerta5(String data, String descricao, Double valor) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public DespesasTabelaCerta5() {
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Boolean getEdit() {
		return edit;
	}
	public void setEdit(Boolean edit) {
		this.edit = edit;
	}
}
