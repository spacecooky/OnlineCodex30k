package oc.wh30k.units.we;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class WEContemptorDreadnoughtTalon extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public WEContemptorDreadnoughtTalon() {
		name = "Contemptor Dreadnought Talon";
		grundkosten = 0;
                �berschriftSetzen = true;

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "WEContemptorKammer", "", 1);
		t1.initKammer();
		t1.setButtonText("Contemptor Dreadnought");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "WEContemptorKammer", "", 1);
		t2.initKammer();
		t2.setButtonText("Contemptor Dreadnought");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "WEContemptorKammer", "", 1);
		t3.initKammer();
		t3.setButtonText("Contemptor Dreadnought");
		add(t3);

		complete();
	}

	
	public void refreshen() {
            int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt();
            
            t1.setLegal(selections > 0);
            
            t1.setAktiv(t1.isSelected() || selections < 3);
            t2.setAktiv(t2.isSelected() || (t1.isSelected() && selections < 3));
            t3.setAktiv(t3.isSelected() || (t2.isSelected() && selections < 3));

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
            }

}