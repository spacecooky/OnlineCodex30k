package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;

public class BDCZygor extends Eintrag {

	public BDCZygor() {
		name = BuildaHQ.translate("Zygor");
		grundkosten = 275;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {}
}
