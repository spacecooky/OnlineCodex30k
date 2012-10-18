package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDHueterderGeheimnisse extends Eintrag {

	public CDHueterderGeheimnisse() {

		name = "H�ter der Geheimnisse";

		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/CDHueterderGeheimnisse.gif"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "L�hmender Blick", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Einlullender Duft", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Pavane des Slaanesh", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "D�monenblick", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Unheilige St�rke", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
