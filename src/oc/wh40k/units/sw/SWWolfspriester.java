package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SWWolfspriester extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public SWWolfspriester() {
		name = "Wolfspriester";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWWolfspriester.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Saga des Bestientöters", 10));
		ogE.addElement(new OptionsGruppeEintrag("Saga des Jägers", "Saga des Jägers", 10));
		ogE.addElement(new OptionsGruppeEintrag("Saga des Wolfes", 15));
		ogE.addElement(new OptionsGruppeEintrag("Saga des geb. Kriegers", "Saga des geborenen Kriegers", 35));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runenrüstung", 20));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Wolfszahnkette", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Wolfsschwanz Talisman", 5));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setAktiv(!oe2.isSelected());
		o1.setAktiv(!oe2.isSelected());
		o2.setAktiv(!oe2.isSelected());

		o4.setAktiv("Saga des Jägers", (!o2.isSelected() && !oe2.isSelected()));

		o3.setAktiv(oe2.isSelected());
		if(oe2.isSelected() && !o3.isSelected()) o3.setSelected(0, true);

		// If this is the only HQ, count it as 1 (otherwise 0.5)
		if( BuildaHQ.getCountFromInformationVector("SWHQ") == 1 ) {
				setEintragsCNT(1);
		} else {
				setEintragsCNT(0.5);
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SWHQ", -1);
	}

}
