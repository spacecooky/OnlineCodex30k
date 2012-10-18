package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IGKommandotruppderKompanie extends Eintrag {

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
	RuestkammerStarter rkAquila;

	boolean creedSelected = false;
	boolean strakenSelected = false;
	boolean kellSelected = false;
	boolean deddogSelected = false;

	public IGKommandotruppderKompanie() {
		name = "Kommandotrupp der Kompanie";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kompaniekommandeur", 0));
		ogE.addElement(new OptionsGruppeEintrag("Grosskastellan Creed", 90));
		ogE.addElement(new OptionsGruppeEintrag("Oberst Eisenfaust Straken", 95));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 2));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		
		add(oe = new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melterbomben", 5));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Sanitätsausrüstung", "Veteran mit Sanitätsausrüstung", 1, 30));
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Regimentsstandarte", "Veteran mit Regimentsstandarte", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Funkgerät", "Veteran mit Funkgerät", 1, 5));
		add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Schwerer Flamer", "Veteran mit schwerem Flammenwerfer", 1, 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mörser-Team", "Veteranen Waffenteam mit Mörser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanonen-Team", "Veteranen-Waffenteam mit Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer-Bolter-Team", "Veteranen-Waffenteam mit schwerem Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer-Team", "Veteranen-Waffenteam mit Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen-Team", "Veteranen-Waffenteam mit Laserkanone", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", "Veteran mit Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", "Veteran mit Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", "Veteran mit Scharfschützengewehr", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", "Veteran mit Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", "Veteran mit Plasmawerfer", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

		seperator();

		add(u1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bannersergeant Kell", 85));

		seperator();

		add(oe5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Astropath", 1, 30));
		add(oe6 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Artillerieoffizier", 1, 30));
		add(oe7 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Flottenoffizier", 1, 30));
		add(oe8 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Leibwächter", 2, 15));

		seperator();

		add(u2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nork Deddog", 110));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sprenggranaten", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Plattenrüstung", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Tarnmäntel", 20));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		rkAquila= new RuestkammerStarter(ID, randAbstand, cnt, "IGAquilaLanderKammer", "[IA Aeronautica] Aquila");
		rkAquila.initKammer(true);
		add(rkAquila);

		complete();
	}

	@Override
	public void refreshen() {
		
		rkTransport.setAktiv(!rkAquila.isSelected());
		  rkAquila.setAktiv(!rkTransport.isSelected());
		  
		if(!o1.isSelected()) o1.setSelected(0,true);
		o2.setAktiv(o1.isSelected("Kompaniekommandeur"));
		oe.setAktiv(o1.isSelected("Kompaniekommandeur"));
		
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
		if(creedGlobal && !creedSelected) o1.setAktiv("Grosskastellan Creed", false);
		else o1.setAktiv("Grosskastellan Creed", true);

		if(o1.isSelected("Grosskastellan Creed")) {
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
		if(strakenGlobal && !strakenSelected) o1.setAktiv("Oberst Eisenfaust Straken", false);
		else o1.setAktiv("Oberst Eisenfaust Straken", true);

		if(o1.isSelected("Oberst Eisenfaust Straken")) {
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

    public void deleteYourself() {
        super.deleteYourself();
        if(o1.isSelected("Grosskastellan Creed")) BuildaHQ.setInformationVectorValue("IGCreed", 0);
        if(o1.isSelected("Oberst Eisenfaust Straken")) BuildaHQ.setInformationVectorValue("IGStraken", 0);
        if(u1.isSelected()) BuildaHQ.setInformationVectorValue("IGKell", 0);
        if(u2.isSelected()) BuildaHQ.setInformationVectorValue("IGNorkDeddog", 0);
    }

}
