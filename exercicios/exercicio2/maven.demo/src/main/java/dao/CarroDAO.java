package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Carro;

public class CarroDAO extends DAO {
	
	public CarroDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Carro car) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			@SuppressWarnings("static-access")
			String sql = "INSERT INTO Carro (Nome, Tipo, Codigo) "
				       + "VALUES ("+car.getNome()+ ", '" + car.getTipo() + "', '"  
				       + car.getCodigo()+"');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Carro get(int codigo) {
		Carro car = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + codigo;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 car = new Carro(rs.getInt("Codigo"), rs.getString("Tipo"),rs.getString("Nome"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return car;
	}
	
	
	public List<Carro> get() {
		return get("");
	}

	
	public List<Carro> getOrderByCodigo() {
		return get("codigo");		
	}
	
	
	public List<Carro> getOrderByNome() {
		return get("Nome");		
	}
	
	
	public static List<Carro> getOrderByTipo() {
		return get("Tipo");		
	}
	
	
	private static List<Carro> get(String orderBy) {	
	
		List<Carro> carros = new ArrayList<Carro>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Carro u = new Carro(rs.getInt("Codigo"), rs.getString("Tipo"),rs.getString("Nome"));
	            carros.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}


	public List<Carro> getSexoMasculino() {
		List<Carro> carros = new ArrayList<Carro>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE usuario.sexo LIKE 'M'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Carro u = new Carro(rs.getInt("Codigo"), rs.getString("Tipo"),rs.getString("Nome"));
	            carros.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}
	
	
	public static boolean update(Carro car) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			@SuppressWarnings("static-access")
			String sql = "UPDATE usuario SET Nome = '" + car.getNome()+ "', Tipo = '"  
				       + car.getTipo() + "', "
					   + " WHERE codigo = " + car.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM Carro WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public static boolean autenticar(String Nome, String Tipo) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Carro WHERE Nome LIKE '" + Nome + "' AND Tipo LIKE '" + Tipo  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}