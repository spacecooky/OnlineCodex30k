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

        String[] HQeintr�ge = {"", "Archon", "Succubus", "Haemonculus", "", "Der Hofstaat des Archons", "", "Asdrubael Vect", "F�rstin Malys", "Drazhar Herr der Klingen", "Lelith Hesperax", "Urien Rakarth", "Herzog Sliscus Die Schlange", "Kheradruakh Der Dunkle Henker", "Baron Sathonyx"};
        String[] Eliteeintr�ge = {"", "Inccubi", "Grotesquen", "Mandraks", "Harlequine", "Fleischgeborene Kabalenkrieger", "Hekatrix-Blutbr�ute"};
        String[] Standardeintr�ge = {"", "Kabalenkrieger", "Hagashin"};
        String[] Sturmeintr�ge = {"", "Harpyien", "Bestienmeister", "Hyemshin"};
        String[] Unterst�tzungeintr�ge = {"", "Schattenj�ger", "Talos-Schmerzmaschine", "Cronos-Parasitenmaschine", "Sichelfl�gel-J�ger", "Nachtrabe-Jagdbomber", "", "[Forgeworld] Raven Strike Fighter", "[Forgeworld] Reaper", "[Forgeworld] Void Dragon Phoenix", "[Forgeworld] Tantalus"};
        String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
        String[] ApoEinheiten = {""};
        String[] ApoFormationen = {"", "Karneval der Schmerzen", "[WD 192] Sichelfl�gel-Klingenschwadron"};

        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, HQeintr�ge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 2, Eliteeintr�ge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 3, Standardeintr�ge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Sturmeintr�ge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Unterst�tzungeintr�ge));
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
        System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
    }
}
