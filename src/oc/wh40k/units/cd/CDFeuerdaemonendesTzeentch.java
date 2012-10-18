package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDFeuerdaemonendesTzeentch extends Eintrag {

	public CDFeuerdaemonendesTzeentch() {

		name = "Feuerdämonen des Tzeentch";
		grundkosten = 0;

		add(new AnzahlPanel(ID, randAbstand, cnt, "Feuerdämonen des Tzeentch", 3, 9, 23));

		add(ico = new oc.Picture("oc/wh40k/images/CDFeuerdaemonendesTzeentch.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Feuerspeier", 5));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
