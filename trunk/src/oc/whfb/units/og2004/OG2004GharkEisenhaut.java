package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;

public class OG2004GharkEisenhaut extends Eintrag {

	public OG2004GharkEisenhaut() {
		name = "Ghark Eisenhaut";
		grundkosten = 485;

		add(ico = new oc.Picture("oc/whfb/images/OGSpeckusGoldzahn.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
