package oc.wh40k.units.sm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SMTrike extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public SMTrike() {
		grundkosten = 40;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) {
			o1.setSelected(0, true);
		}
	}

}
