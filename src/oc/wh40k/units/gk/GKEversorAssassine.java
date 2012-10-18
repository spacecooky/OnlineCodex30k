package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKEversorAssassine extends Eintrag {

	public GKEversorAssassine() {
		name = "Eversor-Assassine";
		grundkosten = 130;

		add(ico = new oc.Picture("oc/wh40k/images/GKEversorAssassine.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
