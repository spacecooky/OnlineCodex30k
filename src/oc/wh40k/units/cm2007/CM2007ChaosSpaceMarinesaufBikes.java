package oc.wh40k.units.cm2007;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CM2007ChaosSpaceMarinesaufBikes extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public CM2007ChaosSpaceMarinesaufBikes() {
		name = "Chaos Space Marines auf Bikes";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Biker", 3, 10, 33, "Chaos Space Marines auf Bikes");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 20));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Chaosbike Champion");
		rkBoss.setGrundkosten(15);
		rkBoss.initKammer(false, false, true, false);
		rkBoss.setButtonText("Chaosbike Champion", false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
