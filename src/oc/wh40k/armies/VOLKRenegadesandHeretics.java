package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKRenegadesandHeretics extends BuildaVater {

	public VOLKRenegadesandHeretics() {
		reflectionKennung = "RH";
		reflectionKennungAllies = "RH";

		String[] HQeintr�ge = {"", "Company Command Platoon", "Enforcer", "Rogue Psyker", "Apostate Preacher"};
		String[] Eliteeintr�ge = {"", "Disciples of Xaphan", "Renegade Ogryn Berserkers", "Alpha Legion Squad"};
		String[] Standardeintr�ge = {"", "Renegade Militia Platoon", "Workers Rabble", "Renegade Armoured Fist Squad"};
		String[] Sturmeintr�ge = {"", "Hellhound", "Scout Sentinel Squadron", "Armoured Sentinel Squadron", "Salamander Scout Squadron"};
		String[] Unterst�tzungeintr�ge = {"", "Renegade Militia Heavy Weapon Platoon", "Sentry Gun Battery", "Turret Emplacement", "Renegade Tank", "Close Support Artillery", "Weapon Platform", "Mine Field", "Artillery Strike"};
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
		cnt += CHOOSERGRUPPEN_X_ABSTAND;

		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

		nameDerArtDerArmee = "Renegades and Heretics";
		nameDerArtDerArmeeDekliniert = "Renegades and Heretics";
		textAreaUeberschrift = "Renegades and Heretics";

		noAllies.clear();
		noAllies.add("AS");
		noAllies.add("BA");
		noAllies.add("BT");
		noAllies.add("DA");
		noAllies.add("DE");
		noAllies.add("DK");
		noAllies.add("DM");
		noAllies.add("ED");
		noAllies.add("RH");
		noAllies.add("SF");
		noAllies.add("SM");
		noAllies.add("SW");
		noAllies.add("TL");
		noAllies.add("TY");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}
}