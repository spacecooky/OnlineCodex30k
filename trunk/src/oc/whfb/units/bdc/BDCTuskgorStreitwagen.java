package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;

public class BDCTuskgorStreitwagen extends Eintrag {
	
	public BDCTuskgorStreitwagen() {
		name = BuildaHQ.translate("Tuskgor Streitwagen");
		grundkosten = 80;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() { }
}
