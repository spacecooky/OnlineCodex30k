package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DGSergeant extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4, o7a, o7b, o7c;
	OptionsZaehlerGruppe o5;
	
	boolean isVeteran = false;
	boolean isDestroyer = false;
	boolean isTerminator = false;

	public DGSergeant() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		if(defaults[0]) isVeteran = true;
		if(defaults[1]) isDestroyer = true;
		if(defaults[2]) isTerminator = true;
		
		if(isVeteran) {ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));}
		
		if (!isTerminator) {
			seperator();
		
			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
			ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
			ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			}
		else {
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Power weapon"), 0));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", 5));
			ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 5));
			ogE.addElement(new OptionsGruppeEintrag("Chain fist", 10));
			ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 10));
			add(o7a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 7));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
			add(o7b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 15));
			add(o7c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}

		if (isVeteran) {
			seperator();
		
			ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			}
		
		seperator();
		
		if (!isTerminator) ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
		if (isTerminator) ogE.addElement(new OptionsGruppeEintrag("Grenade harness", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		if (isDestroyer) {
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Phosphex bomb", 10));
			add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
			}
		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (isTerminator) {
			if (!o7a.isSelected());
			o7a.setSelected(0, true);
			if (!o7b.isSelected());
			o7b.setSelected(0, true);
			
			o7a.setAktiv(!o7c.isSelected());
			o7b.setAktiv(!o7c.isSelected());
		}
	
	}



}
