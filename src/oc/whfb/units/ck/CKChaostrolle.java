package oc.whfb.units.ck;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class CKChaostrolle extends Eintrag {

	AnzahlPanel squad;
	
	public CKChaostrolle() {
		name = BuildaHQ.translate("Chaostrolle");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Chaostrolle"), 3, 100, 45);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/CKChaostrolle.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
