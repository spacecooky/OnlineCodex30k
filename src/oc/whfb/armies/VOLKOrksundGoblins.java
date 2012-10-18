package oc.whfb.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKOrksundGoblins extends BuildaVater {

	public VOLKOrksundGoblins() {
		reflectionKennung = "OR";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Ork-Waaaghboss"), BuildaHQ.translate("Ork-Meisterschamane"), BuildaHQ.translate("Goblin-Waaaghboss"), BuildaHQ.translate("Goblin-Meisterschamane"), "", BuildaHQ.translate("Gorbad Eisenfaust"), BuildaHQ.translate("Azhag der Vernichter"), BuildaHQ.translate("Grimgork Eisenpelz"), BuildaHQ.translate("Grom der Fettsack"), BuildaHQ.translate("Skarsnik") , BuildaHQ.translate("Wurrzag, da Prophet des gross'n Grün")};
		String[] Helden = {"", BuildaHQ.translate("Ork-Gargboss"), BuildaHQ.translate("Orkschamane"), BuildaHQ.translate("Goblin-Gargboss"), BuildaHQ.translate("Goblinschamane"), "", BuildaHQ.translate("Gittila da Jäga"), BuildaHQ.translate("Snagla Madenspucka")};
		String[] Kern = {"", BuildaHQ.translate("Orkkrieger"), BuildaHQ.translate("Orkbogenschützen"), BuildaHQ.translate("Wildorks"), BuildaHQ.translate("Goblins"), BuildaHQ.translate("Goblin-Wolfsreiter"), BuildaHQ.translate("Waldgoblin-Spinnenreiter"), BuildaHQ.translate("Nachtgoblins")};
		String[] Elite = {"", BuildaHQ.translate("Schwarzorks"), BuildaHQ.translate("Ork-Wildschweinreiter"), BuildaHQ.translate("Wildork-Wildschweinreiter"), BuildaHQ.translate("Ork-Wildschweinstreitwagen"), BuildaHQ.translate("Goblin-Wolfsstreitwagen"), BuildaHQ.translate("Goblin-Speerschleuda"), BuildaHQ.translate("Nachtgoblin-Squighoppaz"), BuildaHQ.translate("Nachtgoblin-Squigherde"), BuildaHQ.translate("Snotlings"), BuildaHQ.translate("Trolle")};
		String[] Selten = {"", BuildaHQ.translate("Goblin-Steinschleuda"), BuildaHQ.translate("Goblin-Kamikazekatapult"), BuildaHQ.translate("Snotling-Kurbelwagen"), BuildaHQ.translate("Arachnarok-Spinne"), BuildaHQ.translate("Ketten-Squigs"), BuildaHQ.translate("Steintrolle"),  BuildaHQ.translate("Flusstrolle"), BuildaHQ.translate("Riese")};

		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, Kommandanten));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 2, Helden));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 3, Kern));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Elite));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Selten));
		cnt += 480;

		nameDerArtDerArmee = BuildaHQ.translate("Orks und Goblins");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Orks und Goblins");
		textAreaUeberschrift = BuildaHQ.translate("Orks und Goblins");

		complete();
	}

	@Override
	protected void finalize() {
		 
	}

}