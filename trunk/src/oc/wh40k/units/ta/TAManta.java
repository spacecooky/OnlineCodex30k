package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;

public class TAManta extends Eintrag {

	public TAManta() {
		name = "Manta";
		grundkosten = 2000;

		add(ico = new oc.Picture("oc/wh40k/images/Manta.jpg"));
		

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}

}
