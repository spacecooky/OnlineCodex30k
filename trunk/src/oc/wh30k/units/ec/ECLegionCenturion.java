package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECLegionCenturion extends Eintrag {

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
	OptionsEinzelUpgrade Chaplain;

	public ECLegionCenturion() {
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
		
		Waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ECWaffen", "");
		//Chaplain, Forge, Centurion, Champion, Librarian, Master, Moritat, Praetor, Primus, Siege, Vigilator
		Waffen.initKammer(o1.isSelected("Chaplain"), o1.isSelected("Forge lord"), !o1.isSelected(), o1.isSelected("Legion Champion"), o1.isSelected("Librarian"), o1.isSelected("Master of signal"), o1.isSelected("Moritat"), false, o1.isSelected("Primus medicae"), o1.isSelected("Siege breaker"), o1.isSelected("Vigilator"));
		Waffen.setButtonText(BuildaHQ.translate("Weapons"));
		add(Waffen);
		Waffen.setAbwaehlbar(false);
		
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


		complete();
	}

	@Override
	public void deleteYourself() {
		}

	@Override
	public void refreshen() {
		
		Waffen.getKammer().refreshen();
		
		termiNK.setAktiv(termi.isSelected() && !o7.isSelected());
		termiFK.setAktiv(termi.isSelected() && !o7.isSelected());
		o7.setAktiv(termi.isSelected());
		
		 if(termi.isSelected()) {
	        	Waffen.setAktiv(false);
	        	//termiWaffen.setAbwaehlbar(false);
	        	//termiWaffen.setAktiv(true);
	        } else {
	        	Waffen.setAktiv(true);
	        	//termiWaffen.setAbwaehlbar(false);
	        	//termiWaffen.setAktiv(false);
	        }
		
		if (!termiFK.isSelected()) {
			termiFK.setSelected(0, true);
			}
		if (!termiNK.isSelected()) {
			termiNK.setSelected(0, true);
			}
	}

}
