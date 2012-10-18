package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class NEKanoptechSkarabaeen extends Eintrag {

	AnzahlPanel squad;

	public NEKanoptechSkarabaeen() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Kanoptech-Skarabäen", 3, 10, 15);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechSkarabaeen.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
