package p3.xadrez;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import p3.peca.Peca;
import p3.peca.Tabuleiro;

public class Xadrez extends JFrame implements ActionListener {
	
	// isto só cá esta para não dar um warning
	private static final long serialVersionUID = 1L;
	
	private static Icon peaoPreto = new ImageIcon("art/peao_preto.gif" );
    private static Icon torrePreta = new ImageIcon("art/torre_preta.gif" );
    private static Icon cavaloPreto = new ImageIcon("art/cavalo_preto.gif" );
    private static Icon bispoPreto = new ImageIcon("art/bispo_preto.gif" );
    private static Icon reiPreto = new ImageIcon("art/rei_preto.gif" );
    private static Icon rainhaPreta = new ImageIcon("art/rainha_preta.gif" );

    private static Icon peaoBranco = new ImageIcon("art/peao_branco.gif" );
    private static Icon torreBranca = new ImageIcon("art/torre_branca.gif" );
    private static Icon cavaloBranco = new ImageIcon("art/cavalo_branco.gif" );
    private static Icon bispoBranco = new ImageIcon("art/bispo_branco.gif" );
    private static Icon reiBranco = new ImageIcon("art/rei_branco.gif" );
    private static Icon rainhaBranca = new ImageIcon("art/rainha_branca.gif" );
    
    private static int DIMCASA = 72;
    private static int MEIADIMCASA = DIMCASA / 2;
		
	private Tabuleiro oTabuleiro = new Tabuleiro( new ImageIcon("art/tabuleirosimples.gif"), new Point(0,0), 72, 8);
	
	private Peca aMover;
	private int  corJogar;
	
	private Point origem;
	private Point destino;
	private Point posicaoMover;
	
	public Xadrez() {
		super( "Xadrez" );
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
		
	    // criação e colocação dos peões
	    
	    // criação e colocação das restantes peças brancas	    

	    // criação e colocação das restantes peças pretas
	    	    
	    aMover = null;
	    //  definir quem éa vez de jogar
    
	}

	

	private class PainelDesenho extends JPanel {
		// isto só cá esta para não dar um warning
		private static final long serialVersionUID = 1L;

		public void paintComponent( Graphics g ){
			super.paintComponent( g );
			oTabuleiro.desenhar( g );

			// desenhar a peça a mover, se houver
			if( aMover != null ) {
				
				// colocar a cor do rectãngulo de movimento
				
				// desenhar o rectângulo de indicação do movimento
				Point topo = oTabuleiro.getEcran( destino );
				g.drawRect( topo.x+2, topo.y+2, DIMCASA - 4 , DIMCASA - 4 );
				
				// desenhar a figura da peça
				aMover.getFigura( ).paintIcon( Xadrez.this, g, posicaoMover.x, posicaoMover.y ); 
			}

			// desenhar a marca de quem é a jogar
			g.setColor( Color.WHITE );

		}
	}
	
	
	public void actionPerformed( ActionEvent e){
		String cmd = e.getActionCommand();
		if( cmd.equals( "sair" ) ){
			System.exit( 0 );
		}
		else if( cmd.equals("novoJogo" )){
			iniciarJogo();
		}
	}
	
	
	
	class OuveRato extends MouseAdapter implements MouseMotionListener {
		public void mousePressed( MouseEvent e ){    			
			// detectar a peça que se apanhou
			
		}
		
		public void mouseReleased( MouseEvent e ) {						
		    Point destino = oTabuleiro.getCasa( e.getPoint() );
		    
		    if( aMover == null ) // se não houver peça a mover não se faz nada
		        return;

		    // move a peça, se for permitido		    		    
		    aMover = null;    // já não há peça a mover
		    repaint();        // redesenhar o ambiente de jogo 			
		}
		
		public void mouseMoved( MouseEvent e ){
			// não é necessário processar nada
		}

		public void mouseDragged( MouseEvent e ){
		    if( aMover == null ) // se não tiver peça não se faz nada
		        return;

		        
		    destino = oTabuleiro.getCasa( e.getPoint() );        // coords do ecran em coords do tabuleiro
		    // calcular o meio da casa onde se está a mover
		    posicaoMover = new Point( e.getX() - MEIADIMCASA, e.getY() - MEIADIMCASA );		    
		    Xadrez.this.repaint();			
		}
	}
	


	public static void main(String[] args) {		
		Xadrez xadrez = new Xadrez( );
		xadrez.setVisible( true );
	}
}
