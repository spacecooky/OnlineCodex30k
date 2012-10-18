package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IGCommandSquad extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o22;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	OptionsZaehlerGruppe o6;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsEinzelZaehler oe6;
	OptionsEinzelZaehler oe7;
	OptionsEinzelZaehler oe8;
	OptionsEinzelUpgrade commissar;
	RuestkammerStarter rkTransport;

	boolean chenkovSelected = false;
	boolean alrahemSelected = false;

	public IGCommandSquad() {
		grundkosten = 30;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGCommandSquad.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Platoon Commander", 0));
		ogE.addElement(new OptionsGruppeEintrag("Commander Chenkov", 50));
		ogE.addElement(new OptionsGruppeEintrag("Captain Al'Rahem", 70));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

		seperator();

		add(commissar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o22 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		cnt = randAbstand;

		add(oe1 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Guard w/ Medi-pack", "Guardsman with Medi-pack", 1, 30));
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Guard w/ Standard", "Guardsman with Platoon standard", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Guard w/ Vox-caster", "Guardsman with Vox-caster", 1, 5));
		add(oe4 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Guard w/ Heavy flamer", "Guardsman with Heavy flamer", 1, 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar team", "Guardsmen Weapons Team with Mortar", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", "Guardsmen Weapons Team with Autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", "Guardsmen Weapons Team with Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", "Guardsmen Weapons Team with Missile launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laser cannon team", "Guardsmen Weapons Team with Laser Cannon", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Sniper rifle", "Guardsman with Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Meltagun", "Guardsman with Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Guard w/ Plasma gun", "Guardsman with Plasma gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 4));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laser pistol", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "option", ogE, 4));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Krak grenades", 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand + 280, cnt, "IGChimera", "Chimera Transport");
		rkTransport.initKammer(true);
		add(rkTransport);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);
		o2.setAktiv(o1.isSelected("Platoon Commander"));

		o22.setAktiv(commissar.isSelected());

		o3.setMaxAnzahl( oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() <= 2 ? 1 : 0 );

		int selectedVeterans = oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() + (o3.isSelected() ? 2 : 0);
		o4.setMaxAnzahl( 4 - selectedVeterans );

		o5.setMaxAnzahl( 4 - oe4.getAnzahl() - o4.getAnzahl() );

		// Unique entry: Commander Chenkov
		boolean chenkovGlobal = ( BuildaHQ.getCountFromInformationVector("IGChenkov") > 0 ? true : false );
		if(chenkovGlobal && !chenkovSelected) o1.setAktiv("Commander Chenkov", false);
		else o1.setAktiv("Commander Chenkov", true);

		if(o1.isSelected("Commander Chenkov")) {
			chenkovSelected = true;
			//BuildaHQ.addToInformationVector("IGChenkov", 1);
			BuildaHQ.setInformationVectorValue("IGChenkov", 1);
		} else {
			if(chenkovSelected) {
				chenkovSelected = false;
				BuildaHQ.setInformationVectorValue("IGChenkov", 0);
			}
		}

		// Unique entry: Captain Al'Rahem
		boolean alrahemGlobal = ( BuildaHQ.getCountFromInformationVector("IGAlRahem") > 0 ? true : false );
		if(alrahemGlobal && !alrahemSelected) o1.setAktiv("Captain Al'Rahem", false);
		else o1.setAktiv("Captain Al'Rahem", true);

		if(o1.isSelected("Captain Al'Rahem")) {
			alrahemSelected = true;
			//BuildaHQ.addToInformationVector("IGAlRahem", 1);
			BuildaHQ.setInformationVectorValue("IGAlRahem", 1);
		} else {
			if(alrahemSelected) {
				alrahemSelected = false;
				BuildaHQ.setInformationVectorValue("IGAlRahem", 0);
			}
		}
	}

	@Override
	public Object getSpecialValue() {
		return o1.isSelected("Commander Chenkov");
	}

}
