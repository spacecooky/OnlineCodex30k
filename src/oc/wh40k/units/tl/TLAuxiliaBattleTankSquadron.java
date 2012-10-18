package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class TLAuxiliaBattleTankSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public TLAuxiliaBattleTankSquadron() {
		name = "Auxilia Battle Tank Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 20));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "TLLemanRuss", "", 1);
		t1.initKammer();
		t1.setButtonText("Battle Tank 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "TLLemanRuss", "", 1);
		t2.initKammer();
		t2.setButtonText("Battle Tank 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "TLLemanRuss", "", 1);
		t3.initKammer();
		t3.setButtonText("Battle Tank 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

		oe1.setPreis(tanks * 20);
		oe1.setAktiv(tanks > 0);

	}

}
