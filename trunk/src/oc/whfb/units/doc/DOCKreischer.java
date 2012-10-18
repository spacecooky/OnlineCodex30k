package oc.whfb.units.doc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class DOCKreischer extends Eintrag {

	AnzahlPanel squad;
	
	public DOCKreischer() {
		name = BuildaHQ.translate("Kreischer");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Kreischer"), 3, 6, 30);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		complete();
	}

	@Override
	public void refreshen() {	
	}
}
