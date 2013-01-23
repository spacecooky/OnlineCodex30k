package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class SHConsulServoKammer extends RuestkammerVater {

	OptionsUpgradeGruppe 	o1a, o1b, o1c, o1d, o1e, o1f,
							o2a, o2b, o2c, o2d, o2e, o2f,
							o3a, o3b, o3c, o3d, o3e, o3f,
							o4a, o4b, o4c, o4d, o4f,
							o5a, o5b, o5c, o5d, o5e, o5f; 
	OptionsZaehlerGruppe 	o4z;
	
	boolean isCenturion = false;
	boolean isChampion = false;
	boolean isChaplain = false;
	boolean isForge = false;
	boolean isLibrarian = false;
	boolean isMaster = false;
	boolean isMoritat = false;
	boolean isPrimus = false;
	boolean isSiege = false;
	boolean isVigilator = false;

	public SHConsulServoKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		if(defaults[0]) isCenturion = true;
		if(defaults[1]) isChampion = true;
		if(defaults[2]) isChaplain = true;
		if(defaults[3]) isForge = true;
		if(defaults[4]) isLibrarian = true;
		if(defaults[5]) isMaster = true;
		if(defaults[6]) isMoritat = true;
		if(defaults[7]) isPrimus = true;
		if(defaults[8]) isSiege = true;
		if(defaults[9]) isVigilator = true;
				
		if (isCenturion || isChampion || isChaplain || isPrimus || isSiege) {
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o1a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
			ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
			ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
			ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));			
			ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
			add(o1b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
			add(o1c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
			ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
			ogE.addElement(new OptionsGruppeEintrag("Sonic Shrieker", 5));
			add(o1d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
					
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
			ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
			ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
			add(o1e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
			ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
			ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
			add(o1f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}
				
		else if (isForge) {
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o2a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
			ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
			ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
			ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
			
			ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
			add(o2b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
			add(o2c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
			ogE.addElement(new OptionsGruppeEintrag("Sonic Shrieker", 5));
			add(o2d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
					
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
			ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
			ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
			add(o2e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
			ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
			ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
			add(o2f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}
		
		else if (isLibrarian) {
			
			seperator();			
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o3a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();			
			ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
			ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
			ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
			ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));			
			ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
			add(o3b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
			ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
			ogE.addElement(new OptionsGruppeEintrag("Sonic Shrieker", 5));
			add(o3c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
					
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
			ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
			ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
			add(o3d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
			ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
			ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
			add(o3e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}
		
		else if (isMaster || isMoritat) {
			
			seperator();			
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o4a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();			
			ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
			ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
			ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
			add(o4b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
						
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
			ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
			ogE.addElement(new OptionsGruppeEintrag("Sonic Shrieker", 5));
			add(o4c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
					
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
			ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
			add(o4d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
			add(o4f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}
				
		else if (isVigilator) {
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o5a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
			ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
			ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
			add(o5b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
			ogE.addElement(new OptionsGruppeEintrag("Sonic Shrieker", 5));
			add(o5c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
			ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
			ogE.addElement(new OptionsGruppeEintrag("Scout armour", 0));
			add(o5d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
					
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
			ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
			add(o5e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
			add(o5f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}
		
		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (isCenturion || isChampion || isChaplain || isPrimus || isSiege) {
			o1a.setAktiv(!o1c.isSelected());
			o1b.setAktiv(!o1c.isSelected());
			}	
		
		else if (isForge) {
			o2a.setAktiv(!o2c.isSelected());
			o2b.setAktiv(!o2c.isSelected());
			}
		
		
		
	}



}
