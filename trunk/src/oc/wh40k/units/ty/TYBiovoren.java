package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TYBiovoren extends Eintrag {

	AnzahlPanel squad;

	public TYBiovoren() {
		name = "Biovoren";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Biovore", "Biovoren", 1, 3, 45);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYBiovoren.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
