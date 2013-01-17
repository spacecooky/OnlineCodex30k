package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;

public class DGMarshallDurakRask extends Eintrag {

	public DGMarshallDurakRask() {
		name = "Marshall Durak Rask";
		grundkosten = 165;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
