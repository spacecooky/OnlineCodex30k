package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class SWWolfsgardeRudel extends Eintrag {

	AnzahlPanel squadSR;
	AnzahlPanel squadTR;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o3x;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe cyclone;
	OptionsZaehlerGruppe o5;
	OptionsZaehlerGruppe o5x;
	OptionsZaehlerGruppe mbs;
	OptionsZaehlerGruppe mbt;

	OptionsEinzelUpgrade arjac;
	OptionsEinzelUpgrade wulfenSR;
	OptionsEinzelUpgrade wulfenTR;

	RuestkammerStarter rkTransport;
	RuestkammerStarter rkRaider;
	RuestkammerStarter rkPod;

	boolean arjacSelected = false;
	boolean raiderSelected = false;

	public SWWolfsgardeRudel() {
		name = "Wolfsgarde-Rudel";
		grundkosten = 0;
		überschriftSetzen = true;

		add(arjac = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Arjac Felsenfaust", 188));

		seperator();

		squadSR = new AnzahlPanel(ID, randAbstand, cnt, "Wolfsgardist", "Wolfsgardisten", 0, 10, 18);
		squadSR.setZeilenumbruchZuvor(true);
		add(squadSR);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWGefolgederWolfsgarde.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Wolfsklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 20));
		ogE.addElement(new OptionsGruppeEintrag("Frostklinge", 20));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		seperator();

		add(wulfenSR = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mal des Wulfen", "1 x Mal des Wulfen", 15));

		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(mbs = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		squadTR = new AnzahlPanel(ID, randAbstand, cnt, "Terminator-Gardist", "Terminator-Gardisten", 0, 10, 33);
		squadTR.setZeilenumbruchZuvor(true);
		add(squadTR);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Wolfsklaue", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 30));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Cyclone-Raketenwerfer", 30));
		add(cyclone = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
		add(o5x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Wolfsklaue", 5));
		ogE.addElement(new OptionsGruppeEintrag("Frostklinge", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 15));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		seperator();

		add(wulfenTR = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mal des Wulfen", "1 x Mal des Wulfen", 15));

		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(mbt = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();
		
		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SWTransporterKammer", "Transportfahrzeug");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transportfahrzeug");
		add(rkTransport);

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "SWLandRaiderKammer", "Land Raider");
		rkRaider.initKammer();
		rkRaider.setButtonText("Land Raider");
		add(rkRaider);

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SWDropPodKammer", "Landungskapsel");
		rkPod.initKammer(false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);
        
		complete();
	}
        
        @Override
        public void deleteYourself() {
        	if(arjac.isSelected()){ 
        		BuildaHQ.addToInformationVector("SWArjac", -1);
        	}
            super.deleteYourself();
            
        }

	@Override
	public void refreshen() {
		// Unique entry: Arjac Felsenfaust
		boolean arjacGlobal = ( BuildaHQ.getCountFromInformationVector("SWArjac") > 0 ? true : false );
		if(arjacGlobal && !arjacSelected) arjac.setAktiv(false);
		else {
			int totalModels = squadSR.getModelle() + squadTR.getModelle();
			arjac.setAktiv(totalModels < 10);
		}

		if (arjacSelected != arjac.isSelected()) {
			arjacSelected = !arjacSelected;

			if (arjacSelected) {
				BuildaHQ.addToInformationVector("SWArjac", 1);
			} else {
				BuildaHQ.addToInformationVector("SWArjac", -1);
			}
			BuildaHQ.refreshEntries(2);
			BuildaHQ.refreshEntries(3);
		}
		
		arjac.setLegal(BuildaHQ.getCountFromInformationVector("SWArjac") <2 || !arjac.isSelected());

		int totalModels = squadSR.getModelle() + squadTR.getModelle() + (arjac.isSelected() ? 1 : 0);
		boolean legal = totalModels >= 3 && totalModels <= 10;
		squadSR.setLegal(legal);
		squadTR.setLegal(legal);
		wulfenSR.setAktiv(!wulfenTR.isSelected() && legal && squadSR.getModelle() > 0);
		wulfenTR.setAktiv(!wulfenSR.isSelected() && legal && squadTR.getModelle() > 0);

		squadTR.setMaxModelle(10 - squadSR.getModelle());

		o1.setMaxAnzahl(squadSR.getModelle() * 2);
		o1.setAktiv(squadSR.getModelle() > 0);
		mbs.setAktiv(squadSR.getModelle() > 0);

		o2.setMaxAnzahl(squadSR.getModelle());
		o2.setAktiv(squadSR.getModelle() > 0);

		o3.setAktiv(squadTR.getModelle() > 0);
		o3x.setAktiv(squadTR.getModelle() > 0);
		o3.setMaxAnzahl(squadTR.getModelle() - o4.getAnzahl());
		o3x.setMaxAnzahl(squadTR.getModelle() - o4.getAnzahl());
		o3x.setAnzahl(0, squadTR.getModelle() - o3.getAnzahl() - o4.getAnzahl());

		mbt.setAktiv(squadTR.getModelle() > 0);

		o4.setMaxAnzahl((totalModels / 5) - cyclone.getAnzahl());
		o4.setAktiv(squadTR.getModelle() > 0);
		cyclone.setMaxAnzahl(totalModels / 5);
		cyclone.setAktiv(squadTR.getModelle() > 0);
        cyclone.setLegal(cyclone.getAnzahl() <= squadTR.getModelle());

		o5.setAktiv(squadTR.getModelle() > 0);
		o5x.setAktiv(squadTR.getModelle() > 0);
		o5.setMaxAnzahl(squadTR.getModelle());
		o5x.setMaxAnzahl(squadTR.getModelle());
		o5x.setAnzahl(0, squadTR.getModelle() - o5.getAnzahl());

		mbs.setMaxAnzahl(squadSR.getModelle());
		mbt.setMaxAnzahl(squadTR.getModelle());

		rkTransport.setAktiv(!rkRaider.isSelected() && !rkPod.isSelected());
		rkRaider.setAktiv(!rkTransport.isSelected() && !rkPod.isSelected());
		rkPod.setAktiv(!rkTransport.isSelected() && !rkRaider.isSelected());

		// Unique entry: Land Raider
		boolean raiderGlobal = ( BuildaHQ.getCountFromInformationVector("SWWolfguardRaider") > 0 ? true : false );
		if(raiderGlobal && !raiderSelected) rkRaider.setAktiv(false);
		else rkRaider.setAktiv(true);

		if(rkRaider.isSelected()) {
			raiderSelected = true;
			BuildaHQ.addToInformationVector("SWWolfguardRaider", 1);
		} else {
			if(raiderSelected) {
				raiderSelected = false;
				BuildaHQ.setInformationVectorValue("SWWolfguardRaider", 0);
				BuildaHQ.refreshEntries(2);
				BuildaHQ.refreshEntries(3);
			}
		}
		
	}

}
