package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BTKommandotrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oc1;
	OptionsEinzelUpgrade oc2;
	OptionsEinzelUpgrade oc3;
	RuestkammerStarter rkRazor;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkRaider;
	RuestkammerStarter rkPod;
	RuestkammerStarter rkBoss;

	public BTKommandotrupp() {
		name = "Kommandotrupp";
		grundkosten = 0;
		setEintragsCNT(0);

		BuildaHQ.addToInformationVector("BTHQ", 1);
		BuildaHQ.addToInformationVector("BTKommandotrupp", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Paladine", 5, 10, 16, "Kommandotrupp-Paladine");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BTKommandotrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Raktenwerfer", 20));
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
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Kreuzzugssiegel", 0));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Crux Terminatus", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Rasender Angriff", 0));
		ogE.addElement(new OptionsGruppeEintrag("Gegenschlag", 0));
		ogE.addElement(new OptionsGruppeEintrag("Infiltratoren", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(oc3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Verbandschampion", 20));
		add(oc1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Apothecarius", 15));
		add(oc2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Standartenträger", "Verbandsstandartenträger", 25));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Verbandsstandarte", 0));
		ogE.addElement(new OptionsGruppeEintrag("Ordensbanner (Unikat)", "Ordensbanner", 25));
		ogE.addElement(new OptionsGruppeEintrag("Heilige Standarte (Unikat)", "Heilige Standarte", 20));
		ogE.addElement(new OptionsGruppeEintrag("Reliquie (Unikat)", "Reliquie", 30));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sergeant", "Upgrade zum Sergeant", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sergeant mit Crux T.", "Upgrade zum Sergeant mit Crux Terminatus", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
		oe2.setAktiv(o4.isSelected("Upgrade zum Sergeant mit Crux Terminatus"));
		o3.setAktiv(oc2.isSelected());
		if(!o3.isSelected() && oc2.isSelected()) o3.setSelected(0, true);
		o3.setAktiv("Reliquie (Unikat)", BuildaHQ.getCountFromInformationVector("BTChaplain") > 0 && o3.isAktiv());
		rkBoss.setAktiv(o4.isSelected("Upgrade zum Sergeant mit Crux Terminatus"));

		int commanders = BuildaHQ.getCountFromInformationVector("BTKommandant");
		int commandSquads = BuildaHQ.getCountFromInformationVector("BTKommandotrupp");
		if(commandSquads > commanders) setFehlermeldung("Kommandotrupps > " + commanders + "!");
		else setFehlermeldung("");

		int count = squad.getModelle();
		int freeModels = count - (oc1.isSelected() ? 1 : 0) - (oc2.isSelected() ? 1 : 0) - (oc3.isSelected() ? 1 : 0) - (o4.isSelected() ? 1 : 0);
		if(!o4.isSelected() && count > 0) o4.setSelected(0, true);

		o1.setMaxAnzahl( freeModels < 2 ? freeModels : 2 );

		o2.setPreis(0, (count+1) * 3);
		o2.setPreis(1, (count+1) * 3);
		o2.setPreis(2, (count+1) * 3);
		oe1.setPreis(count * 2);
		oe2.setPreis((count-1) * 10);
		oe3.setPreis(count * 1);
		oe4.setPreis(count * 2);

		boolean hasInfiltratoren = o2.isSelected("Infiltratoren");

		rkRazor.setAktiv(count < 6 && !rkRhino.isSelected() && !rkRaider.isSelected() && !rkPod.isSelected() && !hasInfiltratoren);
		rkRhino.setAktiv(count < 10 && !rkRazor.isSelected() && !rkRaider.isSelected() && !rkPod.isSelected() && !hasInfiltratoren);
		rkRaider.setAktiv(count < 15 && !rkRhino.isSelected() && !rkRazor.isSelected() && !rkPod.isSelected() && !hasInfiltratoren);
		rkPod.setAktiv(count < 10 && !rkRhino.isSelected() && !rkRazor.isSelected() && !rkRaider.isSelected() && !hasInfiltratoren);

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
		BuildaHQ.addToInformationVector("BTKommandotrupp", -1);
		super.deleteYourself();
	}

}
