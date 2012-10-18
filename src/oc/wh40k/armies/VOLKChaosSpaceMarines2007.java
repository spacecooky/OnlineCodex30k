package oc.wh40k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKChaosSpaceMarines2007 extends BuildaVater {

	public VOLKChaosSpaceMarines2007() {
		reflectionKennung = "CM2007";
		reflectionKennungAllies = "CM2007";

		String[] HQeintr�ge = {"", "D�monenprinz", "Chaosgeneral", "Chaoshexer", "", "Beschworener Grosser D�mon", "", "Abaddon der Vernichter", "Fabius Gallus", "Huron Schwarzherz", "Typhus", "Kharn der Verr�ter", "Ahriman", "Lucius der Ewige", "Zhufor", "[Forgeworld] Necrosius"};
		String[] Eliteeintr�ge = {"", "Auserkorene Chaos Space Marines", "Chaosterminatoren", "Besessene Chaos Space Marines", "Chaos-Cybot", 
				"", "[IA Experimental] Land Raider Proteus",
				"", "[Forgeworld] Chaos Contemptor Dreadnought", "[Forgeworld] Giant Chaos Spawn","[Forgeworld] Chaos Decimator Daemon Engine"};
		String[] Standardeintr�ge = {"", "Chaos Space Marines", "Seuchenmarines", "Noise Marines", "Khorne Berserker", "Thousand Sons", "", "Beschworene Niedere D�monen"};
		String[] Sturmeintr�ge = {"", "Chaos Space Marines auf Bikes", "Chaos Space Marines Raptoren", "Chaosbrut",
								  "","[IA Aeronautica] Chaos Storm Eagle","[IA Aeronautica] Dreadclaw", "[IA Aeronautica] Hell Blade","[IA Aeronautica] Hell Talon"};
		String[] Unterst�tzungeintr�ge = {"", "Chaos Space Marines Havocs", "Kyborgkult", "Chaos-Predator", "Chaos-Vindicator", "Chaos-Geissel", "Chaos Land Raider", 
				"", "[IA Experimental] Chaos Spartan Assault Tank",
				"", "[Forgeworld] Spined Chaos Beast"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
		String[] ApoEinheiten = {
            "", "Messingskorpion des Khorne", "Sch�delturm des Khorne", "Seuchenfestung des Nurgle", "Seuchenspender des Nurgle", "Silberzitadelle des Tzeentch", "Verdammnism�rser des Khorne", "Weltuntergangsmaschine",
            "", "Banelord-Titan des Khorne", "Chaos Warhound Titan", "Herrscher der Schlachten", "Subjugator-Titan des Slaanesh",
            "", "[Forgeworld] Aetaos\'rau\'keres - Slayer of Souls", "[Forgeworld] An'ggrath the Unbound", "[Forgeworld] Scabeiathrax the Bloated", "[Forgeworld] Zarakynel",
            "", "[Forgeworld] Chaos Reaver Battle Titan", "[Forgeworld] Greater Brass Scorpion of Khorne"
        };
        String[] ApoForm = {
            "", "Chaos-Eliminatorzirkel", "Emperor's-Children-Kampfverband", "Gei�el-Sturmverband", "Hexerzirkel der Thousand Sons","Dreadclaw Talon",
        };
        
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
		if(oc.OnlineCodex.getInstance().isApo()) cnt += CHOOSERGRUPPEN_X_ABSTAND;
		if(oc.OnlineCodex.getInstance().isApo()) adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
		if(oc.OnlineCodex.getInstance().isApo()) cnt += CHOOSERGRUPPEN_X_ABSTAND;
		if(oc.OnlineCodex.getInstance().isApo()) adden(new ChooserGruppe(reflectionKennung, cnt, 0, 8, ApoForm));
		cnt += 480;

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
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}

}