package ihm;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Aerienne;
import metier.Cargaison;







public class CargaisonModel extends AbstractTableModel{
	
	private String[] nomColonnes = new String[]{"Reference","Distance","Type "};
	private Vector<String[]> values=new Vector<String[]>();
			
		@Override
		public int getRowCount() {
			return values.size();
		}
		@Override
		public int getColumnCount() {
			return nomColonnes.length;
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return values.get(rowIndex)[columnIndex];
		}
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return nomColonnes[column];
		}
		public void removeRow(int index) {
			values.remove(index);
			fireTableRowsDeleted(index, index);
		}
		
		public void setData(List<Cargaison> cargaisons){
			values=new Vector<String[]>();
			String type="";
			for(Cargaison c:cargaisons) {
				if (c instanceof Aerienne) type="Aerienne" ;
				else type="Routiere";
				values.add(new String[]{c.getReference(),String.valueOf(c.getDistance()),});
			}
		
			
			fireTableChanged(null);
		}
		}


