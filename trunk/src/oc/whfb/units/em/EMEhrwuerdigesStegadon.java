package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.Eintrag;

public class EMEhrwuerdigesStegadon extends Eintrag {

	public EMEhrwuerdigesStegadon() {
		name = BuildaHQ.translate("Ehrwürdiges Stegadon");
		grundkosten = 275;

		add(ico = new oc.Picture("oc/whfb/images/EMEhrwuerdigesStegadon.jpg"));

		complete();
	}

	@Override
	public void refreshen() {	
	}
}
