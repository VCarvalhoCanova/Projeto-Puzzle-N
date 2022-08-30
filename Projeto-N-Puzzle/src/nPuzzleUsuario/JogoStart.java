package nPuzzleUsuario;
import nPuzzle.*;
import nPuzzle.MatrizChar;
import nPuzzle.Matriz;
import java.util.Random;

public class JogoStart {
	private char modo;
	public void layout(){
		UsuarioInfo user = new UsuarioInfo();
		Matriz m = new Matriz();
		MatrizChar mC= new MatrizChar();
		Recursos r = new Recursos();
		
		
		user.usuarioNome();
		modo=user.modoDeJogo();
		r.limparTela();
		
		if(modo=='N') {
			m.criarTabuleiro();
			r.limparTela();
		while(true){
			m.exibirTabuleiro();
			r.textoAcao();
			m.posicaoDe0();
			m.pecaMovimentaveis();
			m.moverPeca();
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
