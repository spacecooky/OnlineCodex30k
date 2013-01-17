package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DGPraetorServoKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6, o7, o8;
	OptionsUpgradeGruppe termi, termiFK, termiNK;
	
	public DGPraetorServoKammer() {
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
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Archaeotech pistol", 20));
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
		ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
		ogE.addElement(new OptionsGruppeEintrag("Deathshroud power scythe", 20));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Paragon blade", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Digital lasers", 15));
		ogE.addElement(new OptionsGruppeEintrag("Master-crafted weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Chem-Munitions", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
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
		
		o4.setAktiv(3, o1.isSelected(1) && !o3.isSelected());
		
			
	}



}
