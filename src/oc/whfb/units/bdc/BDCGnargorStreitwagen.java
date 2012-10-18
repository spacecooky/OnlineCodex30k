package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;

public class BDCGnargorStreitwagen extends Eintrag {

	public BDCGnargorStreitwagen() {
		name = BuildaHQ.translate("Gnargor Streitwagen");
		grundkosten = 145;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() { }
	
}
