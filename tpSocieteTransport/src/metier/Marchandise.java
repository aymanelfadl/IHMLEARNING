package metier;

import java.io.Serializable;

public class Marchandise implements Serializable{
	
	
	
	private int numero;
	private double poids,volume;
	
	
	
	
	
	
	public Marchandise(int numero, double poids, double volume) {
		
		
		super();
		this.numero = numero;
		this.poids = poids;
		this.volume = volume;
	}
	
	
	public Marchandise() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	// 
	private Cargaison cargaison;

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}

}
