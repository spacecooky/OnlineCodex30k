package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SWEinsamerWolf extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;

	public SWEinsamerWolf() {
		name = "Einsamer Wolf";
		grundkosten = 20;

		add(ico = new oc.Picture("oc/wh40k/images/SWEinsamerWolf.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Wolfsklaue", 20));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Frostklinge", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 25));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Wolfsklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 25));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Wolfsklaue", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
		ogE.addElement(new OptionsGruppeEintrag("Frostklinge", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 15));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mal des Wulfen", 15));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Fenriswolf", 10));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(!oe1.isSelected());
		o2.setAktiv(oe1.isSelected());
		o3.setAktiv(oe1.isSelected());

		if(oe1.isSelected() && !o2.isSelected()) o2.setSelected(0, true);
		if(oe1.isSelected() && !o3.isSelected()) o3.setSelected(0, true);
	}

}
