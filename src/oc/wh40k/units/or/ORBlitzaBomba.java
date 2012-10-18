package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORBlitzaBomba extends Eintrag {

	public ORBlitzaBomba() {
		name = "Blitza-Bomba";
		grundkosten = 135;
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "Rotä Farbä",5));
		
		complete();

	}

	public void refreshen() {
	}
}
