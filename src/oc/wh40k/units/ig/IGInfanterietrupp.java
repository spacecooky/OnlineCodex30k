package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IGInfanterietrupp extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkTransport;

	public IGInfanterietrupp() {
		grundkosten = 50;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprenggranaten", 10));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Soldat + Funkgerät", "Soldat mit Funkgerät", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", "Soldat mit Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", "Soldat mit Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", "Soldat mit Scharfschützengewehr", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", "Soldat mit Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", "Soldat mit Plasmawerfer", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mörser-Team", "Waffenteam mit Mörser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanonen-Team", "Waffenteam mit Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer-Bolter-Team", "Waffenteam mit schwerem Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer-Team", "Waffenteam mit Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen-Team", "Waffenteam mit Laserkanone", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade zum Sergeant", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Boltpistole", 2));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melterbomben", 5));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kommissar", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
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
