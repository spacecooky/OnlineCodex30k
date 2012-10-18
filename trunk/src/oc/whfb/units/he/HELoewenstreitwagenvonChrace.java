package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.Eintrag;

public class HELoewenstreitwagenvonChrace extends Eintrag {

	public HELoewenstreitwagenvonChrace() {
		name = BuildaHQ.translate("Löwenstreitwagen von Chrace");
		grundkosten = 140;

		add(ico = new oc.Picture("oc/whfb/images/HELoewenstreitwagenvonChrace.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
