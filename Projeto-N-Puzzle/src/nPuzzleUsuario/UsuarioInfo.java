package nPuzzleUsuario;



import java.io.Serializable;



public class UsuarioInfo implements Serializable{
	
	private static final long serialVersionUID= 1L;
	private String nome;
	private String modoDeJogo;
	private int nivelDeMaluquice;
	private int elapsedTime;
	private int dificuldade;
	private int contadorDePassos;
	private int [][]tabuleiro;
	 
	
	

   
	
	public String getNome() {
		return nome;
	}
	
	public int getNivelDeMaluquice() {
		return nivelDeMaluquice;
	}


	public void setNome(String nome) {
		this.nome=nome;
		
	}

	public String getModoDeJogo() {
		return modoDeJogo;
	}

	public void setModoDeJogo(String modoDeJogo) {
		this.modoDeJogo = modoDeJogo;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public void setNivelDeMaluquice(int nivelDeMaluquice) {
		this.nivelDeMaluquice = nivelDeMaluquice;
	}

	public int getContadorDePassos() {
		return contadorDePassos;
	}

	public void setContadorDePassos(int contadorDePassos) {
		this.contadorDePassos = contadorDePassos;
	}

	public int [][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int [][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
}
