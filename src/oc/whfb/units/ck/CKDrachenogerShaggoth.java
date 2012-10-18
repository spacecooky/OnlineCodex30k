package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CKDrachenogerShaggoth extends Eintrag {

	public CKDrachenogerShaggoth() {
		name = BuildaHQ.translate("Drachenoger-Shaggoth");
		grundkosten = 265;

		add(ico = new oc.Picture("oc/whfb/images/CKDrachenogerShaggoth.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zusätzliche Handwaffe"), 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffe"), 20));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
