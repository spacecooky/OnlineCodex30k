package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDHerrscherdesWandels extends Eintrag {

	public CDHerrscherdesWandels() {

		name = "Herrscher des Wandels";

		grundkosten = 250;

		add(ico = new oc.Picture("oc/wh40k/images/CDHerrscherdesWandels.gif"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ich bin Legion!", 40));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterzauberer", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Odem des Chaos", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wohltat der Mutation", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
