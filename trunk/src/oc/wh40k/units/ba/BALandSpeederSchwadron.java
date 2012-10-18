package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BALandSpeederSchwadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter p1;
	RuestkammerStarter p2;
	RuestkammerStarter p3;

	public BALandSpeederSchwadron() {
		name = "Land Speeder Schwadron";
		grundkosten = 0;
		überschriftSetzen = true;

		//add(ico = new oc.Picture("oc/wh40k/images/BALandSpeederSchwadron.jpg"));
		add(ico = new oc.Picture("oc/wh40k/images/BATyphoonLandSpeeder.jpg"));

		seperator();

		p1 = new RuestkammerStarter(ID, randAbstand, cnt, "BALandSpeederKammer", "Land Speeder");
		p1.initKammer();
		add(p1);

		p2 = new RuestkammerStarter(ID, randAbstand, cnt, "BALandSpeederKammer", "Land Speeder");
		p2.initKammer();
		add(p2);

		p3 = new RuestkammerStarter(ID, randAbstand, cnt, "BALandSpeederKammer", "Land Speeder");
		p3.initKammer();
		add(p3);

		complete();

	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
