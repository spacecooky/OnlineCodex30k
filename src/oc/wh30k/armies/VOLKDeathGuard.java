package oc.wh30k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDeathGuard extends BuildaVater {

	public VOLKDeathGuard() {
		reflectionKennung = "DG";
		reflectionKennungAllies ="DG";

		String[] HQeinträge = {"", "Legion Praetor", "Legion Centurion", "  Chaplain", "  Forge lord", "  Legion Champion", "  Librarian", "  Master of signal", "  Moritat", "  Primus medicae", "  Siege breaker", "  Vigilator", "", "Deathshroud Terminator Squad", "Legion Command Squad", "", "Section Leader Crysos Morturg", "Marshall Durak Rask"};
		String[] Eliteeinträge = {"", "Legion Mortis Dreadnought", "Contemptor-Mortis Dreadnought", "Legion Veteran Tactical Squad", "Legion Destroyer Squad", "Legion Terminator Squad", "Techmarine Covenant", "Apothecarion Detachment", "Legion Dreadnought Talon", "Contemptor Dreadnought Talon", "Legion Rapier Weapons Battery"};
		String[] Standardeinträge = {"", "Legion Tactical Squad", "Legion Assault Squad", "Legion Breacher Siege Squad", "Legion Tactical Support Squad", "Legion Reconnaissance Squad"};
		String[] Sturmeinträge = {"", "Tarantula Sentry Gun Battery", "Primaris-Lightning Strike Fighter", "Legion Javelin Attack Speeder Squadron", "Legion Seeker Squad", "Legion Outrider Squad", "Legion Attack Bike Squadron", "Legion Jetbike Sky Hunter Squadron", "Legion Land Speeder Squadron", "Legion Storm Eagle Assault Gunship"};
		String[] Unterstützungeinträge = {"", "Deathstorm Drop Pod", "Legion Whirlwind Scorpius", "Legion Sicaran Battle Tank", "Legion Heavy Support Squad", "Legion Predator Strike Armour Squadron", "Legion Land Raider Battle Squadron", "Legion Artillery Tank Squadron", "Legion Vindicator", "Legion Spartan Assault Tank", "Legion Caestus Assault Ram"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
		String[] LordsofWar = {"", "Mortarion the Reaper", "", "Legion Glaive Super-heavy Special Weapons Tank", "Legion Fellblade Super-heavy Tank", "Legion Typhon Heavy Siege Tank", "Legion Thunderhawk Gunship", "Legion Thunderhawk Transporter", "Legion Cerberus Heavy Tank Destroyer", "Legion Malcador Assault Tank", "Imperial Avenger Strike Fighter"};

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

		nameDerArtDerArmee = "Death Guard";
		nameDerArtDerArmeeDekliniert = "Death Guard";
		textAreaUeberschrift = "Death Guard";
		
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