package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDSeelenzermalmer extends Eintrag {

	OptionsEinzelUpgrade oe1;

	public CDSeelenzermalmer() {

		name = "Seelenzermalmer";

		grundkosten = 135;







		add(ico = new oc.Picture("oc/wh40k/images/CDSeelenzermalmer.gif"));

		seperator();





		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Erbrechen", 0));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auswurf", 25));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zunge", 25));





		complete();

	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);
	}
}
