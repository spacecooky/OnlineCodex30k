package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ECVigilator extends Eintrag {

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

	public ECVigilator() {
		name = "Vigilator";
		grundkosten = 95;

		//BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
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
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Scout armour", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
		ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		

		complete();
	}

	/*@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("SMEnableCommandSquad", -1);
		super.deleteYourself();
	}*/

	@Override
	public void refreshen() {
				
		
	}

}
