package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKElysianDropTroopIA8 extends BuildaVater {

	public VOLKElysianDropTroopIA8() {
		reflectionKennung = "ED";
		reflectionKennungAllies = "ED";

		String[] HQeintr�ge = {"", "Company Command Squad", "Lord Commissar", "Long Range Ground Scanner"};
		String[] Eliteeintr�ge = {"", "Storm Trooper Squad", "Drop Sentinel Squadron"};
		String[] Standardeintr�ge = {"", "Drop Infantry Platoon", "Veteran Squad"};
		String[] Sturmeintr�ge = {"", "Vendetta Gunship Squadron", "Tauros Squadron", "Tauros Venator Squadron", "Cyclops Remote Control Demolition Vehicle"};
		String[] Unterst�tzungeintr�ge = {"", "Vulture Gunship", "Sentry Gun Battery", "Valkyrie Sky Talon Transport", "Thunderbolt", "Lightning"};
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

		nameDerArtDerArmee = "Elysian Drop Troop";
		nameDerArtDerArmeeDekliniert = "Elysian Drop Troop";
		textAreaUeberschrift = "Elysian Drop Troop";

		noAllies.clear();
		noAllies.add("ED");
		noAllies.add("TY");
		
		complete();
	}

	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}

}
