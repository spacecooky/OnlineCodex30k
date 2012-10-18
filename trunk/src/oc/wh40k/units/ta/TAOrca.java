package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;

public class TAOrca extends Eintrag {

	public TAOrca() {
		name = "Orca";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/Orca.jpg"));
		

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}

}
