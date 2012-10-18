package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007DreadclawTalonSeuchenmarinesKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelUpgrade ot;
	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkBoss;

	public CM2007DreadclawTalonSeuchenmarinesKammer() {}
	
	public void initButtons(boolean... defaults) {
		name = "Seuchenmarines";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Seuchenmarines", 5, 20, 23);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/PlagueMarines.gif"));

		seperator();

		add(ot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Persönliche Ikone", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Seuchenchampion");
		rkBoss.setGrundkosten(15);
		rkBoss.initKammer(false, false, false, false);
		rkBoss.setButtonText("Seuchenchampion", false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

        BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("[Forgeworld] Plague Ogryns");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

    @Override
    public void deleteYourself() {
//        BuildaHQ.addToInformationVector("CMPlague", -1);
        BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("[Forgeworld] Plague Ogryns");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");
        super.deleteYourself();
    }

}
