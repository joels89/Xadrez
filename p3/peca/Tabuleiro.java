package p3.peca;

import java.awt.*;
import javax.swing.ImageIcon;

public class Tabuleiro {

    private ImageIcon figura;
    private int dimensaoCasa;
    private int borda;
    private Point topo;
	private Peca asPecas[][] = new Peca[8][8];
	{
		for( int x= 0; x < 8; x++ )
			for( int y= 0; y < 8; y++ )
				asPecas[x][y] = null;
	}
	
	

    public Tabuleiro( ImageIcon fig, Point t, int dimCasa, int brd ){
    	dimensaoCasa = dimCasa;
    	borda = brd;
    	topo = t;
    	figura = fig;
    }
    
    
    public void desenhar( Graphics g ) {    	
        int offsetX = topo.x + borda;
        int offsetY = topo.y + borda + dimensaoCasa*7;

    	figura.paintIcon( null, g, topo.x, topo.y );

        for( int x = 0; x < 8; x++ )
             for( int y = 0; y < 8; y++ )
                  if( asPecas[x][y] != null )
                	  asPecas[x][y].getFigura().paintIcon( null, g, offsetX + dimensaoCasa * x, offsetY - dimensaoCasa * y);
    }

   
    public boolean eCasaValida( Point casa ) {
        return casa.x>=1 && casa.x <=8 && casa.y>=1 && casa.y<=8;
    }

    
    public void colocarPeca( Point casa, Peca umaPeca  ){
        if( !eCasaValida( casa ) )
            return;
                
        umaPeca.setTabuleiro( this );
        umaPeca.setPosicao( casa );
        asPecas[casa.x-1][casa.y-1] = umaPeca;        
    }
    
  

    public Peca removerPeca( Point casa ){
        if( !eCasaValida( casa ) )
            return null;
            
        int x = casa.x - 1;
        int y = casa.y - 1;
        Peca old = asPecas[x][y];
        asPecas[x][y] = null;
        return old;        
    }

    public Peca getPeca( Point casa ){
        if( !eCasaValida( casa ) )
            return null;
        
        return asPecas[ casa.x-1 ][ casa.y-1 ];        
    }
   
    public Point getCasa( Point ecran ){
        // calcular em que casa se premiu
        // lembrar que tabuleiro tem as coordenadas em baixo, da direita para a 
        // esquerda e a começar em (1,1)
        int x = ((ecran.x - topo.x - borda) / dimensaoCasa) + 1;
        int y = 8 - ((ecran.y - topo.y - borda) / dimensaoCasa);

        // verificar se a casa est� dentro do tabuleiro
        // se não estiver retornar (0,0)
        Point casa = new Point( x, y);
        if( !eCasaValida( casa ) )
            return null;
        return casa;
    }



    public Point getEcran( Point casa ){
        int x = (casa.x - 1) * dimensaoCasa + borda + topo.x;
        int y = (8 - casa.y) * dimensaoCasa + borda + topo.y;
        
        return new Point(x,y);
    }
    
    
    
    public void limpar( ){
   	    for( int x = 0; x < 8; x++ )
   	         for( int y = 0; y < 8; y++ )
   	              asPecas[x][y] = null;
    }
}
