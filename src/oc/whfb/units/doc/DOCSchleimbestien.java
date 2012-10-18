package oc.whfb.units.doc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class DOCSchleimbestien extends Eintrag {

	AnzahlPanel squad;
	
	public DOCSchleimbestien() {
		name = BuildaHQ.translate("Schleimbestien");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schleimbestien"), 1, 100, 100);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
