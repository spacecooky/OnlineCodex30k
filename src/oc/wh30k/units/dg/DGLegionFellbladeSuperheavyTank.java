package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DGLegionFellbladeSuperheavyTank extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3, o4;

	public DGLegionFellbladeSuperheavyTank() {
		name = "Legion Fellblade Super-heavy Tank";
		grundkosten = 525;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Quad lascannon sponsons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laser destroyer sponsons", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", "Twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", "Twin-linked heavy flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 20));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 25));
		ogE.addElement(new OptionsGruppeEintrag("Command tank", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Legion Crew", 15));
		ogE.addElement(new OptionsGruppeEintrag("Chem-Munitions", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
		
		o3.setAktiv(4, o2.isSelected(1) || o4.isSelected(1) || o4.isSelected(4));
	}

}
