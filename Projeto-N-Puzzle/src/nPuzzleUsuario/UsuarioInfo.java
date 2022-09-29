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
	
	public int dificuldadeDoJogo() {
		System.out.println("Qual a dificuldade desejada?");
		System.out.println("Facil-3x3->3");
		System.out.println("Medio-4x4->4");
		System.out.println("Dificil-5x5->5");
		int dificuldade = sc.nextInt();
		return dificuldade;
		
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
