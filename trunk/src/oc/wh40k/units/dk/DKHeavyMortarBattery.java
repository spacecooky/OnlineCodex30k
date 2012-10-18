package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKHeavyMortarBattery extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;

	public DKHeavyMortarBattery() {
		name = "Heavy Mortar Battery";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyMortar", "Heavy Mortar", 1);
		t1.initKammer();
		t1.setButtonText("Heavy Mortar");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyMortar", "Heavy Mortar", 1);
		t2.initKammer();
		t2.setButtonText("Heavy Mortar");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyMortar", "Heavy Mortar", 1);
		t3.initKammer();
		t3.setButtonText("Heavy Mortar");
		add(t3);

		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyMortar", "Heavy Mortar", 1);
		t4.initKammer();
		t4.setButtonText("Heavy Mortar");
		add(t4);

		complete();
	}

	@Override
	public void refreshen() {
        t1.setAbwaehlbar(false);

        t2.setAktiv(t1.isSelected());
        t3.setAktiv(t2.isSelected());
        t4.setAktiv(t3.isSelected());

        t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
        t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
        t4.getPanel().setLocation(t4.getPanel().getX(), t3.getPanel().getY() + t3.getPanel().getHeight() + 10);
	}

}
