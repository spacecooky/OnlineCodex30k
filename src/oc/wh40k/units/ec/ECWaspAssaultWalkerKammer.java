package oc.wh40k.units.ec;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECWaspAssaultWalkerKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	boolean added = false;

	public ECWaspAssaultWalkerKammer() {
		grundkosten = 55;
	}

    @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scatter Laser", 15));
		ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 20));
		ogE.addElement(new OptionsGruppeEintrag("Starcannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Bright Lance", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scatter Laser", 15));
		ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 20));
		ogE.addElement(new OptionsGruppeEintrag("Starcannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Bright Lance", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
        o2.alwaysSelected();
	}

}
