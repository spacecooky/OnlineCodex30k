package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORGoblinKamakazekatapult extends Eintrag {

	public ORGoblinKamakazekatapult() {
		name = "Goblin-Kamakazekatapult";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/whfb/images/ORGoblinKamakazekatapult.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
