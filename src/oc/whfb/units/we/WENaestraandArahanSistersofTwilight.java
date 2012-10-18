package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class WENaestraandArahanSistersofTwilight extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	OptionsUpgradeGruppe o1;
	
	public WENaestraandArahanSistersofTwilight() {
		name = BuildaHQ.translate("Naestra and Arahan - Sisters of Twilight");
		grundkosten = 275;

		add(ico = new oc.Picture("oc/images/WENaestraandArahanSistersofTwilight.jpg"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gwindalor"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ceithin-Har"), 320));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
}
