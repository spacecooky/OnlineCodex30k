package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007Kyborgkult extends Eintrag {

	AnzahlPanel squad;

	public CM2007Kyborgkult() {
		name = "Kyborgkult";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Kyborg", "Kyborgs", 1, 3, 75);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ObliteratorCult.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
