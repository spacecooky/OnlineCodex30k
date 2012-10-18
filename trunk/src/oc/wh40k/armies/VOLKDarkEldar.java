package oc.wh40k.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.OnlineCodex;

public class VOLKDarkEldar extends BuildaVater {

    public VOLKDarkEldar() {
        BuildaHQ.Items = new Vector<String>();

        reflectionKennung = "DE";
        reflectionKennungAllies = "DE";

        String[] HQeinträge = {"", "Archon", "Succubus", "Haemonculus", "", "Der Hofstaat des Archons", "", "Asdrubael Vect", "Fürstin Malys", "Drazhar Herr der Klingen", "Lelith Hesperax", "Urien Rakarth", "Herzog Sliscus Die Schlange", "Kheradruakh Der Dunkle Henker", "Baron Sathonyx"};
        String[] Eliteeinträge = {"", "Inccubi", "Grotesquen", "Mandraks", "Harlequine", "Fleischgeborene Kabalenkrieger", "Hekatrix-Blutbräute"};
        String[] Standardeinträge = {"", "Kabalenkrieger", "Hagashin"};
        String[] Sturmeinträge = {"", "Harpyien", "Bestienmeister", "Hyemshin"};
        String[] Unterstützungeinträge = {"", "Schattenjäger", "Talos-Schmerzmaschine", "Cronos-Parasitenmaschine", "Sichelflügel-Jäger", "Nachtrabe-Jagdbomber", "", "[Forgeworld] Raven Strike Fighter", "[Forgeworld] Reaper", "[Forgeworld] Void Dragon Phoenix", "[Forgeworld] Tantalus"};
        String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
        String[] ApoEinheiten = {""};
        String[] ApoFormationen = {"", "Karneval der Schmerzen", "[WD 192] Sichelflügel-Klingenschwadron"};

        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 2, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 3, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND; 
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 6, Befestigungen));
        
        if(OnlineCodex.getInstance().isApo()) {
        	cnt += CHOOSERGRUPPEN_X_ABSTAND;
            adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
            cnt += CHOOSERGRUPPEN_X_ABSTAND;
            adden(new ChooserGruppe(reflectionKennung, cnt, 0, 8, ApoFormationen));
        }
        cnt += 480;

        nameDerArtDerArmee = "Dark Eldar";
        nameDerArtDerArmeeDekliniert = "Dark Eldar";
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " Dark Eldar";
        
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Folterer");
        BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Hellion");

        noAllies.clear();
		
        noAllies.add("DE");
		noAllies.add("BA");
		noAllies.add("DA");
		noAllies.add("NE");
		noAllies.add("TL");
		noAllies.add("TY");
		
        complete();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }
}
