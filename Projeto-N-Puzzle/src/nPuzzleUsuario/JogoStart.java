package nPuzzleUsuario;
import nPuzzle.*;
import nPuzzleMaluco.*;
import nPuzzleUi.*;

public class JogoStart {



	private String modo;
	private int dificuldade,nivelDeMaluquice;
	private UsuarioInfo user;
	private String nome="Default";
	private MatrizAjuda mA;
	private MatrizNumero mN; 
	private MatrizPath mP;
	private PuzzleUiNumero mNU;
	private NPuzzleUiChar mCU;
	private MatrizNPuzzleMalucoNumero mNM; 
	
	
	
	public void layout(){
		user= new UsuarioInfo();
		
	}
		
		public void layoutJogo(String string) {
			if(string.equalsIgnoreCase("N")) {
				layoutMatrizNumero();
			}else if(string.equalsIgnoreCase("C")) {
				layoutMatrizChar();
			}else if(string.equalsIgnoreCase("NM")) {
				mNM = new MatrizNPuzzleMalucoNumero(nivelDeMaluquice);
				layoutMatrizNumeroMaluco();		
			}else if(string.equalsIgnoreCase("CM")) {
				mNM = new MatrizNPuzzleMalucoNumero(nivelDeMaluquice);
				layoutMatrizCharMaluco();
			}else if(string.equalsIgnoreCase("P")) {
				layoutMatrizPath();
			}

		}
	
		public void layoutMatrizNumero(){
			mNU= new PuzzleUiNumero(getDificuldade(),0);
		
}		
		public void layoutMatrizPath() {
			mP= new MatrizPath(getDificuldade());
		}
		
		public void layoutMatrizNumeroMaluco() {
			mNU= new PuzzleUiNumero(getDificuldade(),nivelDeMaluquice);
		}
		public void layoutMatrizCharMaluco() {
			mCU= new NPuzzleUiChar(getDificuldade(),nivelDeMaluquice);
		}
		
		public void layoutMatrizChar() {
			mCU= new NPuzzleUiChar(getDificuldade(),0);
		}
	
	
	
	public static void main(String[] args) {
		
		JogoStart p1 = new JogoStart();
		p1.layout();	
		
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public UsuarioInfo getUser() {
		return user;
	}

	public void setUser(UsuarioInfo user) {
		this.user = user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public int getNivelDeMaluquice() {
		return nivelDeMaluquice;
	}

	public void setNivelDeMaluquice(int nivelDeMaluquice) {
		this.nivelDeMaluquice = nivelDeMaluquice;
	}
}
