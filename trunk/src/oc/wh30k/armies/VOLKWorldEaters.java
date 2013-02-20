package oc.wh30k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKWorldEaters extends BuildaVater {

	public VOLKWorldEaters() {
		reflectionKennung = "WE";
		reflectionKennungAllies ="WE";

		String[] HQeintr�ge = {"", "Legion Praetor", "Legion Centurion", "  Chaplain", "  Forge lord", "  Legion Champion", "  Librarian", "  Master of signal", "  Moritat", "  Primus medicae", "  Siege breaker", "  Vigilator", "", "Legion Command Squad", "", "Centurion Shabran Darr"};
		String[] Eliteeintr�ge = {"", "Legion Veteran Tactical Squad", "Legion Destroyer Squad", "Legion Terminator Squad", "Techmarine Covenant", "Apothecarion Detachment", "Legion Dreadnought Talon", "Contemptor Dreadnought Talon", "Legion Rapier Weapons Battery", "", "Rampager Squad"};
		String[] Standardeintr�ge = {"", "Legion Tactical Squad", "Legion Assault Squad", "Legion Breacher Siege Squad", "Legion Tactical Support Squad", "Legion Reconnaissance Squad"};
		String[] Sturmeintr�ge = {"", "Legion Seeker Squad", "Legion Outrider Squad", "Legion Attack Bike Squadron", "Legion Jetbike Sky Hunter Squadron", "Legion Land Speeder Squadron", "Legion Storm Eagle Assault Gunship", "", "Rampager Squad"};
		String[] Unterst�tzungeintr�ge = {"", "Legion Heavy Support Squad", "Legion Predator Strike Armour Squadron", "Legion Land Raider Battle Squadron", "Legion Artillery Tank Squadron", "Legion Vindicator", "Legion Spartan Assault Tank", "Legion Caestus Assault Ram"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
		String[] LordsofWar = {"", "The Primarch Angron", "", "Legion Fellblade Super-heavy Tank", "Legion Typhon Heavy Siege Tank", "Legion Thunderhawk Gunship", "Legion Thunderhawk Transporter", "Legion Cerberus Heavy Tank Destroyer", "Legion Malcador Assault Tank"};

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
		adden(new ChooserGruppe("FO", cnt, 0, 6, Befestigungen));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, LordsofWar));
		cnt += 480;

		nameDerArtDerArmee = "World Eaters";
		nameDerArtDerArmeeDekliniert = "World Eaters";
		textAreaUeberschrift = "World Eaters";
		
		/*
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
		*/
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}
}