package nPuzzleUsuario;
import nPuzzle.*;
import nPuzzle.Matriz;
import java.util.Random;

public class JogoStart {
	
	public void layout(){
		UsuarioInfo user = new UsuarioInfo();
		Matriz m = new Matriz();
		Recursos r = new Recursos();
		
		m.criarTabuleiro();
		user.usuarioNome();
		r.limparTela();
		while(true){
			m.exibirTabuleiro();
			r.textoAcao();
			user.setAcao();
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
