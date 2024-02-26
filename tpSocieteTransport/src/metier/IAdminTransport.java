package metier;

public interface IAdminTransport extends IClientTransport{
	
	public void ajouterMarchandise(Marchandise m,String ref);
	public void ajouterCargaison(Cargaison c);
	public void supprimerCargaison(Cargaison c);
	public void enregistrerCarfgaison(String file);


}
