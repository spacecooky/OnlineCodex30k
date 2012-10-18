package oc.whfb.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class DERepetierSpeerschleuder extends Eintrag {

	AnzahlPanel squad;
	
	public DERepetierSpeerschleuder() {
		name = BuildaHQ.translate("Repetier-Speerschleuder");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Repetier-Speerschleuder"), BuildaHQ.translate("Repetier-Speerschleudern"), 1, 2, 100);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/DERepetierSpeerschleuder.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {	
	}
}
