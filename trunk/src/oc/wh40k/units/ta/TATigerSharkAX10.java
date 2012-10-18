package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TATigerSharkAX10 extends Eintrag {

	public TATigerSharkAX10() {
		name = "Tiger Shark AX-1-0";
		grundkosten = 660;

		add(ico = new oc.Picture("oc/wh40k/images/TigerSharkAX10.jpg"));
		

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nachtsichtgerät", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Störsystem", 20));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lenkraketen", "sechs Lenkraketen", 60));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}

}
