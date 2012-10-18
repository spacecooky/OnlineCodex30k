package oc.whfb.units.doc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class DOCChaosgargoyle extends Eintrag {

	AnzahlPanel squad;
	
	public DOCChaosgargoyle() {
		name = BuildaHQ.translate("Chaosgargoyle");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Chaosgargoyle"), 5, 100, 12);
		squad.setGrundkosten(0);
		add(squad);
		
		setCountToMinimum(false); // Unit cannot resolve minimum number of core units

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
