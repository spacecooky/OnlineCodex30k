package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DGLegionCenturion extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe termi;
	OptionsUpgradeGruppe termiFK;
	OptionsUpgradeGruppe termiNK;
	RuestkammerStarter Waffen;

	public DGLegionCenturion() {
		name = "Legion Centurion";
		grundkosten = 50;

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chaplain", 35));
		ogE.addElement(new OptionsGruppeEintrag("Forge lord", 35));
		ogE.addElement(new OptionsGruppeEintrag("Legion Champion", 35));
		ogE.addElement(new OptionsGruppeEintrag("Librarian", 25));
		ogE.addElement(new OptionsGruppeEintrag("Master of signal", 35));
		ogE.addElement(new OptionsGruppeEintrag("Moritat", 35));
		ogE.addElement(new OptionsGruppeEintrag("Primus medicae", 35));
		ogE.addElement(new OptionsGruppeEintrag("Siegebreaker", 45));
		ogE.addElement(new OptionsGruppeEintrag("Vigilator", 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		Waffen = new RuestkammerStarter(ID, randAbstand, cnt, "DGWaffen", "");
		//Chaplain, Forge, Centurion, Champion, Librarian, Master, Moritat, Praetor, Primus, Siege, Vigilator
		if (!o1.isSelected()){Waffen.initKammer(false, false, true, false, false, false, false, false, false, false, false);}
		else if (o1.isSelected(0)){Waffen.initKammer(true, false, false, false, false, false, false, false, false, false, false);}
		else if (o1.isSelected(1)){Waffen.initKammer(false, true, false, false, false, false, false, false, false, false, false);}
		else if (o1.isSelected(2)){Waffen.initKammer(false, false, false, true, false, false, false, false, false, false, false);}
		else if (o1.isSelected(3)){Waffen.initKammer(false, false, false, false, true, false, false, false, false, false, false);}
		else if (o1.isSelected(4)){Waffen.initKammer(false, false, false, false, false, true, false, false, false, false, false);}
		else if (o1.isSelected(5)){Waffen.initKammer(false, false, false, false, false, false, true, false, false, false, false);}
		else if (o1.isSelected(6)){Waffen.initKammer(false, false, false, false, false, false, false, false, true, false, false);}
		else if (o1.isSelected(7)){Waffen.initKammer(false, false, false, false, false, false, false, false, false, true, false);}
		else if (o1.isSelected(8)){Waffen.initKammer(false, false, false, false, false, false, false, false, false, false, true);}
		Waffen.setButtonText(BuildaHQ.translate("Weapons"));
		add(Waffen);
		Waffen.setAbwaehlbar(false);
		
		/*seperator();
		
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

		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
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
*/

		complete();
	}

	@Override
	public void deleteYourself() {
		}

	@Override
	public void refreshen() {
				
	/*	o1.setAktiv(!termi.isSelected());
		o2.setAktiv(!termi.isSelected() && !o3.isSelected());
		o3.setAktiv(!termi.isSelected());
		o4.setAktiv(!termi.isSelected());
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
			}*/
	}

}
