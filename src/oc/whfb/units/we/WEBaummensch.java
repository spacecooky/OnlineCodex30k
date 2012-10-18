package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;

public class WEBaummensch extends Eintrag {

	public WEBaummensch() {
		name = BuildaHQ.translate("Baummensch");
		grundkosten = 285;

		add(ico = new oc.Picture("oc/whfb/images/WEBaummensch.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {		
	}
}
