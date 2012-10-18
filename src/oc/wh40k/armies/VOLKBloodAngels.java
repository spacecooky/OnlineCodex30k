package oc.wh40k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKBloodAngels extends BuildaVater {

	public VOLKBloodAngels() {
		reflectionKennung = "BA";
		reflectionKennungAllies ="BA";

		String[] HQeintr�ge = {"", "Commander Dante", "Ordensmeister Gabriel Seth", "Astorath der Unerbittliche", "Der Sanguinor", "Mephiston", "Captain Tycho", "", "Captain", "Scriptor", "Reclusiarch", "Ehrengarde", "", "[Forgeworld] Damocles Rhino"};
		String[] Eliteeintr�ge = {"", "Ordenspriester", "Furioso-Cybot", "Furioso-Scriptor", "Terminator-Trupp", "Terminator-Sturmtrupp", "Techmarine", "Protektorgarde", "Sanguiniuspriester", "Bruder Corbulo", 
				"", "[IA Experimental] Land Raider Proteus",
				"", "[Forgeworld] Contemptor Dreadnought", "[Forgeworld] Land Raider Prometheus", "[Forgeworld] Siege Dreadnought"};
		String[] Standardeintr�ge = {"", "Taktischer Trupp", "Todeskompanie", "Todeskompanie-Cybot", "Scouttrupp", "Sturmtrupp"};
		String[] Sturmeintr�ge = {"", "Expugnatorgarde", "Land Speeder Schwadron", "Baal-Predator", "Trike-Schwadron", "Bike-Schwadron", "Scoutbike-Schwadron", 
				"", "[IA Aeronautica] Caestus Assault Ram",
				"", "[Forgeworld] Land Speeder Tempest Squadron"};
		String[] Unterst�tzungeintr�ge = {"", "Cybot", "Stormraven-Landungsschiff", "Predator", "Devastortrupp", "Vindicator", "Whirlwind",
				"", "[IA Experimental] Spartan Assault Tank", "[IA Experimental] RapierCarrierBattery",
				"", "[Forgeworld] Deathstorm Drop Pod", "[Forgeworld] Whirlwind Hyperios", "[Forgeworld] Land Raider Helios", "[Forgeworld] Tarantula-Batterie", "", "[Forgeworld] Thunderhawk Transporter", "[Forgeworld] Deimos Pattern Predator Executioner"};
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

		nameDerArtDerArmee = "Blood Angels";
		nameDerArtDerArmeeDekliniert = "Blood Angels";
		textAreaUeberschrift = "Blood Angels";
		
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Sanguinische Garde");

		noAllies.clear();
		noAllies.add("BA");
		noAllies.add("CD");
		noAllies.add("CM");
		noAllies.add("DE");
		noAllies.add("OR");
		noAllies.add("TY");
		noAllies.add("RH");
		noAllies.add("DM");
		noAllies.add("TL");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}
}