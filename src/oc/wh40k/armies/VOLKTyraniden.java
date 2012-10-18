package oc.wh40k.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKTyraniden extends BuildaVater {

	public VOLKTyraniden() {

		reflectionKennung = "TY";
		reflectionKennungAllies = "TY";

		String[] HQeinträge = {"", "Schwarmtyrant", "Tyrantenwache", "Tervigon", "Alphakrieger", "", "Der Schwarmherrscher", "Der Parasit von Mortrex", "", "[Forgeworld] Malanthrope"};
		String[] Eliteeinträge = {"", "Schwarmwachen", "Liktoren", "Toxotrophen", "Zoantrophen", "Pyrovoren", "Ymgarl-Symbionten", "", "Todeshetzer", "Die Nemesis von Malan'Tai"};
		String[] Standardeinträge = {"", "Tyranidenkrieger", "Symbionten", "Termaganten", "Hormaganten", "Absorberschwärme"};
		String[] Sturmeinträge = {"", "Geflügelte Tyranidenkrieger", "Venatoren", "Fliegende Absorberschwärme", "Gargoylen", "Harpyie", "Sporenminen", "", "[Forgeworld] Meiotic Spores"};
		String[] Unterstützungeinträge = {"", "Carnifex-Rotte", "Biovoren", "Trygon", "Morgon", "Tyrannofex", "", "Einauge", "", "[Forgeworld] Scythed Hierodule", "[Forgeworld] Stone-Crusher Carnifex"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
		String[] ApoEinheiten = {"", "[IA Aeronautica] Harridan",
				                 "", "Hierophant Biotitan"};

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
		if(oc.OnlineCodex.getInstance().isApo()) cnt += CHOOSERGRUPPEN_X_ABSTAND;
		if(oc.OnlineCodex.getInstance().isApo()) adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
		cnt += 480;

		nameDerArtDerArmee = BuildaHQ.translate("Tyraniden");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Tyraniden");
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("Tyraniden");

		noAllies.clear();
		noAllies.add("AB");
		noAllies.add("AS");
		noAllies.add("BA");
		noAllies.add("BT");
		noAllies.add("CD");
		noAllies.add("CM");
		noAllies.add("DA");
		noAllies.add("DE");
		noAllies.add("DK");
		noAllies.add("DM");
		noAllies.add("EC");
		noAllies.add("ED");
		noAllies.add("EL");
		noAllies.add("GK");
		noAllies.add("IG");
		noAllies.add("NE");
		noAllies.add("OR");
		noAllies.add("RH");
		noAllies.add("SF");
		noAllies.add("SM");
		noAllies.add("SW");
		noAllies.add("TA");
		noAllies.add("TL");
		noAllies.add("TY");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}