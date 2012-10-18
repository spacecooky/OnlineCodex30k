package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007DreadclawTalonChaosSpaceMarinesKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe o8;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBoss;

	public CM2007DreadclawTalonChaosSpaceMarinesKammer() {}
	
	public void initButtons(boolean... defaults) {
		name = "Chaos Space Marines";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Space Marines", 5, 20, 15);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.gif"));
		

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fabius Gallus' Elite-Krieger", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 20));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Aufstrebenden Champion");
		rkBoss.setGrundkosten(15);
		rkBoss.initKammer(false, false, false, false);
		rkBoss.setButtonText("Aufstrebender Champion", false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o8.setAktiv(squad.getModelle() > 9);

		oe1.setAktiv(BuildaHQ.getCountFromInformationVector("CMFabiusGallus") > 0);
		oe1.setPreis(squad.getModelle() * 3);
	}

}
