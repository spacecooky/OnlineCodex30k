package oc.wh40k.units.sm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SMVanguardSarge extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public SMVanguardSarge() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		o2.setSelected(0, true);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        if(!o2.isSelected()) o2.setSelected(0, true);
	}

}
