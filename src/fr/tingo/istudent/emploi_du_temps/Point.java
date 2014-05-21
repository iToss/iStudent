package fr.tingo.istudent.emploi_du_temps;

/** Objet point (coordonnée X et Y) */
public class Point {
	
	public float x;
	public float y;
	
	public Point(float p_x, float p_y)
	{
		this.x = p_x;
		this.y = p_y;
	}
}


/** Objet vecteur, utilisé pour les mouvements de doigts */
class Vecteur {
	
	public float x;
	public float y;
	
	public Vecteur(Point p1, Point p2)
	{
		this.x = p1.x - p2.x;
		this.y = p1.y - p2.y;
	}

}
