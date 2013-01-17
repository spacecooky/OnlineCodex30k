package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DGPraetorKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6, o7, o8;
	OptionsUpgradeGruppe termi, termiFK, termiNK;
	
	public DGPraetorKammer() {
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
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", 35));
		add(termi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 7));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
		add(termiFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 10));
		ogE.addElement(new OptionsGruppeEintrag("Chain fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Paragon blade", 20));
		add(termiNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 20));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Digital lasers", 15));
		ogE.addElement(new OptionsGruppeEintrag("Iron halo", 10));
		ogE.addElement(new OptionsGruppeEintrag("Master-crafted weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Grenade harness", 10));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 4));

		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		o1.setAktiv(!termi.isSelected());
		o2.setAktiv(!termi.isSelected() && !o3.isSelected());
		o3.setAktiv(!termi.isSelected());
		o4.setAktiv(!termi.isSelected());
		o5.setAktiv(!termi.isSelected());
		o6.setAktiv(!termi.isSelected());
		
		termiNK.setAktiv(termi.isSelected() && !o7.isSelected());
		termiFK.setAktiv(termi.isSelected() && !o7.isSelected());
		o7.setAktiv(termi.isSelected());
		o8.setAktiv(termi.isSelected());
		
		if (!termiFK.isSelected()) {
			termiFK.setSelected(0, true);
			}
		if (!termiNK.isSelected()) {
			termiNK.setSelected(0, true);
			}
			
	}



}
