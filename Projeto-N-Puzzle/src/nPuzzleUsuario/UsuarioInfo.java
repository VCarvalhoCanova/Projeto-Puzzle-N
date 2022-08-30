package nPuzzleUsuario;

import java.util.ArrayList;
import java.util.Scanner;


public class UsuarioInfo {
	
	private String nome;
	private String acao;
	private ArrayList <String> jogadas = new ArrayList<> ();
	Scanner sc = new Scanner(System.in);
	public void usuarioNome() {
		
		
		System.out.print("Digite seu Nome: ");
		this.nome = sc.nextLine();
		
		
	}
	public  char modoDeJogo() {
		System.out.println("Qual o modo de jogo desejado ");
		char modo = sc.next().charAt(0);
		return modo;
	}
	
	public String getNome() {
		return nome;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao() {
		this.acao = sc.next();
		
	}
	
	
}
