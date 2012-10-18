package oc.wh40k.armies;

import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKNecrons extends BuildaVater {

    public VOLKNecrons() {
        reflectionKennung = "NE";
        reflectionKennungAllies = "NE";

        BuildaHQ.Items = new Vector<String>();

        String[] HQeintr�ge = {"", "Hochlord", "Destruktor-Lord", "Herrscherrat", "", "Imotekh der Sturmherr", "Nemesor Zanndrekh", "Vargard Obyron", "Illuminor Szeras", "Orikan der Seher", "Anrakyr der Reisende", "Trazyn der Unendliche"};
        String[] Eliteeintr�ge = {"", "Eliminatoren", "Leibgarde", "Pr�torianer des Triarchats", "C'tan Fragment", "Albtraum-Meute", "Jagdl�ufer des Triarchats"};
        String[] Standardeintr�ge = {"", "Krieger", "Extinktoren"};
        String[] Sturmeintr�ge = {"", "Kanoptech-Phantome", "Kanoptech-Skarab�en", "Exovenatoren", "Destruktoren",
        		"","[IA Experimental] Canoptek Acanthrites"};
        String[] Unterst�tzungeintr�ge = {"", "Dominator-Barke", "Annihilator-Gleiter", "Monolith", "Todessichel", "Kanoptech-Spinnen", "", "[Forgeworld] Tomb Stalker"};
        String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
        String[] ApoEinheiten = {"", "Gauss Pylon"};
        String[] ApoFormationen = {"", "Undying Legion", "Gauss Pylon Network"};

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
        if (oc.OnlineCodex.getInstance().isApo()) {
            cnt += CHOOSERGRUPPEN_X_ABSTAND;
        }
        if (oc.OnlineCodex.getInstance().isApo()) {
            adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
            cnt += CHOOSERGRUPPEN_X_ABSTAND;
            adden(new ChooserGruppe(reflectionKennung, cnt, 0, 8, ApoFormationen));
        }
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = "Necrons";
        nameDerArtDerArmeeDekliniert = "Necrons";
        textAreaUeberschrift = "Necrons";

        noAllies.clear();
    	
        noAllies.add("NE");
    	noAllies.add("CD");
    	noAllies.add("DE");
    	noAllies.add("EC");
    	noAllies.add("EL");
    	noAllies.add("TL");
    	noAllies.add("TY");
        
        complete();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
    }
}