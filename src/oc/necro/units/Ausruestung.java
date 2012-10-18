package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerHelper;

public class Ausruestung extends RuestkammerHelper {

    boolean erstesSpiel = false;

    OptionsUpgradeGruppe[] oe = new OptionsUpgradeGruppe[4];

	public Ausruestung() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Ziellaser", 40));
        ogE.addElement(new OptionsGruppeEintrag("Zielfernrohr", 40));
        ogE.addElement(new OptionsGruppeEintrag("Sichtverstärker", 40));
        ogE.addElement(new OptionsGruppeEintrag("Infrarotzielgerät", 30));
        add(oe[0] = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		setHeadline(oe[0], "Zielgeräte");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Armaplastrüustung", 10));
        ogE.addElement(new OptionsGruppeEintrag("Ceramitrüstung", 25));
        ogE.addElement(new OptionsGruppeEintrag("Plattenrüstung", 70));
        add(oe[1] = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setHeadline(oe[1], "Rüstungen");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Arm", "Bionischer Arm", 10));
        ogE.addElement(new OptionsGruppeEintrag("Auge", "Bionisches Auge", 50));
        ogE.addElement(new OptionsGruppeEintrag("Bein", "Bionisches Bein", 80));
        add(oe[2] = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		setHeadline(oe[2], "Bionics");

        cnt = randAbstand;

        ogE.addElement(new OptionsGruppeEintrag("Wartungsmaschine", 10));
        ogE.addElement(new OptionsGruppeEintrag("Bio-Booster", 50));
        ogE.addElement(new OptionsGruppeEintrag("Bio-Scanner",  50));
        ogE.addElement(new OptionsGruppeEintrag("Medizinbeutel", 30));
        ogE.addElement(new OptionsGruppeEintrag("Sicherheitsleine", 10));
        ogE.addElement(new OptionsGruppeEintrag("Versteckte Klinge", 10));
        ogE.addElement(new OptionsGruppeEintrag("Filterstöpsel", 10));
        ogE.addElement(new OptionsGruppeEintrag("Antigravschrim", 40));
        ogE.addElement(new OptionsGruppeEintrag("Enterhaken", 30));
        ogE.addElement(new OptionsGruppeEintrag("Infrarotbrille", 30));
        ogE.addElement(new OptionsGruppeEintrag("Generator", 500));
        ogE.addElement(new OptionsGruppeEintrag("Lobo-Chip", 20));
        ogE.addElement(new OptionsGruppeEintrag("Medi-Pack", 80));
        ogE.addElement(new OptionsGruppeEintrag("Mungvase", 30));
        ogE.addElement(new OptionsGruppeEintrag("Photo-Linsen", 15));
        ogE.addElement(new OptionsGruppeEintrag("Photo-Visor", 10));
        ogE.addElement(new OptionsGruppeEintrag("Ratskinkarte", 12));
        ogE.addElement(new OptionsGruppeEintrag("Respirator", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kreischer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Schalldämpfer", 52));
        ogE.addElement(new OptionsGruppeEintrag("Schädelchip", 30));
        ogE.addElement(new OptionsGruppeEintrag("Dämpfer", 10));
        add(oe[3] = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE,22));
		setHeadline(oe[3], "sontige Ausrüstung");

		sizeSetzen();
	}

	@Override
	public void refreshen() {

        for(int i=0;i<oe[0].getNumberOfOptions()-1;i++) {
            oe[0].setAktiv(i, !erstesSpiel);
        }

        for(int i=0;i<oe[1].getNumberOfOptions()-1;i++) {
            oe[1].setAktiv(i, !erstesSpiel);
        }

        for(int i=0;i<oe[2].getNumberOfOptions()-1;i++) {
            oe[2].setAktiv(i, !erstesSpiel);
        }

        for(int i=0;i<oe[3].getNumberOfOptions()-1;i++) {
            oe[3].setAktiv(i, !erstesSpiel);
        }

        oe[3].setAktiv("Sicherheitsleine", true);
        oe[3].setAktiv("Filterstöpsel", true);
        oe[3].setAktiv("Lobo-Chip", true);
        oe[3].setAktiv("Photo-Linsen", true);
        oe[3].setAktiv("Photo-Visor", true);
        oe[3].setAktiv("Respirator", true);

	}


    @Override
    public void specialVoid(boolean b) {
        erstesSpiel = b;
    }
}
