package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEEchsenstreitwagen extends Eintrag {

	public DEEchsenstreitwagen() {
		name = BuildaHQ.translate("Echsenstreitwagen");
		grundkosten = 100;

		add(ico = new oc.Picture("oc/whfb/images/DEEchsenstreitwagen.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
