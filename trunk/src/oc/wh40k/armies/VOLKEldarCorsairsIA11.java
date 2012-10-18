package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKEldarCorsairsIA11 extends BuildaVater {

	public VOLKEldarCorsairsIA11() {
		reflectionKennung = "EC";
		reflectionKennungAllies = "EC";

		String[] HQeinträge = {"", "Corsair Prince", "Corsair Void Dreamer", "", "Corsair Blade Sworn Retinue"};
		String[] Standardeinträge = {"", "Corsair Squad", "Corsair Jetbike Squadron", "Wasp Assault Walker Squadron"};
		String[] Eliteeinträge = {"", "Corsair Voidstorm Squad", "Harlequin Troupe", "Shadow Spectres", "", "Skorpionkrieger", "Feuerdrachen", "Phantomdroiden", "Banshees", "Ranger", "", "Speere des Khaine", "Warpspinnen", "Kriegsfalken", "Vyperschwadron", "", "Kabalenkrieger"};
		String[] Sturmeinträge = {"", "Corsair Hornet Squadron", "Nightwing Interceptor", "Corsair Night Spinner"};
		String[] Unterstützungeinträge = {"", "Corsair Warp Hunter", "Corsair Phoenix Bomber", "Corsair Fire Storm"};
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
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}