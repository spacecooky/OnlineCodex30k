package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;

public class BDCGhorgor extends Eintrag {

	public BDCGhorgor() {
		name = BuildaHQ.translate("Ghorgor");
		grundkosten = 275;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
