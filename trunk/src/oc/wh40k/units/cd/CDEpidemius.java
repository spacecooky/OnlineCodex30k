package oc.wh40k.units.cd;

import oc.BuildaHQ;

public class CDEpidemius extends CDHerold {

	public CDEpidemius() {

		name = "Epidemius";

		grundkosten = 110;

		add(ico = new oc.Picture("oc/wh40k/images/CDEpidemius.gif"));
		
		complete();

	}

	@Override
	public void refreshen() {
            super.refreshen();
            setUnikat(true);
	}
}
