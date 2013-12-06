package oc.wh30k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKSonsofHorus extends BuildaVater {

	public VOLKSonsofHorus() {
		reflectionKennung = "SH";
		reflectionKennungAllies ="SH";

		String[] HQeinträge = {"", "Legion Praetor", "Legion Centurion", "  Chaplain", "  Forge lord", "  Legion Champion", "  Librarian", "  Master of signal", "  Moritat", "  Primus medicae", "  Siege breaker", "  Vigilator", "", "Legion Command Squad", "Justaerin Command Squad", "", "Ezekyle Abaddon", "Garviel Loken", ""};
		String[] Eliteeinträge = {"", "Legion Mortis Dreadnought", "Contemptor-Mortis Dreadnought", "Legion Destroyer Squad", "Legion Terminator Squad", "Techmarine Covenant", "Apothecarion Detachment", "Legion Dreadnought Talon", "Contemptor Dreadnought Talon", "Legion Rapier Weapons Battery", ""};
		String[] Standardeinträge = {"", "Legion Tactical Squad", "Legion Assault Squad", "Legion Breacher Siege Squad", "Legion Tactical Support Squad", "Legion Reconnaissance Squad"};
		String[] Sturmeinträge = {"", "Tarantula Sentry Gun Battery", "Primaris-Lightning Strike Fighter", "Legion Javelin Attack Speeder Squadron", "Legion Seeker Squad", "Legion Outrider Squad", "Legion Attack Bike Squadron", "Legion Jetbike Sky Hunter Squadron", "Legion Land Speeder Squadron", "Legion Storm Eagle Assault Gunship"};
		String[] Unterstützungeinträge = {"", "Legion Whirlwind Scorpius", "Legion Sicaran Battle Tank", "Legion Heavy Support Squad", "Legion Predator Strike Armour Squadron", "Legion Land Raider Battle Squadron", "Legion Artillery Tank Squadron", "Legion Vindicator", "Legion Spartan Assault Tank", "Legion Caestus Assault Ram"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
		String[] LordsofWar = {"", "Horus the Warmaster", "", "Legion Glaive Super-heavy Special Weapons Tank", "Legion Fellblade Super-heavy Tank", "Legion Typhon Heavy Siege Tank", "Legion Thunderhawk Gunship", "Legion Thunderhawk Transporter", "Legion Cerberus Heavy Tank Destroyer", "Legion Malcador Assault Tank", "Imperial Avenger Strike Fighter"};

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
		adden(new ChooserGruppe("FO", cnt, 0, 6, Befestigungen));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, LordsofWar));
		cnt += 480;
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Justaerin Terminator Squad");
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Deathstorm Drop Pod");

		nameDerArtDerArmee = "Sons of Horus";
		nameDerArtDerArmeeDekliniert = "Sons of Horus";
		textAreaUeberschrift = "Sons of Horus";
		
		/*
		noAllies.clear();
		//noAllies.add("BA");
		*/
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}
}