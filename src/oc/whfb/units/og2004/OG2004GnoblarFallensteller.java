package oc.whfb.units.og2004;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class OG2004GnoblarFallensteller extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	
	public OG2004GnoblarFallensteller() {
		name = BuildaHQ.translate("Gnoblar-Fallensteller");
		grundkosten = 0;

		BuildaHQ.addToInformationVector("OGFallensteller", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gnoblar-Fallensteller"), 8, 100, 6);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/OGGnoblarFallensteller.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 4));

		complete();
	}

	@Override
	public void refreshen() {
		int maxSelection = 1 + BuildaHQ.getCountFromInformationVector("OGJaeger");
		if(BuildaHQ.getCountFromInformationVector("OGFallensteller") > maxSelection) {
			setFehlermeldung("0-" + maxSelection + " " + BuildaHQ.translate("Auswahl"));
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("OGFallensteller", -1);
		super.deleteYourself();
	}
}
