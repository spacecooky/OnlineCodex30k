package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IGGeschuetzbatterie extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public IGGeschuetzbatterie() {
		name = "Gesch�tzbatterie";
		grundkosten = 0;
		this.�berschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGOrdnanceBattery.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Tarnnetze", 30));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGGeschuetzpanzer", "", 1);
		t1.initKammer();
		t1.setButtonText("Gesch�tzpanzer 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGGeschuetzpanzer", "", 1);
		t2.initKammer();
		t2.setButtonText("Gesch�tzpanzer 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGGeschuetzpanzer", "", 1);
		t3.initKammer();
		t3.setButtonText("Gesch�tzpanzer 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

		oe1.setPreis(tanks * 30);
		oe1.setAktiv(tanks > 0);
	}

}
