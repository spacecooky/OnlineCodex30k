package oc.wh40k.units.sf;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class SFPredatorTankSquadron extends Eintrag {

	RuestkammerStarter tank1;
	RuestkammerStarter tank2;
	RuestkammerStarter tank3;

	public SFPredatorTankSquadron() {
		name = "Predator Tank Squadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/SFPredator.jpg"));

		tank1 = new RuestkammerStarter(ID, randAbstand, cnt, "SFPredatorKammer", "Predator");
		tank1.initKammer();
		add(tank1);
		tank1.setAbwaehlbar(false);
                
                seperator();

		tank2 = new RuestkammerStarter(ID, randAbstand, cnt, "SFPredatorKammer", "Predator");
		tank2.initKammer();
		add(tank2);
                
                seperator();

		tank3 = new RuestkammerStarter(ID, randAbstand, cnt, "SFPredatorKammer", "Predator");
		tank3.initKammer();
		add(tank3);
                
                seperator();
                
		complete();
	}

	@Override
	public void refreshen() {
            tank2.setAktiv(tank1.isSelected());
            tank3.setAktiv(tank2.isSelected());
            
            updatePosition(tank2, tank1, 10);
            updatePosition(tank3, tank2, 10); 
	}

}
