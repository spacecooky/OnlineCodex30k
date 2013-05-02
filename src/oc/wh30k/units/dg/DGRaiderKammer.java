package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DGRaiderKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4, o5;

	public DGRaiderKammer () {
            grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {


		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Phobos", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Proteus", 200));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Achilles", 300));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
		ogE.addElement(new OptionsGruppeEintrag("Frag assault launchers", 10));
		ogE.addElement(new OptionsGruppeEintrag("Explorator Augury Web", 50));
		ogE.addElement(new OptionsGruppeEintrag("Chem-Munitions", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 7));	
						
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy flamer", 20));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
			if (!o1.isSelected()) o1.setSelected(0, true);
			
			o2.setAktiv(5, o1.isSelected(0));
			o2.setAktiv(6, o1.isSelected(1));
			o2.setAktiv(7, o4.isSelected(1) || o4.isSelected(4) || o5.isSelected(1));
			o5.setAktiv(o1.isSelected(1));
		
	}
        
}