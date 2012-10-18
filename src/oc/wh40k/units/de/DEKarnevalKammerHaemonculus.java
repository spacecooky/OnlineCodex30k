/* Regeln zu finden unter:
 * http://www.games-workshop.com/MEDIA_CustomProductCatalog/m2430606_Apo_-_Dark_Eldar_-_Karneval_der_Schmerzen.pdf
 */

package oc.wh40k.units.de;

import java.util.Vector;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsUpgradeGruppeUnique;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DEKarnevalKammerHaemonculus extends RuestkammerVater {

    OptionsEinzelUpgrade oe1;
    OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppeUnique o2;
    OptionsUpgradeGruppe o3;

    public DEKarnevalKammerHaemonculus() {
        name = "Haemonculus";
        grundkosten = 50;
    }

    @Override
    public void initButtons(boolean... defaults) {
        name = "Haemonculus";
        grundkosten = 50;

        BuildaHQ.addToInformationVector("DEHaemonculus", 1);

        add(ico = new oc.Picture("oc/wh40k/images/DEHaemonculus.jpg"));
        

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Folterer");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Folterer");

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Upgrade zum Ältesten", "Upgrade zum Haemonculus-Ältesten", 30));
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
        ogE.addElement(new OptionsGruppeEintrag("Spliterscherbe", 15));
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

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

    public void deleteYourself() {
        super.deleteYourself();

        BuildaHQ.addToInformationVector("DEHaemonculus", -1);
        if(BuildaHQ.getCountFromInformationVector("DEHaemonculus") < 1) {
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Folterer");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Folterer");
        }
    }

}
