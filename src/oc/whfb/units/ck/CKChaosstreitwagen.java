package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CKChaosstreitwagen extends Eintrag {
	
	public CKChaosstreitwagen() {
		name = BuildaHQ.translate("Chaosstreitwagen");
		grundkosten = 120;

		add(ico = new oc.Picture("oc/whfb/images/CKChaosstreitwagen.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Khorne"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
