package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TYMalanthrope extends Eintrag {

	AnzahlPanel squad;

	public TYMalanthrope() {
		name = "Malanthropen";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Malanthrope", "Malanthropen", 1, 3, 110);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYMalanthrope.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
