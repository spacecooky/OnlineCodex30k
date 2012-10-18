package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORPulsaraketaenStartrampae extends Eintrag {

	public ORPulsaraketaenStartrampae() {
		name = "Pulsaraket�n-Startramp�";
		grundkosten = 200;


		add(ico = new oc.Picture("oc/wh40k/images/Pulsaraket�nStartramp�.gif"));
		


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "MEGA", "Mega-Pulsaraket�n-Startramp�", 50));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotpilot", 30));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kraftfeld", "Kraftfeldstabilisator", 75));

		complete();

	}

	public void refreshen() {
	}
}
