package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Cargaison implements Serializable{
	
	private String reference;
	private double distance;
	
	private List<Marchandise> marchandises =new ArrayList<Marchandise>();
	
	public abstract double calculerCoutTransport();

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Cargaison(String reference, double distance) {
		super();
		this.reference = reference;
		this.distance = distance;
	}
	
	
	public Cargaison() {
		super();
		
	}

	public List<Marchandise> getMarchandises() {
		return marchandises;
	}

	public void setMarchandises(List<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}
	
	
	public void ajouterMarchandise(Marchandise m) {
		marchandises.add(m);
		m.setCargaison(this);
	}
	
	

	

}
