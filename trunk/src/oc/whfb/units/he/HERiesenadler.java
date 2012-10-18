package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.Eintrag;

public class HERiesenadler extends Eintrag {

	public HERiesenadler() {
		name = BuildaHQ.translate("Riesenadler");
		grundkosten = 50;

		add(ico = new oc.Picture("oc/whfb/images/HERiesenadler.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
