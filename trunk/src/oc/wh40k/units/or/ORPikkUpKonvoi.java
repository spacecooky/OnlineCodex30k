package oc.wh40k.units.or;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORPikkUpKonvoi extends Eintrag {

	 
	
    
    Vector<RuestkammerStarter> pikkup = new Vector<RuestkammerStarter>();//3+

	public ORPikkUpKonvoi() {
		name = "Pikk-Up-Konvoi";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/PikkUpKonvoi.gif"));
		
		
        for(int i=0;i<4;i++){
        pikkup.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORPikkUpKammer", "Pikk-Up"));
        pikkup.get(i).initKammer();
        add(pikkup.get(i));
        pikkup.get(i).setButtonText("Pikk-Up");
        }
        pikkup.get(3).setAktiv(false);
        
    	complete();

	}

	public void refreshen() {
		
		adjustOptions(pikkup,3,"ORPikkUpKammer", "Pikk-Up",0,0);
		pikkup.get(0).setLegal(pikkup.get(0).isSelected());
		pikkup.get(1).setLegal(pikkup.get(1).isSelected());
		pikkup.get(2).setLegal(pikkup.get(2).isSelected());
		pikkup.get(3).setAktiv(pikkup.get(2).isSelected() && pikkup.get(1).isSelected() && pikkup.get(0).isSelected());
		pikkup.get(0).setAktiv(true);
		pikkup.get(1).setAktiv(true);
		pikkup.get(2).setAktiv(true);
		
		aktualisiereKammerStarterLocation();
		
	}
	
	//Entfernt aus dem Vektor alle überzähligen nicht ausgewählten Einträge.
	//Fügt einen neuen auswählbaren Eintrag hinter dem letzten der gleichen Einheit ein, falls alle ausgewählt wurden.
	public void adjustOptions(Vector<RuestkammerStarter> starter, int minOptions, String unit, String unitName, int offset, int einrueck){
		
		
		for(int i=0;i<starter.size()-1 && starter.size()>(minOptions+1);i++){
			if(!starter.get(i).isSelected()){
				remove(starter.get(i));
				starter.remove(i);
				i--;
			}
		}
		
		if(starter.lastElement().isSelected()){
			RuestkammerStarter ruest = new RuestkammerStarter(ID, randAbstand, cnt, unit, unitName,einrueck);
			starter.add(ruest);
			ruest.initKammer();
			addAt(ruest, offset+starter.size()-1);
			ruest.setButtonText(unitName);
		}
	
	}
	
	
}
