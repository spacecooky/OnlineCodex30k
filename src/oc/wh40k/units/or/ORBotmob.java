package oc.wh40k.units.or;

import java.util.Vector;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORBotmob extends Eintrag {

	 
	AnzahlPanel Stampfas;//0+
    Vector<RuestkammerStarter> gargbots = new Vector<RuestkammerStarter>();//0+
    Vector<RuestkammerStarter> killabots = new Vector<RuestkammerStarter>();//0+

	public ORBotmob() {
		name = "Botmob\n";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/Heizakult.gif"));
		
		
		Stampfas = new AnzahlPanel(ID, randAbstand, cnt, "Stampfa", "Stampfas", 0, 2147483647, 600);
		add(Stampfas);
		
		seperator();
		
        gargbots.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORBotmobKammerGargbot", "Gargbot"));
        gargbots.get(0).initKammer();
        add(gargbots.get(0));
        gargbots.get(0).setButtonText("Gargbot");
        
        seperator(20);
		
        killabots.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORBotmobKammerKillabot", "Killabots"));
       	killabots.get(0).initKammer();
        add(killabots.get(0));
        killabots.get(0).setButtonText("Killabots");
        
    	complete();

	}

	public void refreshen() {
		
		adjustOptions(gargbots,0,"ORBotmobKammerGargbot", "Gargbot",1,0);
		
		adjustOptions(killabots,0,"ORBotmobKammerKillabot", "Killabots",1+gargbots.size(),0);
		
		Stampfas.setLegal((Stampfas.getModelle() + gargbots.size()-1 + killabots.size()-1)>3);
		
		for(int i=0;i<gargbots.size();i++){
			gargbots.get(i).setLegal((Stampfas.getModelle() + gargbots.size()-1 + killabots.size()-1)>3);
		}
		
		for(int i=0;i<killabots.size();i++){
			killabots.get(i).setLegal((Stampfas.getModelle() + gargbots.size()-1 + killabots.size()-1)>3);
		}
		
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
