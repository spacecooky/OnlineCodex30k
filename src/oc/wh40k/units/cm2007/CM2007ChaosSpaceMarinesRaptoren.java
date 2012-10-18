package oc.wh40k.units.cm2007;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CM2007ChaosSpaceMarinesRaptoren extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;

	public CM2007ChaosSpaceMarinesRaptoren() {
		name = "Chaos Space Marines Raptoren";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Raptoren", 5, 20, 20, "Chaos Space Marines Raptoren");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosRaptors.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 20));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Aufstrebenden Champion");
		rkBoss.setGrundkosten(15);
		rkBoss.initKammer(false, false, false, true);
		rkBoss.setButtonText("Aufstrebender Champion", false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);


		complete();
	}

	@Override
	public void refreshen() {
	}

}
