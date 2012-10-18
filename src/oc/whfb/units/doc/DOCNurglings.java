package oc.whfb.units.doc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DOCNurglings extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;

	public DOCNurglings() {
		name = BuildaHQ.translate("Nurglings");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Nurglings"), 3, 12, 35);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		complete();
	}

	@Override
	public void refreshen() {		
	}
}
