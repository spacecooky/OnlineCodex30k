package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKBruderCaptainStern extends Eintrag {

	public GKBruderCaptainStern() {
		name = "Bruder-Captain Stern";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/GKBruderCaptainStern.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
