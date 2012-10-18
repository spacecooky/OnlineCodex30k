package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.Eintrag;

public class HETiranocStreitwagen extends Eintrag {

	public HETiranocStreitwagen() {
		name = BuildaHQ.translate("Tiranoc-Streitwagen");
		grundkosten = 85;

		add(ico = new oc.Picture("oc/whfb/images/HETiranocStreitwagen.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
