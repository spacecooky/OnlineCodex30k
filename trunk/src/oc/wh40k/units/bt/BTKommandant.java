package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class BTKommandant extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkWargear;

	public BTKommandant() {
		name = "Kommandant";
		überschriftSetzen = true; // Sonst wird der Name nur als Option angezeigt

		BuildaHQ.addToInformationVector("BTHQ", 1);
		BuildaHQ.addToInformationVector("BTKommandant", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BTKommandant.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Kastellan", 65));
		ogE.addElement(new OptionsGruppeEintrag("Feldmarschall", 80));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		rkWargear = new RuestkammerStarter(ID, randAbstand, cnt, "BTArmoury", "");
		rkWargear.initKammer(true, false, false);
		rkWargear.setButtonText("Ausrüstung");
		add(rkWargear);

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("BTHQ", -1);
		BuildaHQ.addToInformationVector("BTKommandant", -1);
		super.deleteYourself();
	}

}
