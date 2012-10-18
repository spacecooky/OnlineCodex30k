package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DESchattenklinge extends Eintrag {

	public DESchattenklinge() {
		name = BuildaHQ.translate("Schattenklinge");
		grundkosten = 300;

		add(ico = new oc.Picture("oc/whfb/images/DESchattenklinge.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
