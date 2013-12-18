package oc.wh30k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKLegioCybernetica extends BuildaVater {

	public VOLKLegioCybernetica() {
		reflectionKennung = "LC";
		reflectionKennungAllies ="LC";

		String[] HQeinträge = {"", "Archmagos", "Magos Dominus"};
		String[] Eliteeinträge = {"", "Enginseer Auxillia", "Myrmidon Secutors"};
		String[] Standardeinträge = {"", "Mechanicum Thallax Cohort", "Legio Cybernetica Castellax Class Battle-Automata", "Tech-thrall Adsecularis"};
		String[] Sturmeinträge = {"", "Primaris-Lightning Strike Fighter", "Imperial Avenger Strike Fighter", "Legion Storm Eagle Assault Gunship", "Tarantula Sentry Gun Battery", "Mechanicum Thallax Cohort Ferrox"};
		String[] Unterstützungeinträge = {"", "Myrmidon Destructors", "Mechanicum Thallax Cohort Icarian"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
		String[] LordsofWar = {""};

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
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}
}