package app;

import java.util.List;
import dao.DAO;
import dao.CarroDAO;
import model.Carro;

public class Aplicacao {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		
		CarroDAO carDAO = new CarroDAO();
		
		System.out.println("\n\n{ Informar carro } ");
		Carro car = new Carro(10, "bmw320i", "sedan");
		if(carDAO.insert(car) == true) {
			System.out.println("Inserção com sucesso -> " + car.toString());
		}
		
		System.out.println("\n\n{ Testando autenticação }");
		System.out.println("Usuário (" + car.getNome() + "): " + CarroDAO.autenticar("bmwz40i", "conversivel"));
			
		System.out.println("\n\n{ Mostrar usuários do tipo fogo } ");
		List<Carro> carros = CarroDAO.getOrderByTipo();
		for (Carro u: carros) {
			System.out.println(u.toString());
		}

		System.out.println("\n\n{ Atualizar Tipo (código (" + car.getCodigo() + ") } ");
		car.setTipo(DAO.toMD5("felipe"));
		CarroDAO.update(car);
		
		System.out.println("\n\n{ Testando autenticação }");
		System.out.println("Usuário (" + car.getNome() + "): " + CarroDAO.autenticar("felipe", DAO.toMD5("felipe")));		
		
		System.out.println("\n\n{ Invadir usando SQL Injection }");
		System.out.println("Usuário (" + car.getNome() + "): " + CarroDAO.autenticar("felipe", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n{ Mostrar carros ordenados por código } ");
		car = (Carro) carDAO.getOrderByCodigo();
		for (Carro u: carros) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n{ Excluir usuário (código " + car.getCodigo() + ") } ");
		carDAO.delete(car.getCodigo());
		
		System.out.println("\n\n{ Mostrar usuários ordenados por login } ");
		car = (Carro) carDAO.getOrderByNome();
		for (Carro u: carros) {
			System.out.println(u.toString());
		}
	}
}