package nPuzzleUsuario;
import nPuzzle.*;
import nPuzzleMaluco.*;
import nPuzzleUi.*;

public class JogoStart {



	private String modo;
	private int dificuldade,nivelDeMaluquice;
	private UsuarioInfo user = new UsuarioInfo();
	private MatrizAjuda mA;
	private MatrizNumero mN; 
	private MatrizChar mC;
	private MatrizPath mP;
	private MatrizNPuzzleMalucoNumero mNPN;
	private MatrizNPuzzleMalucoChar mNPC;
	private Recursos r = new Recursos();
	
	
	
	public void layout(){
		
		user.usuarioNome();
		System.out.println("Numero-N"
						+ " Char-C"
						+ " Numero Maluco-NM"
						+ " Char Maluco-CM"
						+ " Path-P");
		modo=user.modoDeJogo();
		dificuldade=user.dificuldadeDoJogo();
		
		//r.limparTela();
		
		if(modo.equalsIgnoreCase("N")) {
			layoutMatrizNumero();
		}else if(modo.equalsIgnoreCase("C")) {
			layoutMatrizChar();
		}else if(modo.equalsIgnoreCase("NM")) {
			layoutMatrizNumeroMaluco();		
		}else if(modo.equalsIgnoreCase("CM")) {
			layoutMatrizCharMaluco();
			
		}else if(modo.equalsIgnoreCase("A")) {
			mA = new MatrizAjuda(dificuldade);
		}else if(modo.equalsIgnoreCase("P")) {
			layoutMatrizPath();
		}
	}
	
		public void layoutMatrizNumero(){
			mN= new MatrizNumero(dificuldade);
			mN.criarTabuleiro();
			r.limparTela();
		while(true){
			mN.exibirTabuleiro();
			r.textoAcao();
			mN.posicaoDe0();
			mN.pecaMovimentaveis();
			try {
				mN.moverPeca();
			} catch (ValorInvalido e) {
				e.printStackTrace();
			}
			mN.exibirTabuleiro();
			r.limparTela();
		}
		
}		
		public void layoutMatrizPath() {
			mP= new MatrizPath(dificuldade);
			while(true) {
				
			}
			
			
		}
		
		public void layoutMatrizNumeroMaluco() {
			nivelDeMaluquice=user.nivelDeMaluquice();
			mNPN= new MatrizNPuzzleMalucoNumero(dificuldade,nivelDeMaluquice);
			mNPN.criarTabuleiro();
			r.limparTela();
		while(true){
			mNPN.exibirTabuleiro();
			r.textoAcao();
			mNPN.posicaoDe0();
			mNPN.pecaMovimentaveis();
			try {
				mNPN.moverPeca();
			} catch (ValorInvalido e) {
				e.printStackTrace();
			}
			mNPN.chanceDeEmbaralhar();
			r.limparTela();
			}	

		}
		public void layoutMatrizCharMaluco() {
			nivelDeMaluquice=user.nivelDeMaluquice();
			mNPC= new MatrizNPuzzleMalucoChar(dificuldade,nivelDeMaluquice);
			mNPC.criarTabuleiro();
			r.limparTela();
		while(true){
			mNPC.exibirTabuleiro();
			r.textoAcao();
			mNPC.posicaoDe0();
			mNPC.pecaMovimentaveis();
			try {
				mNPC.moverPeca();
			} catch (ValorInvalido e) {
				e.printStackTrace();
			}
			mNPC.chanceDeEmbaralhar();
			r.limparTela();
			}
		}
		
		public void layoutMatrizChar() {
			mC= new MatrizChar(dificuldade);
			mC.criarTabuleiro();
			r.limparTela();
			while(true){
				mC.exibirTabuleiro();
				r.textoAcao();
				mC.posicaoDe0();
				mC.pecaMovimentaveis();
				try {
					mC.moverPeca();
				}catch (ValorInvalido e) {
					e.printStackTrace();
				}
				mC.exibirTabuleiro();
				r.limparTela();
			}
		}
	
	
	
	public static void main(String[] args) {
		
		JogoStart p1 = new JogoStart();
		p1.layout();
		
		
		
		//Random random = new Random();

		//char a = (char) (65);
        //System.out.println(a);
		
		
		
		
	}
}
