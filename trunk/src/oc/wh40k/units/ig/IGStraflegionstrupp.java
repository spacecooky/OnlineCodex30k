package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;

public class IGStraflegionstrupp extends Eintrag {

	public IGStraflegionstrupp() {
		name = "Straflegionstrupp";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/IGPenalLegionSquad.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
