package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SWFenriswolfsrudel extends Eintrag {

	AnzahlPanel squad;

	public SWFenriswolfsrudel() {
		name = "Fenriswolfsrudel\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Fenriswölfe", 5, 15, 8);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWFenriswolfsrudel.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade zum Cyberwolf", 8));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
