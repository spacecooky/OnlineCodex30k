package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;

public class NECanoptekAcanthrites extends Eintrag {

	AnzahlPanel squad;

	public NECanoptekAcanthrites() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Acanthrites", 3, 9, 45);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NECanoptekAcanthrites.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
