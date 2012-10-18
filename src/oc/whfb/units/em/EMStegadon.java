package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.Eintrag;

public class EMStegadon extends Eintrag {

	public EMStegadon() {
		name = BuildaHQ.translate("Stegadon");
		grundkosten = 235;

		add(ico = new oc.Picture("oc/whfb/images/EMStegadon.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
