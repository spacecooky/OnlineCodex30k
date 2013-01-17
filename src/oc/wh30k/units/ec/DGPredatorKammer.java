package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DGPredatorKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4;

	public DGPredatorKammer () {
            grundkosten = 75;
	}

	public void initButtons(boolean... defaults) {


		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Predator cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Executioner plasma destroyer", 35));
		ogE.addElement(new OptionsGruppeEintrag("Heavy conversion beamer", 40));
		ogE.addElement(new OptionsGruppeEintrag("Magna-melta cannon", 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter sponsons", 25));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer sponsons", 25));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon sponsons", 50));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));	
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
		ogE.addElement(new OptionsGruppeEintrag("Machine spirit", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));	
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		seperator();
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
			if (!o1.isSelected()) o1.setSelected(0, true);
			
		
	}
        
}