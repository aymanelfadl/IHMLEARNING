package metier;

public class Aerienne extends Cargaison{
	
	

	public Aerienne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aerienne(String reference, double distance) {
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
		
		if (v<380000)cout=this.getDistance()*4*p;
		else cout=this.getDistance()*6*p;
		
		return cout;
	}

}
