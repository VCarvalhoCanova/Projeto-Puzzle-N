package nPuzzleUsuario;
import nPuzzle.*;
import nPuzzle.MatrizChar;
import nPuzzleMaluco.*;

public class JogoStart {
	private char modo;
	
	public void layout(){
		UsuarioInfo user = new UsuarioInfo();
		MatrizNumero mN = new MatrizNumero(3);
		MatrizChar mC= new MatrizChar(3);
		MatrizNPuzzleMalucoNumero mNPN = new MatrizNPuzzleMalucoNumero(3,5);
		Recursos r = new Recursos();
		
		
		user.usuarioNome();
		modo=user.modoDeJogo();
		r.limparTela();
		
		if(modo=='N') {
			mN.criarTabuleiro();
			r.limparTela();
		while(true){
			mN.exibirTabuleiro();
			r.textoAcao();
			mN.posicaoDe0();
			mN.pecaMovimentaveis();
			mN.moverPeca();
			r.limparTela();
		}
		}else if(modo=='C') {
			mC.criarTabuleiro();
			r.limparTela();
			while(true){
				mC.exibirTabuleiro();
				r.textoAcao();
				mC.posicaoDe0();
				r.limparTela();
			}
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
	public static void main(String[] args) {
		
		JogoStart p1 = new JogoStart();
		
		p1.layout();
		
		
		
		//Random random = new Random();

		//char a = (char) (65);
        //System.out.println(a);
		
		
		
		
	}
}
