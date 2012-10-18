package oc.wh40k.armies;



import oc.BuildaHQ;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKGreyKnights extends BuildaVater {

	public VOLKGreyKnights() {

		reflectionKennung = "GK";
		reflectionKennungAllies = "GK";

		String[] HQeinträge = {"", "Grossmeister der Grey Knights", "Bruder-Captain der Grey Knights", "Seneschall der Bruderschaft", "Scriptor", "", "Inquisitor des Ordo Malleus", "Inquisitor des Ordo Hereticus", "Inquisitor des Ordo Xenos", "", "Hochmeister Kaldor Draigo", "Grossmeister Mordrak", "Bruder-Captain Stern", "Kastellan Crowe", "", "Inquisitor Coteaz", "Inquisitor Karamasov", "Inquisitorin Valeria", "", "[Forgeworld] Inquisitor Hector Rex", "[Forgeworld] Inquisitor Solomon Lok"};
		String[] Eliteeinträge = {"", "Techmarine", "Ehrwürdiger Cybot", "Callidus-Assassine", "Eversor-Assassine", "Culexus-Assassine", "Vindicare-Assassine"};
		String[] Standardeinträge = {"", "Terminatortrupp", "Angriffstrupp"};
		String[] Sturmeinträge = {"", "Stormraven-Landungsschiff", "Abfangtrupp"};
		String[] Unterstützungeinträge = {"", "Purgatortrupp", "Cybot", "Nemesis-Ritter", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"};
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

		nameDerArtDerArmee = "Grey Knights";
		nameDerArtDerArmeeDekliniert = "Grey Knights";
		textAreaUeberschrift = "Grey Knights";

        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Purificator-Trupp");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Paladin-Trupp");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Gefolge des Inquisitors");

        noAllies.clear();
		
        noAllies.add("GK");
		noAllies.add("CD");
		noAllies.add("CM");
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