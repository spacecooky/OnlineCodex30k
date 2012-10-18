package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMLandSpeederStorm extends Eintrag {

	OptionsUpgradeGruppe o1;

	public SMLandSpeederStorm() {
		name = "Land Speeder Storm";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandSpeederStorm.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected("Schwerer Bolter", true);

		complete();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected("Schwerer Bolter", true);
		}
	}

}
