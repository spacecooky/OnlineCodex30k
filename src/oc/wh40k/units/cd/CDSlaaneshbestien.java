package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDSlaaneshbestien extends Eintrag {

	public CDSlaaneshbestien() {

		name = "Slaaneshbestien";
		grundkosten = 0;

		add(new AnzahlPanel(ID, randAbstand, cnt, "Slaaneshbestie", "Slaaneshbestien", 1, 6, 30));

		add(ico = new oc.Picture("oc/wh40k/images/CDSlaaneshbestien.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Unheilige Stärke", 10));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
