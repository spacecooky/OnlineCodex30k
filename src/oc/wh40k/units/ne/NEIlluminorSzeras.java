package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;

public class NEIlluminorSzeras extends Eintrag {
    
	public NEIlluminorSzeras() {
		name = "Illuminor Szeras";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/NEIlluminorSzeras.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
