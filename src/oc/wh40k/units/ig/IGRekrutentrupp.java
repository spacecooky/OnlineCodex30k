package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerVater;

public class IGRekrutentrupp extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
    OptionsEinzelZaehler oez;

	public IGRekrutentrupp() {
		grundkosten = 0;
	}

    @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGConscriptsSquad.jpg"));
		

        add(oez = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Rekruten", 50, 4));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\"Schickt die nächste Welle!\"", 75));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(oez.getAnzahl() < 20) {
            oez.setAnzahl(20);
        }
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(name.equals("CHENKOV")) oe1.setAktiv(aktiv);
	}

}
