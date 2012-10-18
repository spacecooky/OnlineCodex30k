package oc.wh40k.units.de;

import java.util.Vector;
import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsUpgradeGruppeUnique;
import oc.OptionsZaehlerGruppe;

public class DEHaemonculus extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppeUnique o2;
    OptionsUpgradeGruppe o3;
    
    public DEHaemonculus() {
        name = "Haemonculus";
        grundkosten = 50;

        BuildaHQ.addToInformationVector("DEHaemonculus", 1);

        add(ico = new oc.Picture("oc/wh40k/images/DEHaemonculus.jpg"));
        

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Folterer");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Folterer");

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Upgrade zum Ältesten", "Upgrade zum Haemonculus-Ältesten", 30));
        oe1.setToolTipText("Maximal 3 Haemonculi gelten als eine HQ-Auswahl. Pro HQ-Auswahl darf maximal ein Haemonculus ein Ältester sein.");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Toxin-Nadler", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Unterw.-Handschuh", "Unterwerfungshandschuh", 10));
        ogE.addElement(new OptionsGruppeEintrag("Injektorhandschuh", 20));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        ogE.addElement(new OptionsGruppeEintrag("Schockpeitsche", 20));
        ogE.addElement(new OptionsGruppeEintrag("Staubklinge", 35));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Animus Vitae", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schatulle d. Schindens","Schatulle des Schindens", 10));
        ogE.addElement(new OptionsGruppeEintrag("Engel der Qualen", 15));
        ogE.addElement(new OptionsGruppeEintrag("Splitterscherbe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Urne d. V. Seelen", "Urne der Verdammten Seelen", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sphäre der Verzweiflung", 20));
        ogE.addElement(new OptionsGruppeEintrag("Dunkles Tor", 25));
        add(o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE, 0));

        ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Säurewerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Seelenfalle", 10));
        ogE.addElement(new OptionsGruppeEintrag("Fleischmaske", 10));
        ogE.addElement(new OptionsGruppeEintrag("Scherenhand", 15));
        ogE.addElement(new OptionsGruppeEintrag("Hexgewehr", 15));
        ogE.addElement(new OptionsGruppeEintrag("Portalfokus", 35));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();

        BuildaHQ.addToInformationVector("DEHaemonculus", -1);
        if(BuildaHQ.getCountFromInformationVector("DEHaemonculus") < 1) {
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Folterer");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Folterer");
        }
    }

    @Override
    public void refreshen() {
        setEintragsCNT(this.calculateEntryCount());
        o2.setMaxAnzahl(2 - o3.getAnzahl());
        o3.setMaxAnzahl(2 - o2.getAnzahl());
    }

	/**
	 * eintragsCNT berechnen
	 * @return eintragsCNT
	 */
	private double calculateEntryCount() {
		double count = 0.0;
		Vector<Chooser> allChooser = BuildaHQ.getChooserGruppe(1).getmC();
		for(Chooser chooser : allChooser) {
			if(chooser.getEintrag() instanceof DEHaemonculus) {
				count += 1;
			}
		}

		// merhfache von 3 beachten
		double adder = 1.0;
		double checkCount = count;
		while(checkCount > 3) {
			checkCount = checkCount - 3.0;
			adder++;
		}

		return adder / (count == 0.0 ? 1.0 : count);
	}

}
