package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;

public class BDCGrinderlak extends Eintrag {

	boolean kb_set = false;
	
	public BDCGrinderlak() {
		name = BuildaHQ.translate("Grinderlak");
		grundkosten = 275;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() { }
}
