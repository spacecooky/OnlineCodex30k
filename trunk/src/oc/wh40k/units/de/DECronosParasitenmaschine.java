package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DECronosParasitenmaschine extends Eintrag {

	public DECronosParasitenmaschine() {
		name = "Cronos-Parasitenmaschine";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/DECronosParasitenmaschine.jpg"));

		seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Seelensonde", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Seelenstrudel", 20));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
