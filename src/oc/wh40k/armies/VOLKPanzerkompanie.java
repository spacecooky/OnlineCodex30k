package oc.wh40k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKPanzerkompanie extends BuildaVater {

	public VOLKPanzerkompanie() {

		reflectionKennung = "AB";
		reflectionKennungAllies = "AB";

		String[] HQeintr�ge = {"", "Company Command Tank", "Armoured Fist Company Commander", "Atlas Recovery Tank", "Commissar Tank", "", "Steel Dog Alpha", "Grace of the Throne"};
		String[] Eliteeintr�ge = {"", "Squadron Command Tank", "Armoured Fist Platoon Command Squad", "Storm Trooper Squad", "Techpriest Engineseer"};
		String[] Standardeintr�ge = {"", "Tank Squadron", "Armoured Fist Squad"};
		String[] Sturmeintr�ge = {"", "Scout Sentinel Squadron", "Armoured Sentinel Squadron", "Salamander Recon Squadron", "Hellhound Squadron", "Valkyrie Assault Carrier Squadron", "Vendetta Gunship Squadron"};
		String[] Unterst�tzungeintr�ge = {"", "Destroyer Tank Hunter Squadron", "Thunderer Siege Tank Squadron", "Hydra Flak Tank Battery", "Ordnance Battery", "Artillery Strike", "Bombard Battery", "Thunderbolt", "Lightning", "[IA Aeronautica] Vulture"};
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

		nameDerArtDerArmee = BuildaHQ.translate("Panzerkompanie");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Panzerkompanie");
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("Panzerkompanie");

		noAllies.clear();
		noAllies.add("AB");
		noAllies.add("TY");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}

}