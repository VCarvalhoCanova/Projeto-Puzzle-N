package nPuzzle.src.nPuzzleUsuario;
import nPuzzle.*;
import nPuzzle.src.nPuzzle.Matriz;
import java.util.Random;

public class JogoStart {
	
	public void layout(){
		UsuarioInfo user = new UsuarioInfo();
		Matriz m = new Matriz();
		Recursos r = new Recursos();
		user.usuarioNome();
		m.criarTabuleiro();
		r.textoAcao();
		user.setAcao();
	}
	public static void main(String[] args) {
		JogoStart p1 = new JogoStart();
		p1.layout();
		//Random random = new Random();

		//char a = (char) (65);
        //System.out.println(a);
		
		
		
		
	}
}
