/**
 * 
 */
package p3.peca;

import java.awt.Point;

import javax.swing.Icon;

/**
 * @author joels
 *
 */
public class pecaDefault implements Peca {

	/**
	 * 
	 */
	public pecaDefault() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean podeMover(Point dest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mover(Point dest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ePromovivel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPosicao(Point pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public Point getPosicao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Direccao getDireccao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDireccao(Direccao dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTabuleiro(Tabuleiro tab) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tabuleiro getTabuleiro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCor(int cor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Icon getFigura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFigura(Icon icon) {
		// TODO Auto-generated method stub

	}

}
