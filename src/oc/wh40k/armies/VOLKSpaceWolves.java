package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKSpaceWolves extends BuildaVater {

	public VOLKSpaceWolves() {
		reflectionKennung = "SW";
		reflectionKennungAllies = "SW";

		String[] HQeintr�ge = {"", "Wolfslord", "Runenpriester", "Wolfspriester", "Held der Wolfsgarde", "", "Logan Grimnar", "Njal Sturmbringer", "Wolfslord Ragnar Schwarzm�hne", "Ulrik der Todeswolf", "Canis Wolfsblut", "Bjorn Wolfsklaue", 
				"", "[Imperial Armour 11] Bran Redmaw",
				"", "[Forgeworld] Damocles Rhino"};
		String[] Eliteeintr�ge = {"", "Cybot", "Ehrw�rdiger Cybot", "Eisenpriester", "Wolfsscout-Rudel", "Einsamer Wolf", 
				"", "[IA Experimental] Land Raider Proteus",
				"", "[Forgeworld] Contemptor Dreadnought", "[Forgeworld] Land Raider Prometheus", "[Forgeworld] Siege Dreadnought"};
		String[] Standardeintr�ge = {"", "Graum�hnen-Rudel", "Blutwolf-Rudel"};
		String[] Sturmeintr�ge = {"", "Donnerwolf-Kavallerie", "Sturmwolf-Biker-Rudel", "Himmelswolf-Sturmrudel", "Land Speeder Schwadron", 
				"", "[IA Aeronautica] Caestus Assault Ram",
				"", "[Forgeworld] Lucius Pattern Drop Pod", "[Forgeworld] Land Speeder Tempest Squadron", "[Forgeworld] Storm Eagle"};
		String[] Unterst�tzungeintr�ge = {"", "Wolfsfang-Rudel", "Space Wolves Predator", "Space Wolves Whirlwind", "Space Wolves Vindicator", "Space Wolves Land Raider", "Space Wolves Land Raider Crusader", "Space Wolves Land Raider Redeemer", 
				"", "[IA Experimental] Spartan Assault Tank", "[IA Experimental] Predator Infernus",   
				"", "[Forgeworld] Deathstorm Drop Pod", "[Forgeworld] Whirlwind Hyperios", "[Forgeworld] Land Raider Achilles", "[Forgeworld] Land Raider Helios", "[Forgeworld] Tarantula-Batterie", "", "[Forgeworld] Thunderhawk Transporter", "[Forgeworld] Deimos Pattern Predator Executioner"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};

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
		cnt += 480;

        oc.BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Wolfsgarde-Rudel");
        oc.BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Fenriswolfsrudel");

		nameDerArtDerArmee = "Space Wolves";
		nameDerArtDerArmeeDekliniert = "Space Wolves";
		textAreaUeberschrift = "Space Wolves";

		noAllies.clear();
		
		noAllies.add("CD");
		noAllies.add("CM");
		noAllies.add("RH");
		noAllies.add("SW");
		noAllies.add("TY");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}

}