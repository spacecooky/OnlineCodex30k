package oc.whfb.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKOgerAB2004 extends BuildaVater {

    public static int OGERBULLEN = 0;
    public static int GNOBLERKRIEGER = 0;
    public static int SCHROTTSCHLEUDER = 0;
    public static int EISENWAENSTE = 0;

    public VOLKOgerAB2004() {
        reflectionKennung = "OG2004";

        //BuildaHQ.fuelleLabels();

        OGERBULLEN = 0;
        GNOBLERKRIEGER = 0;
        SCHROTTSCHLEUDER = 0;
        EISENWAENSTE = 0;

        String[] Kommandanten = {"", BuildaHQ.translate("Tyrann"), BuildaHQ.translate("Fleischermeister"), "", BuildaHQ.translate("Skrag der Schlächter"), BuildaHQ.translate("Speckus Goldzahn")};
        String[] Helden = {"", BuildaHQ.translate("Brecher"), BuildaHQ.translate("Jäger"), BuildaHQ.translate("Fleischer")};
        String[] Kern = {"", BuildaHQ.translate("Ogerbullen"), BuildaHQ.translate("Eisenwänste"), BuildaHQ.translate("Gnoblarkrieger"), BuildaHQ.translate("Gnoblar-Fallensteller")};
        String[] Elite = {"", BuildaHQ.translate("Bleispucker"), BuildaHQ.translate("Yhetis"), BuildaHQ.translate("Gnoblar-Schrottschleuder")};
        String[] Selten = {"", BuildaHQ.translate("Vielfrasse"), BuildaHQ.translate("Sklavenriese"), "", BuildaHQ.translate("Rhinox-Reiter")};

        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, Kommandanten));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 2, Helden));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 3, Kern));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Elite));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Selten));
        cnt += 480;

        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl(BuildaHQ.translate("Verschlinger"));

        nameDerArtDerArmee = BuildaHQ.translate("Ogerkönigreiche");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Ogerkönigreiche");
        textAreaUeberschrift = BuildaHQ.translate("Ogerkönigreiche");

        complete();
    }

    @Override
    protected void finalize() {
    }
}