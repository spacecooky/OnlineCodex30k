package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BTSchwertbruederTerminatorKommandotrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkRaider;
	RuestkammerStarter rkPod;
	RuestkammerStarter rkBoss;

	public BTSchwertbruederTerminatorKommandotrupp() {
		name = "Schwertbrüder-Terminator-Kommandotrupp";
		grundkosten = 0;
		setEintragsCNT(0);

		BuildaHQ.addToInformationVector("BTHQ", 1);
		BuildaHQ.addToInformationVector("BTKommandotrupp", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminatoren", 4, 10, 40, "Kommandotrupp Terminatoren");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BTSchwertbruederTerminatorKommandotrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cyclone-Rakwerfer", "Cyclone-Raketenwerfer", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Kreuzzugssiegel", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Rasender Angriff", 0));
		ogE.addElement(new OptionsGruppeEintrag("Panzerjäger", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BTArmoury", "Upgrade zum Sergeant");
		rkBoss.setGrundkosten(0);
		rkBoss.initKammer(false, true, true);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "BTLandRaiderCrusaderKammer", "Land Raider Crusader");
		rkRaider.initKammer();
		rkRaider.setButtonText("Land Raider Crusader");
		rkRaider.setSeperator(0);
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
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);

		int commanders = BuildaHQ.getCountFromInformationVector("BTKommandant");
		int commandSquads = BuildaHQ.getCountFromInformationVector("BTKommandotrupp");
		if(commandSquads > commanders) setFehlermeldung("Kommandotrupps > " + commanders + "!");
		else setFehlermeldung("");

		int count = squad.getModelle();
		
		o2.setMaxAnzahl(count - 1);
		o3.setPreis(0, (count+1) * 3);
		o3.setPreis(1, (count+1) * 3);
		oe1.setPreis(count * 2);

		rkRaider.setAktiv(count < 8 && !rkPod.isSelected());
		rkPod.setAktiv(count < 5 && !rkRaider.isSelected());

		rkRaider.getPanel().setLocation(
			(int) rkBoss.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
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
