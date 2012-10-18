package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BTTaktischerTrupp extends Eintrag {

	AnzahlPanel Initiates;
	AnzahlPanel Neophytes;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	RuestkammerStarter rkRazor;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkRaider;
	RuestkammerStarter rkPod;
    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o4;

	public BTTaktischerTrupp() {
		name = "Taktischer Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		Initiates = new AnzahlPanel(ID, randAbstand, cnt, "Paladine", 5, 10, 16);
		add(Initiates);

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("BP & NKW", "Boltpistole und Nahkampfwaffe", 0));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o3.setAnzahl(0, Initiates.getModelle());

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/BTTaktischerTrupp.jpg"));


		seperator();
                
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 6));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 6));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Fragmentgranaten", 0));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sprenggranaten", 0));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Kreuzzugssiegel (Paladine)", "Kreuzzugssiegel für alle Paladine", 0));

        seperator();

		Neophytes = new AnzahlPanel(ID, randAbstand, cnt, "Neophyt", "Neophyten", 0, Initiates.getModelle(), 10);
		Neophytes.setNichtDieErsteOption(true);
		add(Neophytes);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
        ogE.addElement(new OptionsGruppeEintrag("BP & NKW", "Boltpistole und Nahkampfwaffe", 0));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		rkRazor = new RuestkammerStarter(ID, randAbstand, cnt, "BTRazorbackKammer", "Razorback");
		rkRazor.initKammer();
		add(rkRazor);

		seperator();

		rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "BTRhinoKammer", "Rhino");
		rkRhino.initKammer();
		add(rkRhino);

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "BTLandRaiderCrusaderKammer", "Land Raider Crusader");
		rkRaider.initKammer();
		add(rkRaider);

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "BTDropPodKammer", "Landungskapsel");
		rkPod.initKammer(false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);
                
		complete();
	}

	@Override
	public void refreshen() {
		Neophytes.setMaxModelle(Initiates.getModelle());

		int count = Initiates.getModelle() + Neophytes.getModelle();
		int countInitiates = Initiates.getModelle();

		oe1.setPreis(count * 1);
		oe2.setPreis(count * 2);
		oe3.setPreis(countInitiates * 2);

        o3.setMaxAnzahl(Initiates.getModelle() - (o1.isSelected() ? 1 : 0) - (o2.isSelected() ? 1 : 0));
        o3.setLegal(o3.getAnzahl() == o3.getMaxAnzahl());
        o4.setMaxAnzahl(Neophytes.getModelle());
        o4.setLegal(o4.getAnzahl() == o4.getMaxAnzahl());

		rkRazor.setAktiv(count <= 6 && !rkRhino.isSelected() && !rkRaider.isSelected() && !rkPod.isSelected());
		rkRhino.setAktiv(count <= 10 && !rkRazor.isSelected() && !rkRaider.isSelected() && !rkPod.isSelected());
		rkRaider.setAktiv(count <= 15 && !rkRhino.isSelected() && !rkRazor.isSelected() && !rkPod.isSelected());
		rkPod.setAktiv(count <= 10 && !rkRhino.isSelected() && !rkRazor.isSelected() && !rkRaider.isSelected());

		rkRhino.getPanel().setLocation(
			(int) rkRazor.getPanel().getLocation().getX(),
			(int) rkRazor.getPanel().getLocation().getY() + rkRazor.getPanel().getSize().height + 5
		);
		rkRaider.getPanel().setLocation(
			(int) rkRhino.getPanel().getLocation().getX(),
			(int) rkRhino.getPanel().getLocation().getY() + rkRhino.getPanel().getSize().height + 5
		);
		rkPod.getPanel().setLocation(
			(int) rkRaider.getPanel().getLocation().getX(),
			(int) rkRaider.getPanel().getLocation().getY() + rkRaider.getPanel().getSize().height + 5
		);
	}

}
