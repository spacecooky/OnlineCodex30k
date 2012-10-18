package oc.wh40k.units.cm2007;

import java.util.Vector;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CM2007DreadclawTalon extends Eintrag {
	
    Vector<RuestkammerStarter> dreadclaws = new Vector<RuestkammerStarter>();//1+
    
	public CM2007DreadclawTalon() {
		name = "Dreadclaw Talon";
		grundkosten = 50;
		add(ico = new oc.Picture("oc/wh40k/images/DreadclawTalon.gif"));
		
        for(int i=0;i<4;i++){
        	dreadclaws.add(new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawKammer", "Dreadclaw",0));
        	dreadclaws.get(i).initKammer();
	        add(dreadclaws.get(i));
	        dreadclaws.get(i).setButtonText("Dreadclaw");
        }
        dreadclaws.get(3).setAktiv(false);
        
		
    	complete();

	}

	public void refreshen() {
		
		adjustOptions(dreadclaws,3,"CMDreadclawKammer", "Dreadclaw",0,0);
		dreadclaws.get(0).setLegal(dreadclaws.get(0).isSelected());
		dreadclaws.get(1).setLegal(dreadclaws.get(1).isSelected());
		dreadclaws.get(2).setLegal(dreadclaws.get(2).isSelected());
		dreadclaws.get(3).setAktiv(dreadclaws.get(0).isSelected() && dreadclaws.get(1).isSelected() && dreadclaws.get(2).isSelected());
		dreadclaws.get(0).setAktiv(true);
		dreadclaws.get(1).setAktiv(true);
		dreadclaws.get(2).setAktiv(true);
		
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
