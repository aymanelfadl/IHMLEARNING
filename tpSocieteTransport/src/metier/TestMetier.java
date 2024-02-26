package metier;

public class TestMetier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocieteTransport metier=new SocieteTransport();
		/*
		 * SocieteTransport metier=new SocieteTransport(); Routiere r1=new
		 * Routiere("CR1", 3000); Aerienne a1=new Aerienne("AE1",7000);
		 * 
		 * metier.ajouterCargaison(r1); metier.ajouterCargaison(a1);
		 * 
		 * Marchandise m=new Marchandise(1,10,0.5); Marchandise m1=new
		 * Marchandise(2,10,0.5); Marchandise m2=new Marchandise(3,10,0.5); Marchandise
		 * m3=new Marchandise(4,10,0.5); Marchandise m4=new Marchandise(5,10,0.5);
		 * Marchandise m5=new Marchandise(6,10,0.5); Marchandise m6=new
		 * Marchandise(7,10,0.5);
		 * 
		 * metier.ajouterMarchandise(m, "CR1");
		 * 
		 * metier.ajouterMarchandise(m1, "CR1"); metier.ajouterMarchandise(m2, "CR1");
		 * metier.ajouterMarchandise(m3, "AE1"); metier.ajouterMarchandise(m4, "AE1");
		 * metier.ajouterMarchandise(m5, "AE1"); metier.ajouterMarchandise(m6, "AE1");
		 * 
		 * System.out.println(metier.consulterCargaisonParRef("CR1").
		 * calculerCoutTransport());
		 * System.out.println(metier.consulterCargaisonParRef("AE1").
		 * calculerCoutTransport());
		 * 
		 * metier.enregistrerCarfgaison("gi.data");
		 */
		
		metier.lireFichierCargaison("gi.data");
		System.out.println(" CR1 : "+metier.consulterCargaisonParRef("CR1"). calculerCoutTransport());
		System.out.println(" AE1 : "+metier.consulterCargaisonParRef("AE1"). calculerCoutTransport());
		
	}

}
