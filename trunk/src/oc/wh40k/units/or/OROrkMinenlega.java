package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class OROrkMinenlega extends Eintrag {


	public OROrkMinenlega() {

		name = "Ork-Minenlega";
		grundkosten = 250;

		add(ico = new oc.Picture("oc/wh40k/images/OrkMinenlega.gif"));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzerkanonä", 60));

		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Fette Wumme",3, 5));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
