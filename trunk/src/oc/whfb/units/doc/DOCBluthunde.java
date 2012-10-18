package oc.whfb.units.doc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DOCBluthunde extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;

	public DOCBluthunde() {
		name = BuildaHQ.translate("Bluthunde");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Bluthunde"), 5, 100, 35);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Karanak"), 75));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
