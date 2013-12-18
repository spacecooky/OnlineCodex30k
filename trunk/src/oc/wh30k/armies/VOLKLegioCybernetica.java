package oc.wh30k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKLegioCybernetica extends BuildaVater {

	public VOLKLegioCybernetica() {
		reflectionKennung = "LC";
		reflectionKennungAllies ="LC";

		String[] HQeintr�ge = {"", "Archmagos", "Magos Dominus"};
		String[] Eliteeintr�ge = {"", "Enginseer Auxillia", "Myrmidon Secutors"};
		String[] Standardeintr�ge = {"", "Mechanicum Thallax Cohort", "Legio Cybernetica Castellax Class Battle-Automata", "Tech-thrall Adsecularis"};
		String[] Sturmeintr�ge = {"", "Primaris-Lightning Strike Fighter", "Imperial Avenger Strike Fighter", "Legion Storm Eagle Assault Gunship", "Tarantula Sentry Gun Battery", "Mechanicum Thallax Cohort Ferrox"};
		String[] Unterst�tzungeintr�ge = {"", "Myrmidon Destructors", "Mechanicum Thallax Cohort Icarian"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
		String[] LordsofWar = {""};

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

		nameDerArtDerArmee = "Legio Cybernetica";
		nameDerArtDerArmeeDekliniert = "Legio Cybernetica";
		textAreaUeberschrift = "Legio Cybernetica";
		
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