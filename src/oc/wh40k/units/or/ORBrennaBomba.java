package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class ORBrennaBomba extends Eintrag {

	public ORBrennaBomba() {
		name = "Brenna-Bomba";
		grundkosten = 125;


		add(ico = new oc.Picture("oc/wh40k/images/BrennaBomma.gif"));
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt,"", "Brenn-Raketen",6,10));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "Rotä Farbä",5));
		
		complete();

	}

	public void refreshen() {
	}
}
