package nPuzzle;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MatrizPath extends Matriz{
	
	public BufferedImage icon32 = loadBufferedImage("/Imagens/0.jpg");
	public BufferedImage icon64 = loadBufferedImage("/Imagens/1.png");

	private BufferedImage loadBufferedImage(String string)
	{
	    try
	    {
	        BufferedImage bi = ImageIO.read(this.getClass().getResource(string));
	        return bi;
	    } catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	private int [] [] tabuleiro = new int [3] [3];
	private int [] [] matrizResposta = new int [3] [3]; 
	private Random rand = new Random();
	
	
	public static void main(String[] args) {
		MatrizPath mP = new MatrizPath();
		
			mP.criarTabuleiro();
			mP.posicaoDe0();
		
	}

}
