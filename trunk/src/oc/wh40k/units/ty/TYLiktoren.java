package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TYLiktoren extends Eintrag {

	AnzahlPanel squad;

	public TYLiktoren() {
		name = "Liktoren";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Liktor", "Liktoren", 1, 3, 65);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYLiktor.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
