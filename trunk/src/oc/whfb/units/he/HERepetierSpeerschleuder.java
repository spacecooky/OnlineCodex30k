package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.Eintrag;

public class HERepetierSpeerschleuder extends Eintrag {

	public HERepetierSpeerschleuder() {
		name = BuildaHQ.translate("Repetier-Speerschleuder");
		grundkosten = 100;

		add(ico = new oc.Picture("oc/whfb/images/HERepetierSpeerschleuder.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
