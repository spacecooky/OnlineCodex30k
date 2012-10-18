package oc.whfb.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDaemonendesChaos extends BuildaVater {
	
	public VOLKDaemonendesChaos() {
		reflectionKennung = "DOC";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Blutdämon"), BuildaHQ.translate("Herrscher des Wandels"), BuildaHQ.translate("Großer Verpester"), BuildaHQ.translate("Hüter der Geheimnisse"), " ", BuildaHQ.translate("Dämonenprinz"), BuildaHQ.translate("Khorne Dämonenprinz"), BuildaHQ.translate("Tzeentch Dämonenprinz"), BuildaHQ.translate("Nurgle Dämonenprinz"), BuildaHQ.translate("Slaanesh Dämonenprinz"), " ", BuildaHQ.translate("Skarbrand"), BuildaHQ.translate("Kairos Schicksalsweber") , BuildaHQ.translate("Kugath Seuchenvater")};
		String[] Helden = {"", BuildaHQ.translate("Herold des Khorne"), BuildaHQ.translate("Herold des Tzeentch"), BuildaHQ.translate("Herold des Nurgle"), BuildaHQ.translate("Herold des Slaanesh"), "", BuildaHQ.translate("Schädelsammler"), BuildaHQ.translate("Die blauen Gelehrten"), BuildaHQ.translate("Epidemus"), BuildaHQ.translate("Die Maske des Slaanesh")};
		String[] Kern = {"", BuildaHQ.translate("Zerfleischer"), BuildaHQ.translate("Rosa Horrors"), BuildaHQ.translate("Seuchenhüter"), BuildaHQ.translate("Dämonetten"), BuildaHQ.translate("Chaosgargoyle")};
		String[] Elite = {"", BuildaHQ.translate("Bluthunde"), BuildaHQ.translate("Kreischer"), BuildaHQ.translate("Nurglings"), BuildaHQ.translate("Jägerinnen")};
		String[] Selten = {"", BuildaHQ.translate("Zerschmetterer"), BuildaHQ.translate("Feuerdämonen"), BuildaHQ.translate("Schleimbestien"), BuildaHQ.translate("Slaaneshbestien")};

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

		nameDerArtDerArmee = BuildaHQ.translate("Dämonen des Chaos");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Dämonen des Chaos");
		textAreaUeberschrift = BuildaHQ.translate("Dämonen des Chaos");
		
		complete();
	}
}