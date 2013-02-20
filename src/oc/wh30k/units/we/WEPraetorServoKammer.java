package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class WEPraetorServoKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o2a, o2b, o3, o4, o5, o6, o7, o8;
	OptionsUpgradeGruppe termi, termiFK, termiNK;
	
	public WEPraetorServoKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
				
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainsaxe", 0));
		add(o2a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2a.setSelected(0, true);
		
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
		add(o2b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2b.setSelected(0, true);
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Archaeotech pistol", 20));
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Barb-hook lash", 15));
		ogE.addElement(new OptionsGruppeEintrag("Excoriator chainaxe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Meteor hammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Twin Falax blades", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
		ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Paragon blade", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Digital lasers", 15));
		ogE.addElement(new OptionsGruppeEintrag("Master-crafted weapon", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
		ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
		ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
		ogE.addElement(new OptionsGruppeEintrag("Iron halo", 25));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
		ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o2.setAktiv(!o2a.isSelected() || !o2b.isSelected());
		o3.setAktiv(!o2a.isSelected() && !o2b.isSelected());
		
		boolean legal =((o2a.isSelected() && o2b.isSelected()) || (o2a.isSelected() && o2.isSelected()) || (o2b.isSelected() && o2.isSelected()) || o3.isSelected());
		
		o2a.setLegal(legal);
		o2b.setLegal(legal);
		o2.setLegal(legal);
		o3.setLegal(legal);
		
			
	}



}
