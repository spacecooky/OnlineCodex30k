package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;

public class ZWOrgelkanone extends Eintrag {

	public ZWOrgelkanone() {
		name = BuildaHQ.translate("Orgelkanone");
		grundkosten = 120;

		add(ico = new oc.Picture("oc/whfb/images/ZWOrgelkanone.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
