package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;

public class ZWGyrokopter extends Eintrag {

	public ZWGyrokopter() {
		name = BuildaHQ.translate("Gyrokopter");
		grundkosten = 140;

		add(ico = new oc.Picture("oc/whfb/images/ZWGyrokopter.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
