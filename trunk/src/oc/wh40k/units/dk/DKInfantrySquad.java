package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
//import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class DKInfantrySquad extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o2x;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
//	RuestkammerStarter rkTransport;

	public DKInfantrySquad() {
		grundkosten = 60;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 10));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox-caster", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Platoon Standard", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Guardsman with Lasgun", 0));
		add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", "Guardsman with Laspistol", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Guardsman with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Guardsman with Plasma gun", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Watchmaster", 0));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta-bombs", 5));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
//
//		seperator();
//
//		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
//		rkTransport.initKammer();
//		add(rkTransport);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		oe1.setSelected(true);
		o4.setAktiv(oe2.isSelected());
        
        o2.setMaxAnzahl(9 - o1.getAnzahl());
        o2x.setMaxAnzahl(9 - o1.getAnzahl());
        o2x.setAnzahl(0, 9 - o1.getAnzahl() - o2.getAnzahl());
	}

}
