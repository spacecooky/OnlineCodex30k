package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007GiantChaosSpawn extends Eintrag {

	public CM2007GiantChaosSpawn() {
		name = "Giant Chaos Spawn";
		grundkosten = 120;

		add(ico = new oc.Picture("oc/wh40k/images/GiantChaosSpawn.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
