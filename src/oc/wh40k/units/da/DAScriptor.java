package oc.wh40k.units.da;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DAScriptor extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade o3;
	OptionsUpgradeGruppe big;
	OptionsUpgradeGruppe t;

	public DAScriptor() {
		name = "Scriptor";
		grundkosten = 120;

		add(ico = new oc.Picture("oc/wh40k/images/DALibrarian.gif"));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasmapistole", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 20));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 30));
		ogE.addElement(new OptionsGruppeEintrag("Terminatorrüstung", 25));
		add(big = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", "Kombi-Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", "Kombi-Plasmawerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		add(t = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		boolean termi = big.isSelected("Terminatorrüstung");
		
		o1.setAktiv(!termi);
		o2.setAktiv(!termi);
		o3.setAktiv(!termi);
		t.setAktiv(termi);
	}

}
