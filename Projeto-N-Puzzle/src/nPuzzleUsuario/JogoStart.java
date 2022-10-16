package nPuzzleUsuario;
import nPuzzle.*;
import nPuzzleMaluco.*;
import nPuzzleUi.*;

public class JogoStart {


	private int elapsedTime;
	private boolean jogoPrevio;
	private String modo;
	private int dificuldade,nivelDeMaluquice,contadorDePassos;
	public int [][] tabuleiro,matrizResposta;
	private String nome;
	private UsuarioInfo user;
	private Menu m;
	private JogoStart jS;
	private MatrizNumero mN; 
	private MatrizPath mP;
	private PuzzleUiNumero mNU;
	private NPuzzleUiChar mCU;
	private MatrizNPuzzleMalucoNumero mNM; 
	
	
	
	public void layout(){
		m= new Menu(false);
		jogoPrevio=false;
		m.menuStart();    
	}
	
		
		public void layoutJogo(boolean jogoPrevio) {
			user= new UsuarioInfo();
			setmN(new MatrizNumero(dificuldade));
			
			if(modo.equalsIgnoreCase("N")) {
				layoutMatrizNumero(jogoPrevio);
			}else if(modo.equalsIgnoreCase("C")) {
				layoutMatrizChar(jogoPrevio);
			}else if(modo.equalsIgnoreCase("NM")) {
				setmNM(new MatrizNPuzzleMalucoNumero(nivelDeMaluquice));
				layoutMatrizNumeroMaluco(jogoPrevio);		
			}else if(modo.equalsIgnoreCase("CM")) {
				setmNM(new MatrizNPuzzleMalucoNumero(nivelDeMaluquice));
				layoutMatrizCharMaluco(jogoPrevio);
			}else if(modo.equalsIgnoreCase("P")) {
				layoutMatrizPath(jogoPrevio);
			}

		}
	
		public void layoutMatrizNumero(boolean jogoPrevio){
			mNU= new PuzzleUiNumero(dificuldade,nivelDeMaluquice,tabuleiro,contadorDePassos,matrizResposta,jogoPrevio);
			mNU.setNome(nome);
			mNU.setModo(modo);
			mNU.setElapsedTime(elapsedTime);
		}
		
		public void layoutMatrizPath(boolean jogoPrevio) {
			mP= new MatrizPath(dificuldade,nivelDeMaluquice,tabuleiro,contadorDePassos,matrizResposta,jogoPrevio);
			mP.setNome(nome);
			mP.setModo(modo);
			mP.setElapsedTime(elapsedTime);
		}
		
		public void layoutMatrizNumeroMaluco(boolean jogoPrevio) {
			mNU= new PuzzleUiNumero(dificuldade,nivelDeMaluquice,tabuleiro,contadorDePassos,matrizResposta,jogoPrevio);
			mNU.setNome(nome);
			mNU.setModo(modo);
			mNU.setElapsedTime(elapsedTime);
		}
		public void layoutMatrizCharMaluco(boolean jogoPrevio) {
			mCU= new NPuzzleUiChar(dificuldade,nivelDeMaluquice,tabuleiro,contadorDePassos,matrizResposta,jogoPrevio);
			mCU.setNome(nome);
			mCU.setModo(modo);
			mCU.setElapsedTime(elapsedTime);
			
		}
		
		public void layoutMatrizChar(boolean jogoPrevio) {
			mCU= new NPuzzleUiChar(dificuldade,nivelDeMaluquice,tabuleiro,contadorDePassos,matrizResposta,jogoPrevio);
			mCU.setNome(nome);
			mCU.setModo(modo);
			mCU.setElapsedTime(elapsedTime);
		}
		
		public void CarregarJogo() {
			
			try {
				UsuarioInfo user = (UsuarioInfo) SalvarECarregar.load("resource//1.save");
				nome = user.getNome();
				modo = user.getModoDeJogo();
				dificuldade=user.getDificuldade();
				nivelDeMaluquice=user.getNivelDeMaluquice();
				tabuleiro=user.getTabuleiro();
				matrizResposta=user.getMatrizResposta();
				contadorDePassos=user.getContadorDePassos();
				elapsedTime = user.getElapsedTime();
				layoutJogo(true);
				
			} catch (Exception e) {
				m=new Menu(false);
				m.naoPodeCarregar();
			} 
			

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
	public int getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public void setNome(String nome) {
		this.nome=nome;
		
	}
	public MatrizNumero getmN() {
		return mN;
	}
	public void setmN(MatrizNumero mN) {
		this.mN = mN;
	}
	public MatrizNPuzzleMalucoNumero getmNM() {
		return mNM;
	}
	public void setmNM(MatrizNPuzzleMalucoNumero mNM) {
		this.mNM = mNM;
	}
	public int [][] getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(int [][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
