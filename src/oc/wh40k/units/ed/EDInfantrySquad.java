package oc.wh40k.units.ed;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class EDInfantrySquad extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkTransport;

	public EDInfantrySquad() {
		grundkosten = 60;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 5));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox-caster", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Demolition charge", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Guardsman with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Guardsman with Plasma gun", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade to Sergeant", 0));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Lasgun with Auxiliary grenade launcher", 3));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta-bombs", 5));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Lasgun with Auxiliary grenade launcher", 3));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie Airborne Assault Carrier");
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
