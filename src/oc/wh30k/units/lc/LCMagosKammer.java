package oc.wh30k.units.lc;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class LCMagosKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o1a, o2, o2a, o3, o3a, o4, o5;
	
	public LCMagosKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
				
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 1));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Archaeotech pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Photon gauntlet", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		ogE.addElement(new OptionsGruppeEintrag("Crafted laspistol", "Master crafted laspistol", 5));
		ogE.addElement(new OptionsGruppeEintrag("Crafted bolt pistol", "Master crafted bolt pistol", 6));
		ogE.addElement(new OptionsGruppeEintrag("Crafted Volkite Serpenta", "Master crafted Volkite Serpenta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Crafted archaeotech pistol", "Master crafted archaeotech pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Crafted photon gauntlet", "Master crafted photon gauntlet", 15));
		ogE.addElement(new OptionsGruppeEintrag("Crafted plasma pistol", "Master crafted plasma pistol", 15));
		add(o1a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Rotor cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Rad cleanser", 20));
		ogE.addElement(new OptionsGruppeEintrag("Photon thruster", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		ogE.addElement(new OptionsGruppeEintrag("Crafted rotor cannon", "Master crafted rotor cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Crafted meltagun", "Master crafted meltagun", 20));
		ogE.addElement(new OptionsGruppeEintrag("Crafted graviton gun", "Master crafted graviton gun", 20));
		ogE.addElement(new OptionsGruppeEintrag("Crafted rad cleanser", "Master crafted rad cleanser", 25));
		ogE.addElement(new OptionsGruppeEintrag("Crafted photon thruster", "Master crafted photon thruster", 35));
		add(o2a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Servo arm", 10));
		ogE.addElement(new OptionsGruppeEintrag("Machinator array", 25));
		ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", 35));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Crafted servo arm", "Master crafted servo arm", 15));
		ogE.addElement(new OptionsGruppeEintrag("Crafted machinator array", "Master crafted machinator array", 30));
		ogE.addElement(new OptionsGruppeEintrag("Crafted conversion beamer", "Master crafted conversion beamer", 40));
		add(o3a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
		ogE.addElement(new OptionsGruppeEintrag("Mechanicum Protectiva", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cyber-familiar", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Infravisor", 5));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Abeyant", 25));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		o1.setAktiv(!o1a.isSelected());
		o1a.setAktiv(!o2a.isSelected() && !o3a.isSelected());
		o2.setAktiv(!o2a.isSelected());
		o2a.setAktiv(!o1a.isSelected() && !o3a.isSelected());
		o3.setAktiv(!o3a.isSelected());
		o3a.setAktiv(!o1a.isSelected() && !o2a.isSelected());
		
		if(!o1.isSelected()) o1.setSelected(0, true);
		
		
			
	}



}
