package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DGLegionMalcadorAssaultTank extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3, o4, o5;

	public DGLegionMalcadorAssaultTank() {
		name = "Legion Malcador Assault Tank";
		grundkosten = 300;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Battle cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Demolisher cannon", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber sponsons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter sponsons", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer sponsons", 10));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon sponsons", 20));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon sponsons", 30));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
		ogE.addElement(new OptionsGruppeEintrag("Flare shield", 25));
		ogE.addElement(new OptionsGruppeEintrag("Command tank", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Legion Crew", 15));
		ogE.addElement(new OptionsGruppeEintrag("Chem-Munitions", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
		if (!o3.isSelected()) o3.setSelected(0, true);
		
		o4.setAktiv(5, o3.isSelected(2) || o5.isSelected(2) || o5.isSelected(5));
	}

}
