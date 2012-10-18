package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;

public class ZWFlammenkanone extends Eintrag {

	public ZWFlammenkanone() {
		name = BuildaHQ.translate("Flammenkanone");
		grundkosten = 140;

		add(ico = new oc.Picture("oc/whfb/images/ZWFlammenkanone.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
