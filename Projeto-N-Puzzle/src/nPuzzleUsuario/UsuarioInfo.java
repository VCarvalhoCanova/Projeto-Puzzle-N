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
	public  String modoDeJogo() {
		System.out.println("Qual o modo de jogo desejado ");
		String modo = sc.next();
		
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
	public int nivelDeMaluquice() {
		System.out.println("Escolha um nivel de maluquice entre 1 e 10");
		int nivelDeMaluquice=sc.nextInt();
		return nivelDeMaluquice;
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
