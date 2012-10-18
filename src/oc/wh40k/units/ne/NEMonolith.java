package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;

public class NEMonolith extends Eintrag {
    
	public NEMonolith() {
		name = "Monolith";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/NEMonolith.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
