package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKKriegerdesChaos extends BuildaVater {

	public VOLKKriegerdesChaos() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "CK";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Chaosgeneral"), BuildaHQ.translate("Meisterzauberer"), BuildaHQ.translate("Dämonenprinz"), "", BuildaHQ.translate("Archaon der Ewig Auserwählte"), BuildaHQ.translate("Galrauch der Große Drache"), BuildaHQ.translate("Prinz Sigvald der Prachtvolle"), BuildaHQ.translate("Kholek Sonnenfresser"),  BuildaHQ.translate("Valkia die Blutige"),  BuildaHQ.translate("Vilitch der Verfluchte")};
		String[] Helden = {"", BuildaHQ.translate("Chaoszauberer"), BuildaHQ.translate("Erhabener Held"), "", BuildaHQ.translate("Doktor Festus"), BuildaHQ.translate("Throgg König der Trolle"), BuildaHQ.translate("Wulfrik der Wanderer")};
		String[] Kern = {"", BuildaHQ.translate("Chaoskrieger"), BuildaHQ.translate("Chaosbarbaren"), BuildaHQ.translate("Chaoshunde"), BuildaHQ.translate("Chaosbarbarenreiter")};
		String[] Elite = {"", BuildaHQ.translate("Auserkorene"), BuildaHQ.translate("Verstossene"), BuildaHQ.translate("Chaosstreitwagen"), BuildaHQ.translate("Chaosoger"), BuildaHQ.translate("Drachenoger"), BuildaHQ.translate("Chaostrolle"), BuildaHQ.translate("Chaosritter")};
		String[] Selten = {"", BuildaHQ.translate("Chaosbrut"), BuildaHQ.translate("Scyla Anfingrim"), BuildaHQ.translate("Kriegsschrein des Chaos"), BuildaHQ.translate("Todbringer"), BuildaHQ.translate("Drachenoger-Shaggoth"), BuildaHQ.translate("Chaosriese")};

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

		nameDerArtDerArmee = BuildaHQ.translate("Krieger des Chaos");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Krieger des Chaos");
		textAreaUeberschrift = BuildaHQ.translate("Krieger des Chaos");

		complete();
	}

	@Override
	protected void finalize() {
		 
	}

}