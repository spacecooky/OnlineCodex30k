package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;

public class OG2004Verschlinger extends Eintrag {

	public OG2004Verschlinger() {
		name = BuildaHQ.translate("Verschlinger");
		grundkosten = 75;

		add(ico = new oc.Picture("oc/whfb/images/OGVerschlinger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {	
	}
}
