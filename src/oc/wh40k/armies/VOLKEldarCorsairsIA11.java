package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKEldarCorsairsIA11 extends BuildaVater {

	public VOLKEldarCorsairsIA11() {
		reflectionKennung = "EC";
		reflectionKennungAllies = "EC";

		String[] HQeintr�ge = {"", "Corsair Prince", "Corsair Void Dreamer", "", "Corsair Blade Sworn Retinue"};
		String[] Standardeintr�ge = {"", "Corsair Squad", "Corsair Jetbike Squadron", "Wasp Assault Walker Squadron"};
		String[] Eliteeintr�ge = {"", "Corsair Voidstorm Squad", "Harlequin Troupe", "Shadow Spectres", "", "Skorpionkrieger", "Feuerdrachen", "Phantomdroiden", "Banshees", "Ranger", "", "Speere des Khaine", "Warpspinnen", "Kriegsfalken", "Vyperschwadron", "", "Kabalenkrieger"};
		String[] Sturmeintr�ge = {"", "Corsair Hornet Squadron", "Nightwing Interceptor", "Corsair Night Spinner"};
		String[] Unterst�tzungeintr�ge = {"", "Corsair Warp Hunter", "Corsair Phoenix Bomber", "Corsair Fire Storm"};
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

		nameDerArtDerArmee = "Eldar Corsairs";
		nameDerArtDerArmeeDekliniert = "Eldar Corsairs";
		textAreaUeberschrift = "Eldar Corsairs Armee";

		noAllies.clear();
		
		noAllies.add("EC");
		noAllies.add("CD");
		noAllies.add("CM");
		noAllies.add("NE");
		noAllies.add("RH");
		noAllies.add("TL");
		noAllies.add("TY");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}

}