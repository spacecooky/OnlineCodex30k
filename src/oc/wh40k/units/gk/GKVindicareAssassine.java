package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKVindicareAssassine extends Eintrag {

	public GKVindicareAssassine() {
		name = "Vindicare-Assassine";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/GKVindicareAssassine.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
