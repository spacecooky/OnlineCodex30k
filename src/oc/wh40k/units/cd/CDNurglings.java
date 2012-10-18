package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class CDNurglings extends Eintrag {

	AnzahlPanel Nurglings;

	public CDNurglings() {

		name = "Nurglings";

		grundkosten = 0;



		Nurglings = new AnzahlPanel(ID, randAbstand, cnt, "Nurglings", 3, 9, 13);

		add(Nurglings);





		add(ico = new oc.Picture("oc/wh40k/images/CDNurglings.gif"));

		seperator();







		complete();

	}

	@Override
	public void refreshen() {
	}
}
