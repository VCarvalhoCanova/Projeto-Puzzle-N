package nPuzzleUsuario;
import nPuzzle.*;
import nPuzzleMaluco.*;

public class JogoStart {
	private char modo;
	private int dificuldade;
	private UsuarioInfo user = new UsuarioInfo();
	private MatrizNumero mN; 
	private MatrizChar mC= new MatrizChar(3);
	private MatrizNPuzzleMalucoNumero mNPN = new MatrizNPuzzleMalucoNumero(3,5);
	private Recursos r = new Recursos();
	
	
	
	public void layout(){
		
		user.usuarioNome();
		modo=user.modoDeJogo();
		dificuldade=user.dificuldadeDoJogo();
		//r.limparTela();
		
		if(modo=='N') {
			layoutMatrizNumero();
		
		}else if(modo=='C') {
			layoutMatrizChar();
			
		}else if(modo=='M') {
			mNPN.criarTabuleiro();
			r.limparTela();
		while(true){
			mNPN.exibirTabuleiro();
			r.textoAcao();
			mNPN.posicaoDe0();
			mNPN.pecaMovimentaveis();
			mNPN.moverPeca();
			r.limparTela();
			}	
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
		public void layoutMatrizChar() {
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
