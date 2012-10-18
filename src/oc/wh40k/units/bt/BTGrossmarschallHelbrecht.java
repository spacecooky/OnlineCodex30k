package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BTGrossmarschallHelbrecht extends Eintrag {

	AnzahlPanel Paladine;
	AnzahlPanel Neophyten;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	OptionsEinzelUpgrade oe6;
	OptionsEinzelUpgrade oc1;
	OptionsEinzelUpgrade oc2;
	OptionsEinzelUpgrade oc3;
	OptionsEinzelUpgrade oc4;
	RuestkammerStarter rkRazor;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkRaider;
	RuestkammerStarter rkPod;
	RuestkammerStarter rkBoss;

	public BTGrossmarschallHelbrecht() {
		name = "Großmarschall Helbrecht";
		grundkosten = 175;

		BuildaHQ.addToInformationVector("BTHQ", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/BTGrossmarschallHelbrecht.jpg"));

		/*ogE.addElement(new OptionsGruppeEintrag("Paladine", 16));
		add(m1 = new OptionsZählerGruppe(ID, randAbstand, cnt, "", ogE, 10));
		ogE.addElement(new OptionsGruppeEintrag("Neophyten", 10));
		add(m2 = new OptionsZählerGruppe(ID, randAbstand, cnt, "", ogE, 5));*/

		Paladine = new AnzahlPanel(ID, randAbstand, cnt, "Paladine", 0, 10, 16);
		Paladine.setNichtDieErsteOption(true);
		add(Paladine);

		Neophyten = new AnzahlPanel(ID, randAbstand, cnt, "Neophyt", "Neophyten", 0, 5, 10);
		Neophyten.setNichtDieErsteOption(true);
		add(Neophyten);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 6));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Fragmentgranaten", 0));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sprenggranaten", 0));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Kreuzzugssiegel", "Kreuzzugssiegel (nur Paladine)", 0));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Crux Terminatus", "Crux Terminatus (nur Paladine)", 0));
		add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Rasender Angriff", 0));

		seperator();

		add(oc1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Apothecarius", 15));
		add(oc2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Standartenträger", "Verbandsstandartenträger mit Verbandsstandarte", 25));
		add(oc4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Neophytenstandartenträger", "Neophytenstandartenträger mit Verbandsstandarte", 15));
		add(oc3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Verbandschampion", 20));

        seperator(8);

        ogE.addElement(new OptionsGruppeEintrag("Standartenträger", "Verbandsstandartenträger mit Verbandsstandarte", 25));
		ogE.addElement(new OptionsGruppeEintrag("Neophytenstandartenträger", "Neophytenstandartenträger mit Verbandsstandarte", 15));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator(5);
        
        ogE.addElement(new OptionsGruppeEintrag("Heilige Standarte", 20));
		ogE.addElement(new OptionsGruppeEintrag("Ordensbanner", 25));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sergeant", "Upgrade zum Sergeant", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sergeant mit CT", "Upgrade zum Sergeant mit Crux Terminatus", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator(8);

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BTArmoury", "");
		rkBoss.initKammer(false, false, true);
		rkBoss.setButtonText("Ausrüstung");
		add(rkBoss);

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
        setUnikat(true);
        o4.setAktiv(o3.isSelected());
		Paladine.setLegal(Paladine.getModelle() == 0 || Paladine.getModelle() >= 5);
		oe5.setAktiv(rkBoss.isSelected());
		oe6.setAktiv(Paladine.getModelle() > 0);
		oe6.setSelected(Paladine.getModelle() > 0);
		rkBoss.setAktiv(o2.isSelected("Upgrade zum Sergeant mit Crux Terminatus"));

		int count = Paladine.getModelle() + Neophyten.getModelle();
		int countPaladine = Paladine.getModelle();
		int freeModels = count - (oc1.isSelected() ? 1 : 0) - (oc2.isSelected() ? 1 : 0) - (oc3.isSelected() ? 1 : 0) - (oc4.isSelected() ? 1 : 0) - (o2.isSelected() ? 1 : 0);

		o1.setMaxAnzahl( freeModels < 2 ? freeModels : 2 );
		if(!o2.isSelected() && count > 0) o2.setSelected(0, true);

		oe1.setPreis(countPaladine * 2);
		oe3.setPreis(count * 1);
		oe4.setPreis(count * 2);
		oe5.setPreis((countPaladine-1) * 10);
		oe6.setPreis((count+1) * 3);

		rkRazor.setAktiv(count < 6 && !rkRhino.isSelected() && !rkRaider.isSelected() && !rkPod.isSelected());
		rkRhino.setAktiv(count < 10 && !rkRazor.isSelected() && !rkRaider.isSelected() && !rkPod.isSelected());
		rkRaider.setAktiv(count < 15 && !rkRhino.isSelected() && !rkRazor.isSelected() && !rkPod.isSelected());
		rkPod.setAktiv(count < 10 && !rkRhino.isSelected() && !rkRazor.isSelected() && !rkRaider.isSelected());

		rkRazor.getPanel().setLocation(
			(int) rkBoss.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
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

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("BTHQ", -1);
		super.deleteYourself();
	}

}
