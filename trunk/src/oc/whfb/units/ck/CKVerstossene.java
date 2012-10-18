package oc.whfb.units.ck;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class CKVerstossene extends Eintrag {

	AnzahlPanel squad;
	
	public CKVerstossene() {
		name = BuildaHQ.translate("Verstoﬂene");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Verstoﬂene"), 5, 100, 18);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/CKVerstossene.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
