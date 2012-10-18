package oc.wh40k.units.cd;

import oc.BuildaHQ;

public class CDDieBlauenGelehrten extends CDHerold {

	public CDDieBlauenGelehrten() {

		name = "Die Blauen Gelehrten";

		grundkosten = 130;

		this.setEintragsCNT(0.5);

		add(ico = new oc.Picture("oc/wh40k/images/CDDieBlauenGelehrten.gif"));
		
		complete();

	}

	@Override
	public void refreshen() {
            super.refreshen();
            setUnikat(true);
	}
}
