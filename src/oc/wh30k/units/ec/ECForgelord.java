package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ECForgelord extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o3b;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsZaehlerGruppe o8;
	OptionsUpgradeGruppe termi;
	OptionsUpgradeGruppe termiFK;
	OptionsUpgradeGruppe termiNK;

	public ECForgelord() {
		name = "Forge lord";
		grundkosten = 85;

		//BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
	    //ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
		//ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		//ogE.addElement(new OptionsGruppeEintrag("Combat blade", 0));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
		ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
		ogE.addElement(new OptionsGruppeEintrag("Master-crafted bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));;
		add(o3b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", 35));
		ogE.addElement(new OptionsGruppeEintrag("Rad grenades", 10));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Cyber familiar", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
		ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
		ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
		ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servo-atuomata", 12));
		ogE.addElement(new OptionsGruppeEintrag("with lascutter", 17));
		ogE.addElement(new OptionsGruppeEintrag("with power fist", 27));
		ogE.addElement(new OptionsGruppeEintrag("with flamer", 17));
		ogE.addElement(new OptionsGruppeEintrag("with rotor cannon", 22));
		add(o8 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", 35));
		add(termi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 7));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
		add(termiFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 10));
		ogE.addElement(new OptionsGruppeEintrag("Chain fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
		add(termiNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 20));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));


		complete();
	}

	/*@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("SMEnableCommandSquad", -1);
		super.deleteYourself();
	}*/

	@Override
	public void refreshen() {
				
		o1.setAktiv(!termi.isSelected());
		o2.setAktiv(!termi.isSelected() && !o3.isSelected());
		o3.setAktiv(!termi.isSelected());
		o5.setAktiv(!termi.isSelected());
		o6.setAktiv(!termi.isSelected());
		
		termiNK.setAktiv(termi.isSelected() && !o7.isSelected());
		termiFK.setAktiv(termi.isSelected() && !o7.isSelected());
		o7.setAktiv(termi.isSelected());
		
		if (!termiFK.isSelected()) {
			termiFK.setSelected(0, true);
			}
		if (!termiNK.isSelected()) {
			termiNK.setSelected(0, true);
			}
	}

}