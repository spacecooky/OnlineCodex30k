package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDunkelelfen extends BuildaVater {

	public VOLKDunkelelfen() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "DE";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Hochgeborener"), BuildaHQ.translate("Erzzauberin"), "", BuildaHQ.translate("Malekith"), BuildaHQ.translate("Morathi"), BuildaHQ.translate("Hellebron")};
		String[] Helden = {"", BuildaHQ.translate("Adliger"), BuildaHQ.translate("Todeshexe"), BuildaHQ.translate("Dunkelelfenzauberin"), BuildaHQ.translate("Assassine"), "", BuildaHQ.translate("Malus Darkblade"), BuildaHQ.translate("Schattenklinge"), BuildaHQ.translate("Lokhir Teufelsherz")};
		String[] Kern = {"", BuildaHQ.translate("Dunkelelfenkrieger"), BuildaHQ.translate("Repetierarmbrustschützen"), BuildaHQ.translate("Schwarze Korsaren"),  BuildaHQ.translate("Schwarze Reiter"), BuildaHQ.translate("Harpien")};
		String[] Elite = {"", BuildaHQ.translate("Hexenkriegerinnen"), BuildaHQ.translate("Schatten"), BuildaHQ.translate("Henker"), BuildaHQ.translate("Echsenritter"),  BuildaHQ.translate("Echsenstreitwagen"),  BuildaHQ.translate("Schwarze Garde von Naggarond")};
		String[] Selten = {"", BuildaHQ.translate("Repetier-Speerschleuder"), BuildaHQ.translate("Kriegshydra")};

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

		nameDerArtDerArmee = BuildaHQ.translate("Dunkelelfen");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Dunkelelfen");
		textAreaUeberschrift = BuildaHQ.translate("Dunkelelfen");

		complete();
	}
}