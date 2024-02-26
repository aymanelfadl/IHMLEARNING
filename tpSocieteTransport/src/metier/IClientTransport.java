package metier;

import java.util.List;

public interface IClientTransport {
	
	

	public Cargaison consulterCargaisonParRef(String ref);
	public Marchandise consulterMarchandiseParNum(int num);
	public void lireFichierCargaison(String file);
	public List<Cargaison> consultercargaisons();
	

}
