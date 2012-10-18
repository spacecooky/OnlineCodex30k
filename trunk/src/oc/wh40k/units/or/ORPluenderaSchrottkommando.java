package oc.wh40k.units.or;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORPluenderaSchrottkommando extends Eintrag {

    Vector<RuestkammerStarter> pluenderaz = new Vector<RuestkammerStarter>();//3+
    Vector<RuestkammerStarter> beutepanza = new Vector<RuestkammerStarter>();//0+

	public ORPluenderaSchrottkommando() {
		name = "PluenderaSchrottkommando";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/PluenderaSchrottkommando.gif"));
		
		
        for(int i=0;i<4;i++){
        pluenderaz.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORPluenderaSchrottkommandoKammerPluenderaz", "Pikk-Up",1));
        pluenderaz.get(i).initKammer();
        add(pluenderaz.get(i));
        pluenderaz.get(i).setButtonText("Pikk-Up");
        }
        pluenderaz.get(3).setAktiv(false);
        
        seperator(20);
		
        beutepanza.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORPluenderaSchrottkommandoKammerBeutepanza", "Beutepanza",0));
        beutepanza.get(0).initKammer();
        add(beutepanza.get(0));
        beutepanza.get(0).setButtonText("Beutepanza");
        
    	complete();

	}

	public void refreshen() {
		adjustOptions(pluenderaz,3,"ORPluenderaSchrottkommandoKammerPluenderaz", "Pikk-Up",0,1);
		pluenderaz.get(0).setLegal(pluenderaz.get(0).isSelected());
		pluenderaz.get(1).setLegal(pluenderaz.get(1).isSelected());
		pluenderaz.get(2).setLegal(pluenderaz.get(2).isSelected());
		pluenderaz.get(3).setAktiv(pluenderaz.get(3).isSelected() && pluenderaz.get(1).isSelected() && pluenderaz.get(0).isSelected());
		pluenderaz.get(0).setAktiv(true);
		pluenderaz.get(1).setAktiv(true);
		pluenderaz.get(2).setAktiv(true);
		
		adjustOptions(beutepanza,0,"ORPluenderaSchrottkommandoKammerBeutepanza", "Beutepanza",pluenderaz.size(),0);
		
		
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
