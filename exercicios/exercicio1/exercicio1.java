import java.util.*;

class exercicio01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// lê a primeira variavel
		System.out.println("Digite o primeiro numero");
		int x = sc.nextInt();

		// lê a segunda variavel
		System.out.println("Digite o segundo numero");
		int y = sc.nextInt();

		// soma as duas variaveis e atribui o resultado em uma terceira variavel
		int z = x + y;

		// printa o resultado da soma atribuida na terceira variavel
		System.out.println("soma: "+z);

		sc.close();
	}
}
