package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;

public class BDCRiese extends Eintrag {

	public BDCRiese() {
		name = BuildaHQ.translate("Riese");
		grundkosten = 225;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() { }
}
