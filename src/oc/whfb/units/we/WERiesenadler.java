package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;

public class WERiesenadler extends Eintrag {

	public WERiesenadler() {
		name = BuildaHQ.translate("Riesenadler");
		grundkosten = 50;

		add(ico = new oc.Picture("oc/whfb/images/WERiesenadler.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
