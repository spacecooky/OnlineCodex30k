package oc.wh40k.units.tl;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TLOrdenschampion extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public TLOrdenschampion() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitallaser", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) {
			o1.setSelected(0, true);
		}
	}

}
