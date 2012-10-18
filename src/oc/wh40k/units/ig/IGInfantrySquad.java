package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IGInfantrySquad extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkTransport;

	public IGInfantrySquad() {
		grundkosten = 50;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 10));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Guard w/ Vox-caster", "Guardsman with Vox-caster", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Sniper rifle", "Guardsman with Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Meltagun", "Guardsman with Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Plasma gun", "Guardsman with Plasma gun", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar team", "Guardsmen Weapons Team with Mortar", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", "Guardsmen Weapons Team with Autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", "Guardsmen Weapons Team with Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", "Guardsmen Weapons Team with Missile launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laser cannon team", "Guardsmen Weapons Team with Laser Cannon", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade to Sergeant", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bolt pistol", 2));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimera", "Chimera Transport");
		rkTransport.initKammer(true);
		add(rkTransport);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		oe1.setSelected(true);
		o4.setAktiv(oe2.isSelected());
	}

}
