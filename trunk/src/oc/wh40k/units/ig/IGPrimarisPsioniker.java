package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;

public class IGPrimarisPsioniker extends Eintrag {

	public IGPrimarisPsioniker() {
		name = "Primaris-Psioniker";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/IGPrimarisPsyker.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
