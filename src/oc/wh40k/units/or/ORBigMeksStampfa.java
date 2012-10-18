package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORBigMeksStampfa extends Eintrag {

	public ORBigMeksStampfa() {
		name = "Big Meks Stampfa";
		grundkosten = 650;


		add(ico = new oc.Picture("oc/wh40k/images/BigMeksStampfa.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
