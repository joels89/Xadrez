package p3.peca;

import java.awt.Point;

import javax.swing.Icon;

public interface Peca {
	
    boolean podeMover( Point dest );
    
	public boolean mover( Point dest );	
   
    public boolean ePromovivel( );
    
    public void setPosicao( Point pos );
    
    public Point getPosicao( );
    
    public Direccao getDireccao();
    
    public void setDireccao( Direccao dir );
	
	public void setTabuleiro( Tabuleiro tab );
	
	public Tabuleiro getTabuleiro( );
	
	public int getCor();
	
	public void setCor( int cor );
	
	public Icon getFigura( );
	
	public void setFigura( Icon icon );	
	
}
