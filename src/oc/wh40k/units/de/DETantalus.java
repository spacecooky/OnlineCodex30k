package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DETantalus extends Eintrag {

	public DETantalus() {
		name = "Tantalus";
		grundkosten = 215;

		add(ico = new oc.Picture("oc/wh40k/images/DETantalus.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Schocksporn", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Terrorgas-Granatwerfer", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Bremstriebwerke", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Grausige Trophäen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
