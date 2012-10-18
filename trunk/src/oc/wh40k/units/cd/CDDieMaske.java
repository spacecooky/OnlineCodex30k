package oc.wh40k.units.cd;

import oc.BuildaHQ;

public class CDDieMaske extends CDHerold {

		public CDDieMaske() {

		name = "Die Maske";

		grundkosten = 100;

		this.setEintragsCNT(0.5);

		add(ico = new oc.Picture("oc/wh40k/images/CDDieMaske.gif"));
		
		complete();

	}

	@Override
	public void refreshen() {
            super.refreshen();
            setUnikat(true);
	}
}
