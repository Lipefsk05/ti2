package model;

public class Carro {
	private int Codigo;
	private static String Nome;
	private String Tipo;
	
	@SuppressWarnings("static-access")
	public Carro() {
		this.Codigo = -1;
		this.Nome = "";
		this.Tipo = "";
	}
	
	@SuppressWarnings("static-access")
	public Carro(int Codigo, String Nome, String Tipo) {
		this.Codigo = Codigo;
		this.Nome = Nome;
		this.Tipo = Tipo;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public static String getNome() {
		return Nome;
	}

	@SuppressWarnings("static-access")
	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}

	@Override
	public String toString() {
		return "Usuario [Codigo=" + Codigo + ", Nome=" + Nome + ", Tipo=" + Tipo + "]";
	}	
}