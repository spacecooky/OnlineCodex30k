package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORStampfa extends Eintrag {

	public ORStampfa() {
		name = "Stampfa";
		grundkosten = 600;


		add(ico = new oc.Picture("oc/wh40k/images/Stampfa.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
