package nPuzzle.src.nPuzzleUsuario;

import java.util.ArrayList;
import java.util.Scanner;


public class UsuarioInfo {
	
	private String nome;
	private String acao;
	private ArrayList <String> jogadas = new ArrayList<> ();
	
	public void usuarioNome() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite seu Nome: ");
		this.nome = sc.nextLine();
		
	}
	
	public String getNome() {
		return nome;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao() {
		
		Scanner sc = new Scanner(System.in);
		this.acao = sc.next();
	}
	
}
