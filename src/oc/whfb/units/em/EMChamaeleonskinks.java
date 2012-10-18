package oc.whfb.units.em;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class EMChamaeleonskinks extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	
	public EMChamaeleonskinks() {
		name = BuildaHQ.translate("Chamäleonskinks");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Chamäleonskinks"), 5, 10, 12);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/EMChamaeleonskinks.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 6));


		complete();
	}

	@Override
	public void refreshen() {
	}
}
