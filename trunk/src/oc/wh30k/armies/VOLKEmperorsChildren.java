package oc.wh30k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKEmperorsChildren extends BuildaVater {

	public VOLKEmperorsChildren() {
		reflectionKennung = "EC";
		reflectionKennungAllies ="EC";

		String[] HQeintr�ge = {"", "Legion Praetor", "Legion Centurion", "  Chaplain", "  Forge lord", "  Legion Champion", "  Librarian", "  Master of signal", "  Moritat", "  Primus medicae", "  Siege breaker", "  Vigilator", "", "Legion Command Squad", "", "Captain Saul Tarvitz", ""};
		String[] Eliteeintr�ge = {"", "Legion Mortis Dreadnought", "Contemptor-Mortis Dreadnought", "Legion Veteran Tactical Squad", "Legion Destroyer Squad", "Legion Terminator Squad", "Techmarine Covenant", "Apothecarion Detachment", "Legion Dreadnought Talon", "Contemptor Dreadnought Talon", "Legion Rapier Weapons Battery", "", "Rylanor the Unyielding", "Palatine Blade Squad"};
		String[] Standardeintr�ge = {"", "Legion Tactical Squad", "Legion Assault Squad", "Legion Breacher Siege Squad", "Legion Tactical Support Squad", "Legion Reconnaissance Squad"};
		String[] Sturmeintr�ge = {"", "Tarantula Sentry Gun Battery", "Primaris-Lightning Strike Fighter", "Legion Javelin Attack Speeder Squadron", "Legion Seeker Squad", "Legion Outrider Squad", "Legion Attack Bike Squadron", "Legion Jetbike Sky Hunter Squadron", "Legion Land Speeder Squadron", "Legion Storm Eagle Assault Gunship"};
		String[] Unterst�tzungeintr�ge = {"", "Legion Whirlwind Scorpius", "Legion Sicaran Battle Tank", "Legion Heavy Support Squad", "Legion Predator Strike Armour Squadron", "Legion Land Raider Battle Squadron", "Legion Artillery Tank Squadron", "Legion Vindicator", "Legion Spartan Assault Tank", "Legion Caestus Assault Ram"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
		String[] LordsofWar = {"", "Fulgrim the Illuminator", "", "Legion Glaive Super-heavy Special Weapons Tank", "Legion Fellblade Super-heavy Tank", "Legion Typhon Heavy Siege Tank", "Legion Thunderhawk Gunship", "Legion Thunderhawk Transporter", "Legion Cerberus Heavy Tank Destroyer", "Legion Malcador Assault Tank", "Imperial Avenger Strike Fighter"};

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
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Maru Skara");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Terminator Squad");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Deathstorm Drop Pod");

		nameDerArtDerArmee = "Emperor's Children";
		nameDerArtDerArmeeDekliniert = "Emperor's Children";
		textAreaUeberschrift = "Emperor's Children";
		
		/*
		noAllies.clear();
		//noAllies.add("BA");
		*/
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}
}