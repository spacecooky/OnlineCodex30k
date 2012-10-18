package oc.whfb.units.og2004;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class OG2004Yhetis extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	boolean set = false;

	public OG2004Yhetis() {
		name = BuildaHQ.translate("Yhetis");
		grundkosten = 0;

		BuildaHQ.addToInformationVector("OGYhetis", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Yhetis"), 3, 100, 65);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/OGYhetis.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("OGYhetis", -1);
	}

}
