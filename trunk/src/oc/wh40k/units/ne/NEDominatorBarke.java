package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;

public class NEDominatorBarke extends Eintrag {
    
	public NEDominatorBarke() {
		name = "Dominator-Barke";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/NEDominatorBarke.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
