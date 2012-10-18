package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IGVeteranentrupp extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	RuestkammerStarter rkTransport;

	boolean harkerSelected = false;
	boolean bastonneSelected = false;

	public IGVeteranentrupp() {
		name = "Veteranentrupp";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/IGVeteranSquad.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grenadiere", 30));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Plänkler", 30));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Pioniere", 30));

		seperator();

		add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Veteran + Funkgerät", "Veteran mit Funkgerät", 1, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mörser Team", "Veteranen Waffenteam mit Mörser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanonen Team", "Veteranen Waffenteam mit Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter Team", "Veteranen Waffenteam mit schwerem Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer Team", "Veteranen Waffenteam mit Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen Team", "Veteranen Waffenteam mit Laserkanone", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Veteran + Flammenwerfer", "Veteran mit Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Veteran + Granatwerfer", "Veteran mit Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Veteran + Scharfschützeng.", "Veteran mit Scharfschützengewehr", 5));
		ogE.addElement(new OptionsGruppeEintrag("Veteran + Melter", "Veteran mit Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Veteran + Plasmawerfer", "Veteran mit Plasmawerfer", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		add(oe5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Veteran + Schw. Flamer", "Veteran mit schwerem Flammenwerfer", 1, 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Veteranensergeant", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sergeant Steinzahn Harker", "Sergeant Steinzahn Harker", 55));
		ogE.addElement(new OptionsGruppeEintrag("Sergeant Bastonne", 60));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
		o2.setAktiv(o1.isSelected("Veteranensergeant"));
		o4.setMaxAnzahl(oe5.isSelected() ? 2 : 3);
		o5.setMaxAnzahl( 9 - (oe5.isSelected() ? 1 : 0) - o4.getAnzahl() );

		oe1.setAktiv(!o1.isSelected("Sergeant Steinzahn Harker"));
		oe5.setAktiv(o4.getAnzahl() < 3);

		// Unique entry: Gunnery Sergeant Harker
		boolean harkerGlobal = ( BuildaHQ.getCountFromInformationVector("IGHarker") > 0 ? true : false );
		if(harkerGlobal && !harkerSelected) o1.setAktiv("Sergeant Steinzahn Harker", false);
		else o1.setAktiv("Sergeant Steinzahn Harker", !oe1.isSelected());

		if(o1.isSelected("Sergeant Steinzahn Harker")) {
			harkerSelected = true;
			BuildaHQ.addToInformationVector("IGHarker", 1);
		} else {
			if(harkerSelected) {
				harkerSelected = false;
				BuildaHQ.setInformationVectorValue("IGHarker", 0);
			}
		}

		// Unique entry: Sergeant Bastonne
		boolean bastonneGlobal = ( BuildaHQ.getCountFromInformationVector("IGBastonne") > 0 ? true : false );
		if(bastonneGlobal && !bastonneSelected) o1.setAktiv("Sergeant Bastonne", false);
		else o1.setAktiv("Sergeant Bastonne", true);

		if(o1.isSelected("Sergeant Bastonne")) {
			bastonneSelected = true;
			BuildaHQ.addToInformationVector("IGBastonne", 1);
		} else {
			if(bastonneSelected) {
				bastonneSelected = false;
				BuildaHQ.setInformationVectorValue("IGBastonne", 0);
			}
		}
	}

    public void deleteYourself() {
        super.deleteYourself();
        if(o1.isSelected("Sergeant Bastonne")) BuildaHQ.setInformationVectorValue("IGBastonne", 0);
        if(o1.isSelected("Sergeant Steinzahn Harker")) BuildaHQ.setInformationVectorValue("IGHarker", 0);
    }

}
