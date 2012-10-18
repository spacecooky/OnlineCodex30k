package oc.wh40k.units.de;

import java.util.Vector;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DESichelfluegelKlingenschwadron extends Eintrag {
	 
	RuestkammerStarter principalis;
    Vector<RuestkammerStarter> sichelfluegel = new Vector<RuestkammerStarter>();//3+
    
	public DESichelfluegelKlingenschwadron() {
		name = "Sichelflügel-Klingenschwadron";
		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/DESichelfluegelKlingenschwadron.gif"));
		
        for(int i=0;i<4;i++){
        	sichelfluegel.add(new RuestkammerStarter(ID, randAbstand, cnt, "DESichelfluegelJaegerKammer", "Sichelflügel",1));
        	sichelfluegel.get(i).initKammer();
	        add(sichelfluegel.get(i));
        }
        sichelfluegel.get(3).setAktiv(false);
        
        complete();

	}

	public void refreshen() {
		
		adjustOptions(sichelfluegel,3,"DESichelfluegelJaegerKammer", "Sichelflügel",0,1);
		sichelfluegel.get(0).setLegal(sichelfluegel.get(0).isSelected());
		sichelfluegel.get(1).setLegal(sichelfluegel.get(1).isSelected());
		sichelfluegel.get(2).setLegal(sichelfluegel.get(2).isSelected());
		sichelfluegel.get(3).setAktiv(sichelfluegel.get(2).isSelected() && sichelfluegel.get(1).isSelected() && sichelfluegel.get(0).isSelected());
		sichelfluegel.get(0).setAktiv(true);
		sichelfluegel.get(1).setAktiv(true);
		sichelfluegel.get(2).setAktiv(true);

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
		}
	
	}
	
	
}
