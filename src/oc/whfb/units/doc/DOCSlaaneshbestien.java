package oc.whfb.units.doc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class DOCSlaaneshbestien extends Eintrag {

	AnzahlPanel squad;
	
	public DOCSlaaneshbestien() {
		name = BuildaHQ.translate("Slaaneshbestien");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Slaaneshbestien"), 1, 100, 55);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {	
	}
}
