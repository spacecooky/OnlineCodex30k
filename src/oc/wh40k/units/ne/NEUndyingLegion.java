package oc.wh40k.units.ne;

import java.util.Vector;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class NEUndyingLegion extends Eintrag {

	 
	OptionsEinzelUpgrade pylon;
    Vector<RuestkammerStarter> krieger = new Vector<RuestkammerStarter>();//4+
    
	public NEUndyingLegion() {
		name = "Undying Legion";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/UndyingLegion.gif"));
		
		
		add(pylon = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "NEPylonKammer", "Pylon",420));
		
		
		seperator();
        
        for(int i=0;i<5;i++){
        	krieger.add(new RuestkammerStarter(ID, randAbstand, cnt, "NEKriegerKammer", "Krieger",1));
        	krieger.get(i).initKammer();
	        add(krieger.get(i));
	        krieger.get(i).setButtonText("Krieger");
        }
        krieger.get(4).setAktiv(false);
        
    	complete();

	}

	public void refreshen() {
		pylon.setSelected(true);
		
		adjustOptions(krieger,4,"NEKriegerKammer", "Krieger",1,1);
		krieger.get(0).setLegal(krieger.get(0).isSelected());
		krieger.get(1).setLegal(krieger.get(1).isSelected());
		krieger.get(2).setLegal(krieger.get(2).isSelected());
		krieger.get(3).setLegal(krieger.get(3).isSelected());
		krieger.get(4).setAktiv(krieger.get(3).isSelected() && krieger.get(2).isSelected() && krieger.get(1).isSelected() && krieger.get(0).isSelected());
		krieger.get(0).setAktiv(true);
		krieger.get(1).setAktiv(true);
		krieger.get(2).setAktiv(true);
		krieger.get(3).setAktiv(true);
		

		aktualisiereKammerStarterLocation();
		
	}
	
	//Entfernt aus dem Vektor alle überzähligen nicht ausgewählten Einträge.
	//Fügt einen neuen auswählbaren Eintrag hinter dem letzten der gleichen Einheit ein, falls alle ausgewählt wurden.
	//Könnte man evtl. in Eintrag übermehmen...
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
