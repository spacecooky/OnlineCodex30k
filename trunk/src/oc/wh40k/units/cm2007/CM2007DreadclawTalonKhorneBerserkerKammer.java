package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007DreadclawTalonKhorneBerserkerKammer extends RuestkammerVater {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public CM2007DreadclawTalonKhorneBerserkerKammer() {}
	
	public void initButtons(boolean... defaults) {
		name = "Khorne Berserker";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Khorne Berserker", 5, 20, 21);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/KhorneBerzerkers.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Persönliche Ikone", 5));

		seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Plasmapistole", 2, 15));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Schädelchampion");
		rkBoss.setGrundkosten(15);
		rkBoss.initKammer(false, true, false, false);
		rkBoss.setButtonText("Schädelchampion", false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

//        BuildaHQ.addToInformationVector("CMBerserker", 1);
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

    @Override
    public void deleteYourself() {
//        BuildaHQ.addToInformationVector("CMBerserker", -1);
        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");
        super.deleteYourself();
    }

}
