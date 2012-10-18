package oc.wh40k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKChaosSpaceMarines extends BuildaVater {

	public VOLKChaosSpaceMarines() {
		reflectionKennung = "CM";
		reflectionKennungAllies = "CM";

		String[] HQeinträge = {"", "Chaosgeneral", "Hexer", "Dämonenprinz", "Warpschmied", "Dunkler Apostel", "", "Abaddon der Vernichter", "Ahriman", "Fabius Gallus", "Huron Schwarzherz", "Kharn der Verräter", "Lucius der Ewige", "Typhus", 
							   "", "[Forgeworld] Zhufor", "[Forgeworld] Necrosius"};
		String[] Eliteeinträge = {"", "Besessene", "Chaosterminatoren", "Höllenschlächter", "Multilator",
				"", "[IA Experimental] Land Raider Proteus",
				"", "[Forgeworld] Chaos Contemptor Dreadnought", "[Forgeworld] Giant Chaos Spawn","[Forgeworld] Chaos Decimator Daemon Engine"};
		String[] Standardeinträge = {"", "Chaos Space Marines", "Chaoskultisten"};
		String[] Sturmeinträge = {"", "Chaosbiker", "Raptoren", "Warpkrallen", "Chaosbrut", "Höllendrache",
								  "","[IA Aeronautica] Chaos Storm Eagle","[IA Aeronautica] Dreadclaw", "[IA Aeronautica] Hell Blade","[IA Aeronautica] Hell Talon"};
		String[] Unterstützungeinträge = {"", "Havocs", "Kyborg", "Geissel", "Schmiedemonstrum", "Klauenmonstrum", "Land Raider des Chaos", "Vindicator des Chaos", "Predator des Chaos", 
				"", "[IA Experimental] Chaos Spartan Assault Tank",
				"", "[Forgeworld] Spined Chaos Beast"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
		String[] ApoEinheiten = {
            "", "Messingskorpion des Khorne", "Schädelturm des Khorne", "Seuchenfestung des Nurgle", "Seuchenspender des Nurgle", "Silberzitadelle des Tzeentch", "Verdammnismörser des Khorne", "Weltuntergangsmaschine",
            "", "Banelord-Titan des Khorne", "Chaos Warhound Titan", "Herrscher der Schlachten", "Subjugator-Titan des Slaanesh",
            "", "[Forgeworld] Aetaos\'rau\'keres - Slayer of Souls", "[Forgeworld] An'ggrath the Unbound", "[Forgeworld] Scabeiathrax the Bloated", "[Forgeworld] Zarakynel",
            "", "[Forgeworld] Chaos Reaver Battle Titan", "[Forgeworld] Greater Brass Scorpion of Khorne"
        };
        String[] ApoForm = {
            "", /*"Chaos-Eliminatorzirkel", "Emperor's-Children-Kampfverband", "Geißel-Sturmverband", "Hexerzirkel der Thousand Sons",*/"Dreadclaw Talon",
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
		if(oc.OnlineCodex.getInstance().isApo()) cnt += CHOOSERGRUPPEN_X_ABSTAND;
		if(oc.OnlineCodex.getInstance().isApo()) adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
		if(oc.OnlineCodex.getInstance().isApo()) cnt += CHOOSERGRUPPEN_X_ABSTAND;
		if(oc.OnlineCodex.getInstance().isApo()) adden(new ChooserGruppe(reflectionKennung, cnt, 0, 8, ApoForm));
		cnt += 480;
		
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Auserkorene");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Khorne-Berserker");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Thousand Sons");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Seuchenmarines");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Noisemarines");
		
		nameDerArtDerArmee = "Chaos Space Marines";
		nameDerArtDerArmeeDekliniert = "Chaos Space Marines";
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " Chaos Space Marines";

		noAllies.clear();
		noAllies.add("CM");
		noAllies.add("BT");
		noAllies.add("DA");
		noAllies.add("BA");
		noAllies.add("EL");
		noAllies.add("GK");
		noAllies.add("AS");
		noAllies.add("SM");
		noAllies.add("SW");
		noAllies.add("TY");
		noAllies.add("EC");
		noAllies.add("SF");
		noAllies.add("TL");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}