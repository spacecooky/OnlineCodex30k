package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class TLMaelstromFleetNavalDetachment extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public TLMaelstromFleetNavalDetachment() {
		name = "Maelstrom Fleet Naval Detachment";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/TLMaelstromFleetNavalDetachment.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "TLAssaultAircraft", "", 1);
		t1.initKammer();
		t1.setButtonText("Aircraft 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "TLAssaultAircraft", "", 1);
		t2.initKammer();
		t2.setButtonText("Aircraft 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "TLAssaultAircraft", "", 1);
		t3.initKammer();
		t3.setButtonText("Aircraft 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
