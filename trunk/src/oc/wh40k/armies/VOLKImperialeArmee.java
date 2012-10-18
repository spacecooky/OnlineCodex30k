package oc.wh40k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.OnlineCodex;

public class VOLKImperialeArmee extends BuildaVater {

  public VOLKImperialeArmee() {
    reflectionKennung = "IG";
    reflectionKennungAllies = "IG";

    String[] HQeinträge = {"", "Kommandotrupp der Kompanie", "Lord-Kommissar", "Kommissar Yarrick", "Primaris-Psioniker", "Priester des Ministrorums", "Maschinenseher", "", "[Forgeworld] General Myndoras Odon"};
    String[] Eliteeinträge = {"", "Ogryn-Trupp", "Halbling-Trupp", "Psioniker-Kampftrupp", "Gardisten-Trupp", "Soldat Marbo"};
    String[] Standardeinträge = {"", "Infanteriezug", "Veteranentrupp", "Straflegionstrupp"};
    String[] Sturmeinträge = {"", "Späh-Sentinelschwadron", "Sturm-Sentinelschwadron", "Kavallerieschwadron", "Sturmpanzerschwadron", "Walküre-Sturmtransporterschwadron", "Vendetta-Jagdtransporterschwadron", 
    		"", "[IA Aeronautica] Aquila Lander","[IA Aeronautica] Vulture","[IA Aeronautica] Arvus Lighter"};
    String[] Unterstützungeinträge = {"", "Leman-Russ-Schwadron", "Hydra-Flakpanzerbatterie", "Geschützbatterie", "Raketenpanzer Manticor", "Todesstoss-Raketensystem", 
    		"", "[IA Aeronautica] Thunderbolt Fighter","[IA Aeronautica] Lightning", "[IA Aeronautica] Avenger Strike Fighter","[IA Aeronautica] Valkyre Sky Talon Transport","[IA Aeronautica] Manticore Launcher Tank (Air Defence)","[IA Aeronautica] Hydra Weapons Platform","[IA Aeronautica] Manticore Weapons Platform",
    		"", "[Forgeworld] Rapier Carrier with Laser Destroyer"};
    String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};

    String[] ApokalypseEinheiten = {
    		"", "[IA Aeronautica] Marauder Bomber","[IA Aeronautica] Marauder Destroyer","[IA Aeronautica] Praetor Armoured Assault Launcher (Air Defence)",
      "", "Baneblade", "Banehammer", "Banesword", "Doomhammer", "Festung der Arroganz", "Hellhammer", "Shadowsword", "Stormlord", "Stormsword",
      "", "Imperator-Kampftitan", "Warhound-Scouttitan", "Warlord-Kampftitan",
      "", "[Forgeworld] Crassus Armoured Assault Transport", "[Forgeworld] Dominus Armoured Siege Bombard", "[Forgeworld] Gorgon", "[Forgeworld] Macharius", "[Forgeworld] Macharius Omega", "[Forgeworld] Macharius Vanquisher", "[Forgeworld] Macharius Vulcan", "[Forgeworld] Malcador", "[Forgeworld] Malcador Annihilator", "[Forgeworld] Malcador Defender", "[Forgeworld] Praetor Armoured Assault Launcher", "[Forgeworld] Stormblade",
      "", "[Forgeworld] Reaver Battle Titan"
    };
    String[] ApokalypseFormation = {"", "Baneblade-Kompanie", "Imperialer Schild-Infanteriekompanie",
      "", "[Forgeworld] Praetor Sky Killer Aerial Suppression Force",
    };

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
    cnt += CHOOSERGRUPPEN_X_ABSTAND;

    if(OnlineCodex.getInstance().isApo()) {
      adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApokalypseEinheiten));
      cnt += CHOOSERGRUPPEN_X_ABSTAND;
      adden(new ChooserGruppe(reflectionKennung, cnt, 0, 8, ApokalypseFormation));
      cnt += CHOOSERGRUPPEN_X_ABSTAND;
    }

    cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

    nameDerArtDerArmee = "Imperiale Armee";
    nameDerArtDerArmeeDekliniert = "Imperiale Armee";
    textAreaUeberschrift = BuildaHQ.translate("Imperiale Armee");

    noAllies.clear();
    noAllies.add("IG");
	noAllies.add("TY");
    
    complete();
  }

  @Override
  protected void finalize() {
    System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
  }
}
