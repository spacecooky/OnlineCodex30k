package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKCallidusAssassine extends Eintrag {

	public GKCallidusAssassine() {
		name = "Callidus-Assassine";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/GKCallidusAssassine.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
