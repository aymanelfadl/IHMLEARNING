package metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class SocieteTransport implements IAdminTransport{
	
	private HashMap<String, Cargaison> carMap=new HashMap<String, Cargaison>();

	
	
	@Override
	public Cargaison consulterCargaisonParRef(String ref) {
		
		return carMap.get(ref);
	}

	@Override
	public Marchandise consulterMarchandiseParNum(int num) {
		Marchandise mr=null;
		for (Entry<String, Cargaison> e:carMap.entrySet()) {
			
			for(Marchandise m: e.getValue().getMarchandises()) {
				if(m.getNumero()==num) {
					mr=m;
					break;
				}
			}
			
		}
		return mr;
	}

	@Override
	public void lireFichierCargaison(String file) {
		try {
			
			File f=new File(file);
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fis);
			carMap=(HashMap<String, Cargaison>)ois.readObject();
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cargaison> consultercargaisons() {
		
		List<Cargaison> cargaisons=new ArrayList<Cargaison>();
		for(Cargaison c: carMap.values()) {
			cargaisons.add(c);
		}
		return cargaisons ;
	}

	@Override
	public void ajouterMarchandise(Marchandise m,String ref) {
		carMap.get(ref).getMarchandises().add(m);
		
		
	}

	@Override
	public void ajouterCargaison(Cargaison c) {
		carMap.put(c.getReference(), c);
		
	}

	@Override
	public void supprimerCargaison(Cargaison c) {
		carMap.remove(c.getReference());
		
	}

	@Override
	public void enregistrerCarfgaison(String file) {
		try {
			
			File f=new File(file);
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(carMap);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
