package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class TABarracuda extends Eintrag {

	public TABarracuda() {
		name = "Barracuda";
		grundkosten = 220;

		add(ico = new oc.Picture("oc/wh40k/images/Barracuda.jpg"));
		

		seperator();

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Nachtsichtgerät", 1, 5));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Störsystem", 1, 5));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Ködersystem", 1, 5));
		
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Lenkraketen", 4, 10));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}

}
