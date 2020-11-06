package p3.damas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import p3.peca.Peca;
import p3.peca.Tabuleiro;

public class Damas extends JFrame implements ActionListener {
	// isto s� c� esta para n�o dar um warning
	private static final long serialVersionUID = 1L;

    private static Icon pedraPreta = new ImageIcon("art/pedra_preta.gif" );
    private static Icon damaPreta = new ImageIcon("art/dama_preta.gif" );

    private static Icon pedraBranca = new ImageIcon("art/pedra_branca.gif" );
    private static Icon damaBranca = new ImageIcon("art/dama_branca.gif" );
    
    private static int DIMCASA = 72;
    private static int MEIADIMCASA = DIMCASA / 2;
		
	private Tabuleiro oTabuleiro = new Tabuleiro( new ImageIcon("art/tabuleirosimples.gif"), new Point(0,0), 72, 8);
	
	private Peca aMover;
	private int  corJogar;
	
	private Point origem;
	private Point destino;
	private Point posicaoMover;

	
	public Damas() {
		super( "Damas" );
		setSize( 670, 670 );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		

		JMenuBar barra =  new JMenuBar( );
		JMenu jogoMenu = new JMenu( "Jogo" );
		JMenuItem novoMenu = new JMenuItem( "Novo jogo" );
		novoMenu.setActionCommand( "novoJogo" );
		novoMenu.addActionListener( this );
		jogoMenu.add( novoMenu );
		
		JMenuItem sairMenu = new JMenuItem( "Sair" );
		sairMenu.setActionCommand( "sair" );
		sairMenu.addActionListener( this );
		jogoMenu.add( sairMenu );
		
		barra.add( jogoMenu );
		
		setJMenuBar( barra );
		
		PainelDesenho panel = new PainelDesenho( );
		panel.setBackground( Color.BLUE );
		
		getContentPane().add( panel, BorderLayout.CENTER );
		
		// activar os listeners
		OuveRato or = new OuveRato();
		
		panel.addMouseListener( or );
		panel.addMouseMotionListener( or );
		
		iniciarJogo();		
	}
	
		
	public void iniciarJogo(){
	    oTabuleiro.limpar();
		
	    // cria��o e coloca��o das pedras
	        	    
	    aMover = null;
	    // indicar qual a cor a jogar 
	}

	
	
	public void actionPerformed( ActionEvent e){
		String cmd = e.getActionCommand();
		if( cmd.equals( "sair" ) ){
			System.exit( 0 );
		}
		else if( cmd.equals("novoJogo" )){
			iniciarJogo();
			Damas.this.repaint();
		}
	}


	private class PainelDesenho extends JPanel {
		// isto s� c� esta para n�o dar um warning
		private static final long serialVersionUID = 1L;
		
		public void paintComponent( Graphics g ){
			super.paintComponent( g );
			
			// desenhar o tabuleiro
			oTabuleiro.desenhar( g );

			// se houver pe�a a mover, desenhar a ep�a a mover
			if( aMover != null ) {
				// colocar a cor do rect�ngulo de movimento
				
				// desenhar o rect�ngulo de indica��o do movimento
				Point topo = oTabuleiro.getEcran( destino );
				g.drawRect( topo.x+2, topo.y+2, DIMCASA - 4 , DIMCASA - 4 );
				
				// desenhar a figura da pe�a
				aMover.getFigura( ).paintIcon( Damas.this, g, posicaoMover.x, posicaoMover.y ); 
			}		

			// desenhar a marca de quem � a jogar
			g.setColor( Color.WHITE );
		}
	}
	

	// classe que vai ouvir os movimentos do rato
	class OuveRato extends MouseAdapter implements MouseMotionListener {
		
		// ouvir o premir do rato
		public void mousePressed( MouseEvent e ){
			// detectar qual a pe�a que se apanhou
			
		}
		
		// ouvir o libertar do rato
		public void mouseReleased( MouseEvent e ) {
			// detectar a casa onde se deixa a pe�a		      
		    Point destino = oTabuleiro.getCasa( e.getPoint() );   // converter coord do ecran em coords do tabuleiro
		    
		    if( aMover == null ) // se n�o houver pe�a a mover n�o se faz nada
		        return;

		    // move a pe�a, se for permitido
		    
		    
		    aMover = null;    // j� n�o h� pe�a a mover
		    repaint();        // redesenhar o ambiente de jogo 			
		}
		
		public void mouseMoved( MouseEvent e ){
			// n�o � necess�rio processar nada
		}

		// ouvir o arrastar do rato - mover o rato com o bot�o pressionado
		public void mouseDragged( MouseEvent e ){
		    if( aMover == null ) // se n�o tiver pe�a n�o se faz nada
		        return;
		        
		    destino = oTabuleiro.getCasa( e.getPoint() );        // coords do ecran em coords do tabuleiro
		    // calcular o meio da casa onde se est� a mover
		    posicaoMover = new Point( e.getX() - MEIADIMCASA, e.getY() - MEIADIMCASA );		    
		    Damas.this.repaint();			
		}

	}


	public static void main(String[] args) {		
		Damas damas = new Damas( );
		damas.setVisible( true );
	}

}
