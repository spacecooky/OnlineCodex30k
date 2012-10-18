package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKBlackTemplars extends BuildaVater {

	public VOLKBlackTemplars() {
		reflectionKennung = "BT";
		reflectionKennungAllies = "BT";

		String[] HQeinträge = {"", "Kommandant", "Champion des Imperators", "Ordenspriester", "Schwertbrüder-Terminator-Kommandotrupp", "Kommandotrupp", "", "Großmarschall Helbrecht", "Ordenspriester Grimaldus, Held von Askalon", "", "[Forgeworld] Damocles Rhino"};
		String[] Eliteeinträge = {"", "Schwertbrüder-Terminatortrupp", "Schwertbrüder-Terminator-Sturmtrupp", "Schwertbrüder", "Cybot", "Techmarine", 
				"", "[IA Experimental] Land Raider Proteus",
				"", "[Forgeworld] Contemptor Dreadnought", "[Forgeworld] Siege Dreadnought", "[Forgeworld] Chaplain Dreadnought", "[Forgeworld] Land Raider Prometheus"};
		String[] Standardeinträge = {"", "Taktischer Trupp"};
		String[] Sturmeinträge = {"", "Sturmtrupp", "Landspeeder Schwadron", "Bikeschwadron", "Trikeschwadron", 
				"", "[IA Aeronautica] Caestus Assault Ram",
				"", "[Forgeworld] Lucius Pattern Drop Pod", "[Forgeworld] Land Speeder Tempest Squadron", "[Forgeworld] Storm Eagle"};
		String[] Unterstützungeinträge = {"", "Predator Annihilator", "Predator Destructor", "Vindicator", "Land Raider", "Land Raider Crusader", 
				"", "[IA Experimental] Spartan Assault Tank", "[IA Experimental] RapierCarrierBattery","[IA Experimental] Predator Infernus",
				"", "[IA Aeronautica] Contemptor Mortis Pattern Dreadnought",
				"", "[Forgeworld] Deathstorm Drop Pod", "[Forgeworld] Whirlwind Hyperios", "[Forgeworld] Land Raider Achilles", "[Forgeworld] Land Raider Helios", "[Forgeworld] Tarantula-Batterie", "", "[Forgeworld] Thunderhawk Transporter", "[Forgeworld] Deimos Pattern Predator Executioner"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};


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
		cnt += 480;

		nameDerArtDerArmee = "Black Templars";
		nameDerArtDerArmeeDekliniert = "Black Templars";
		textAreaUeberschrift = "Meine Black Templars";

		noAllies.clear();
		noAllies.add("BT");
		noAllies.add("CD");
		noAllies.add("CM");
		noAllies.add("OR");
		noAllies.add("TY");
		noAllies.add("RH");
		noAllies.add("DM");
		noAllies.add("TL");
		
		complete();
	}

	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}
