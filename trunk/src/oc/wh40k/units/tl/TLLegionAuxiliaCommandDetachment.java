package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLLegionAuxiliaCommandDetachment extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	RuestkammerStarter rkTransport;

	boolean chenkovSelected = false;
	boolean alrahemSelected = false;

	public TLLegionAuxiliaCommandDetachment() {
		name="Legion Auxilia Command Detachment";
		grundkosten = 45;
		überschriftSetzen = true;
	
		add(ico = new oc.Picture("oc/wh40k/images/TLLegionAuxiliaCommandDetachment.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Prefect Commander", 0));
		ogE.addElement(new OptionsGruppeEintrag("Tribune", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Meltagun", "Guardsman with Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Combat Shield", "Guardsman with Combat shield", 2));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", "Guardsmen Weapons Team with Heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", "Guardsmen Weapons Team with Autocannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer team", "Guardsmen Weapons Team with Heavy Flamer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", "Guardsmen Weapons Team with Missile launcher", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shotguns", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 20));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLChimera", "Chimera Transport");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	// @OVERRIDE
	public void refreshen() {

		o5.setMaxAnzahl( 4 - o4.getAnzahl() );
	}

}
