package model;


import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel{

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		// TODO Atelier 1
		this.coord = coord ;
		this.pieceColor = pieceColor ;

	}

	@Override
	public char getColonne() {
		char colonne = ' ';

		// TODO Atelier 1
		colonne = this.coord.getColonne();

		return colonne;
	}

	@Override
	public int getLigne() {
		int ligne = -1;

		// TODO Atelier 1
		ligne = this.coord.getLigne();

		return ligne;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		boolean hasThisCoord = false;

		// TODO Atelier 1
		if (this.coord.getColonne() == coord.getColonne() && this.coord.getLigne() == coord.getLigne()){
			hasThisCoord = true ;
		}

		return hasThisCoord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = null;

		// TODO Atelier 1
		color = this.pieceColor;

		return color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + pieceColor.toString().charAt(0) + coord + "]";
	}

	@Override
	public void move(Coord coord) {

		// TODO Atelier 1
		if (this.hasThisCoord(coord) == false){
			this.coord = coord;
		}

	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		int deplacement = 0;

		// TODO Atelier 1
		if (!this.hasThisCoord(targetCoord)){
			// Si pas de piece a capturer alors déplacement de 1 sinon 2
			if (!isPieceToCapture){
				deplacement = 1;
			}
			else {
				deplacement = 2 ;
			}
			// Vérifie que la case cible n'est pas en dehors du tableau
			if (this.getLigne() - deplacement >= 1 && this.getLigne() + deplacement <=10
				&& this.getColonne() - deplacement >= 'a' && this.getColonne() + deplacement <= 'j' ) {

				if (this.getPieceColor() == PieceSquareColor.WHITE){
					// Vérifie que la case cible correspond bien à une case autorisée en fonction de la couleur de la piece
					if (this.getLigne() + deplacement == targetCoord.getLigne()
							&& (this.getColonne() - deplacement == targetCoord.getColonne() || this.getColonne() + deplacement == targetCoord.getColonne()  )
					){
						return true ;
					}
				}
				else {
					if (this.getLigne() - deplacement == targetCoord.getLigne()
							&& (this.getColonne() - deplacement == targetCoord.getColonne() || this.getColonne() + deplacement == targetCoord.getColonne()  )
					){
						return true ;
					}
				}
			}
		}

		return ret;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>();

		// TODO Atelier 2

		return coordsOnItinery;
	}


}

