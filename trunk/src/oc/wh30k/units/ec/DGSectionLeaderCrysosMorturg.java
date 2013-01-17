package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;

public class DGSectionLeaderCrysosMorturg extends Eintrag {

	public DGSectionLeaderCrysosMorturg() {
		name = "Section Leader Crysos Morturg";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
