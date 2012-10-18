package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TLMaelstromFleetLighters extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public TLMaelstromFleetLighters() {
		name = "Maelstrom Fleet Lighters";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/TLMaelstromFleetLighters.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "TLArvusLighter", "Arvus Lighter\n", 1);
		t1.initKammer();
		t1.setButtonText("Arvus Lighter 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "TLArvusLighter", "Arvus Lighter\n", 1);
		t2.initKammer();
		t2.setButtonText("Arvus Lighter 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "TLArvusLighter", "Arvus Lighter\n", 1);
		t3.initKammer();
		t3.setButtonText("Arvus Lighter 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
