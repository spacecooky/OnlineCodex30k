package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IGKommandotrupp extends RuestkammerVater {

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
    OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade commissar;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkAquila;

	boolean chenkovSelected = false;
	boolean alrahemSelected = false;

	public IGKommandotrupp() {
		grundkosten = 30;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGCommandSquad.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Zugkommandeur", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kommandant Chenkov", 50));
		ogE.addElement(new OptionsGruppeEintrag("Hauptmann Al'Rahem", 70));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 2));
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		seperator();

		add(commissar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kommissar", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		add(o22 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		cnt = randAbstand;

		add(oe1 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Sanitätsausrüstung", "Soldat mit Sanitätsausrüstung", 1, 30));
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Zugstandarte", "Soldat mit Zugstandarte", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Funkgerät", "Soldat mit Funkgerät", 1, 5));
		add(oe4 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Schwerer Flamer", "Soldat mit Schwerem Flammenwerfer", 1, 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mörser Team", "Waffenteam mit Mörser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanonen Team", "Waffenteam mit Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter Team", "Waffenteam mit schwerem Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer Team", "Waffenteam mit Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen Team", "Waffenteam mit Laserkanone", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", "Soldat mit Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", "Soldat mit Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", "Soldat mit Scharfschützengewehr", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", "Soldat mit Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", "Soldat mit Plasmawerfer", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 4));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "option", ogE, 4));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Sprenggranaten", 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand + 280, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		rkAquila= new RuestkammerStarter(ID, randAbstand + 280, cnt, "IGAquilaLanderKammer", "[IA Aeronautica] Aquila");
		rkAquila.initKammer(true);
		add(rkAquila);
		
		sizeSetzen();
	}

  @Override
	public void refreshen() {
	  
	  rkTransport.setAktiv(!rkAquila.isSelected());
	  rkAquila.setAktiv(!rkTransport.isSelected());
	  
		if(!o1.isSelected()) o1.setSelected(0,true);
		o2.setAktiv(o1.isSelected("Zugkommandeur"));
		mb.setAktiv(o1.isSelected("Zugkommandeur"));

		o22.setAktiv(commissar.isSelected());

		o3.setMaxAnzahl( oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() <= 2 ? 1 : 0 );

		int selectedVeterans = oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() + (o3.isSelected() ? 2 : 0);
		o4.setMaxAnzahl( 4 - selectedVeterans );

		o5.setMaxAnzahl( 4 - oe4.getAnzahl() - o4.getAnzahl() );

		// Unique entry: Commander Chenkov
		boolean chenkovGlobal = ( BuildaHQ.getCountFromInformationVector("IGChenkov") > 0 ? true : false );
		if(chenkovGlobal && !chenkovSelected) o1.setAktiv("Kommandant Chenkov", false);
		else o1.setAktiv("Kommandant Chenkov", true);

		if(o1.isSelected("Kommandant Chenkov")) {
			chenkovSelected = true;
			BuildaHQ.setInformationVectorValue("IGChenkov", 1);
		} else {
			if(chenkovSelected) {
				chenkovSelected = false;
				BuildaHQ.setInformationVectorValue("IGChenkov", 0);
			}
		}

		// Unique entry: Captain Al'Rahem
		boolean alrahemGlobal = ( BuildaHQ.getCountFromInformationVector("IGAlRahem") > 0 ? true : false );
		if(alrahemGlobal && !alrahemSelected) o1.setAktiv("Hauptmann Al'Rahem", false);
		else o1.setAktiv("Hauptmann Al'Rahem", true);

		if(o1.isSelected("Hauptmann Al'Rahem")) {
			alrahemSelected = true;
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
		return o1.isSelected("Kommandant Chenkov");
	}

    public void deleteYourself() {
        super.deleteYourself();
        if(o1.isSelected("Kommandant Chenkov")) BuildaHQ.setInformationVectorValue("IGChenkov", 0);
        if(o1.isSelected("Hauptmann Al'Rahem")) BuildaHQ.setInformationVectorValue("IGAlRahem", 0);
    }

}
