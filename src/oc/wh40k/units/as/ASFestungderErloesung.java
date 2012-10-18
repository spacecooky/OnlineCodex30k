package oc.wh40k.units.as;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class ASFestungderErloesung extends Eintrag {
	

	public ASFestungderErloesung() {
		name = "Festung der Erlösung";
		grundkosten = 220;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Festung.jpg"));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprengsturm-Raketen",30));
		
		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Schwere Bolter",4,10));

		complete();
	}

	@Override
	public void refreshen() {
	}
}