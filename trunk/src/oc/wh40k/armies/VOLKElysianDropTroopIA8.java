package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKElysianDropTroopIA8 extends BuildaVater {

	public VOLKElysianDropTroopIA8() {
		reflectionKennung = "ED";
		reflectionKennungAllies = "ED";

		String[] HQeinträge = {"", "Company Command Squad", "Lord Commissar", "Long Range Ground Scanner"};
		String[] Eliteeinträge = {"", "Storm Trooper Squad", "Drop Sentinel Squadron"};
		String[] Standardeinträge = {"", "Drop Infantry Platoon", "Veteran Squad"};
		String[] Sturmeinträge = {"", "Vendetta Gunship Squadron", "Tauros Squadron", "Tauros Venator Squadron", "Cyclops Remote Control Demolition Vehicle"};
		String[] Unterstützungeinträge = {"", "Vulture Gunship", "Sentry Gun Battery", "Valkyrie Sky Talon Transport", "Thunderbolt", "Lightning"};
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

		nameDerArtDerArmee = "Elysian Drop Troop";
		nameDerArtDerArmeeDekliniert = "Elysian Drop Troop";
		textAreaUeberschrift = "Elysian Drop Troop";

		noAllies.clear();
		noAllies.add("ED");
		noAllies.add("TY");
		
		complete();
	}

	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}
