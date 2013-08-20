package oc.wh30k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKOrdoReductor extends BuildaVater {

	public VOLKOrdoReductor() {
		reflectionKennung = "OR";
		reflectionKennungAllies ="OR";

		String[] HQeintr�ge = {"", "Magos Reductor Calleb Decima"};
		String[] Eliteeintr�ge = {"", "Techmarine Covenant"};
		String[] Standardeintr�ge = {"", "Mechanicum Thallax Cohort"};
		String[] Sturmeintr�ge = {"", "Imperial Avenger Strike Fighter"};
		String[] Unterst�tzungeintr�ge = {"", "Legion Artillery Tank Squadron"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
		String[] LordsofWar = {"", "Warhound Scout Titan", "Reaver Battle Titan"};

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

		nameDerArtDerArmee = "Ordo Reductor";
		nameDerArtDerArmeeDekliniert = "Ordo Reductor";
		textAreaUeberschrift = "Ordo Reductor";
		
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