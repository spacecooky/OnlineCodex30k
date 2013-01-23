package oc.wh30k.units.sh;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class SHApothecarionDetachment extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public SHApothecarionDetachment() {
		name = "Apothecarion Detachment";
		grundkosten = 0;
                überschriftSetzen = true;

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "SHApothecaryKammer", "", 1);
		t1.initKammer();
		t1.setButtonText("Apothecary");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "SHApothecaryKammer", "", 1);
		t2.initKammer();
		t2.setButtonText("Apothecary");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "SHApothecaryKammer", "", 1);
		t3.initKammer();
		t3.setButtonText("Apothecary");
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
