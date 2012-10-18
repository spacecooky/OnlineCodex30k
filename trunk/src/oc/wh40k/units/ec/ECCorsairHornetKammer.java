package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECCorsairHornetKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	boolean added = false;

	public ECCorsairHornetKammer() {
		grundkosten = 65;
	}

    @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scatter Laser", 10));
		ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Starcannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Bright Lance", 25));
		ogE.addElement(new OptionsGruppeEintrag("Pulse Laser", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scatter Laser", 10));
		ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Starcannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Bright Lance", 25));
		ogE.addElement(new OptionsGruppeEintrag("Pulse Laser", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit Stones", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored Engines", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Holo-field", 35));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
        o2.alwaysSelected();
	}

}
