package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKCulexusAssassine extends Eintrag {

	public GKCulexusAssassine() {
		name = "Culexus-Assassine";
		grundkosten = 135;

		add(ico = new oc.Picture("oc/wh40k/images/GKCulexusAssassine.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
