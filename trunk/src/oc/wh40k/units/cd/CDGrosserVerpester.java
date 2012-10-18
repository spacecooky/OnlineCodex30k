package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDGrosserVerpester extends Eintrag {

	public CDGrosserVerpester() {

		name = "Groﬂer Verpester";

		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/CDGrosserVerpester.gif"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegenwolke", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aura des Verfalls", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Odem des Chaos", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Unheilige St‰rke", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
