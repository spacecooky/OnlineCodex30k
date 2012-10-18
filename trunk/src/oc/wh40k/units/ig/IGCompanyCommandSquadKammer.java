package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IGCompanyCommandSquadKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	OptionsZaehlerGruppe o6;
	OptionsEinzelUpgrade oe;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsEinzelZaehler oe6;
	OptionsEinzelZaehler oe7;
	OptionsEinzelZaehler oe8;
	OptionsEinzelUpgrade u1;
	OptionsEinzelUpgrade u2;
	RuestkammerStarter rkTransport;

	boolean creedSelected = false;
	boolean strakenSelected = false;
	boolean kellSelected = false;
	boolean deddogSelected = false;

	public IGCompanyCommandSquadKammer() {
	}

	@Override
	public void initButtons(boolean... defaults) {
		name = "Company Command Squad";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Company Commander", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lord Castellan Creed", 90));
		ogE.addElement(new OptionsGruppeEintrag("Colonel Straken", 95));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

//		ogE.addElement(new OptionsGruppeEintrag("CC weapon", "Close combat weapon", 0));
//		ogE.addElement(new OptionsGruppeEintrag("Laser pistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
//		o2.setAnzahl(0, 1);
//		o2.setAnzahl(1, 1);

		add(oe = new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melta bombs", 5));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vet. w/ Medi-pack", "Veteran with Medi-pack", 1, 30));
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vet. w/ Standard", "Veteran with Regimental standard", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vet. w/ Vox-caster", "Veteran with Vox-caster", 1, 5));
		add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vet. w/ Heavy flamer", "Veteran with Heavy flamer", 1, 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar team", "Veteran Weapons Team with Mortar", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", "Veteran Weapons Team with Autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", "Veteran Weapons Team with Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", "Veteran Weapons Team with Missile launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laser cannon team", "Veteran Weapons Team with Laser Cannon", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

        cnt = randAbstand;

		ogE.addElement(new OptionsGruppeEintrag("Vet. w/ Flamer", "Veteran with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Vet. w/ Grenade launcher", "Veteran with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Vet. w/ Sniper rifle", "Veteran with Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Vet. w/ Meltagun", "Veteran with Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Vet. w/ Plasma gun", "Veteran with Plasma gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 4));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laser pistol", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "option", ogE, 4));

		seperator();

		add(u1 = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Color Sergeant Kell", 85));

		seperator();

		add(oe5 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Astropath", 1, 30));
		add(oe6 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Master of Ordnance", 1, 30));
		add(oe7 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Officer of the Fleet", 1, 30));
		add(oe8 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Bodyguard", 2, 15));

		seperator();

		add(u2 = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Nork Deddog", 110));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Krak grenades", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Carapace armour", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Camo cloaks", 20));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand + 280, cnt, "IGChimera", "Chimera Transport");
		rkTransport.initKammer(true);
		add(rkTransport);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);
		o2.setAktiv(o1.isSelected("Company Commander"));
		oe.setAktiv(o1.isSelected("Company Commander"));

		int selectedVeterans = oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() + (o3.isSelected() ? 2 : 0);
		u1.setAktiv( selectedVeterans + o4.getAnzahl() < 4 );
		o4.setMaxAnzahl( 4 - selectedVeterans - (u1.isSelected() ? 1 : 0) );

		oe2.setAktiv(!u1.isSelected());
		if(u1.isSelected()) oe2.setAnzahl(0);

		oe8.setAktiv(!u2.isSelected());
		u2.setAktiv(!oe8.isSelected());

		int kell = u1.isSelected() ? 1 : 0;
		o3.setMaxAnzahl( oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() + kell <= 2 ? 1 : 0 );
		o5.setMaxAnzahl( 4 - oe4.getAnzahl() - o4.getAnzahl() );

		// Unique entry: Lord Castellan Creed
		boolean creedGlobal = ( BuildaHQ.getCountFromInformationVector("IGCreed") > 0 ? true : false );
		if(creedGlobal && !creedSelected) o1.setAktiv("Lord Castellan Creed", false);
		else o1.setAktiv("Lord Castellan Creed", true);

		if(o1.isSelected("Lord Castellan Creed")) {
			creedSelected = true;
			BuildaHQ.addToInformationVector("IGCreed", 1);
		} else {
			if(creedSelected) {
				creedSelected = false;
				BuildaHQ.setInformationVectorValue("IGCreed", 0);
			}
		}

		// Unique entry: Colonel Straken
		boolean strakenGlobal = ( BuildaHQ.getCountFromInformationVector("IGStraken") > 0 ? true : false );
		if(strakenGlobal && !strakenSelected) o1.setAktiv("Colonel Straken", false);
		else o1.setAktiv("Colonel Straken", true);

		if(o1.isSelected("Colonel Straken")) {
			strakenSelected = true;
			BuildaHQ.addToInformationVector("IGStraken", 1);
		} else {
			if(strakenSelected) {
				strakenSelected = false;
				BuildaHQ.setInformationVectorValue("IGStraken", 0);
			}
		}

		// Unique entry: Color Sergeant Kell
		boolean kellGlobal = ( BuildaHQ.getCountFromInformationVector("IGKell") > 0 ? true : false );
		if(kellGlobal && !kellSelected) u1.setAktiv(false);
		else u1.setAktiv(true);

		if(u1.isSelected()) {
			kellSelected = true;
			BuildaHQ.addToInformationVector("IGKell", 1);
		} else {
			if(kellSelected) {
				kellSelected = false;
				BuildaHQ.setInformationVectorValue("IGKell", 0);
			}
		}

		// Unique entry: Nork Deddog
		boolean deddogGlobal = ( BuildaHQ.getCountFromInformationVector("IGNorkDeddog") > 0 ? true : false );
		if(deddogGlobal && !deddogSelected) u2.setAktiv(false);
		else u2.setAktiv(true);

		if(u2.isSelected()) {
			deddogSelected = true;
			BuildaHQ.addToInformationVector("IGNorkDeddog", 1);
		} else {
			if(deddogSelected) {
				deddogSelected = false;
				BuildaHQ.setInformationVectorValue("IGNorkDeddog", 0);
			}
		}
	}

}
