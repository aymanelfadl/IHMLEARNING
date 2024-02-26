package metier;

public class Routiere extends Cargaison{
	
	
	

	public Routiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Routiere(String reference, double distance) {
		super(reference, distance);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double calculerCoutTransport() {
		double v=0,p=0,cout=0;
		// TODO Auto-generated method stub
		
		for(Marchandise m:super.getMarchandises()) {
			v+=m.getVolume();
			p+=m.getPoids();
		}
		
		if (v<80000)cout=this.getDistance()*10*p;
		else cout=this.getDistance()*12*p;
		
		return cout;
	}
	

}
