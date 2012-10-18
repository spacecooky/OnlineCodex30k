package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class IGConscriptsSquad extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;

	public IGConscriptsSquad() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Conscripts", 20, 50, 4);
//		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGConscriptsSquad.jpg"));
		

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\"Send in the Next Wave!\"", 75));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(name.equals("CHENKOV")) oe1.setAktiv(aktiv);
	}

}
