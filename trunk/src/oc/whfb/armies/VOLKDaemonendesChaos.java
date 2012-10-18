package oc.whfb.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDaemonendesChaos extends BuildaVater {
	
	public VOLKDaemonendesChaos() {
		reflectionKennung = "DOC";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Blutd�mon"), BuildaHQ.translate("Herrscher des Wandels"), BuildaHQ.translate("Gro�er Verpester"), BuildaHQ.translate("H�ter der Geheimnisse"), " ", BuildaHQ.translate("D�monenprinz"), BuildaHQ.translate("Khorne D�monenprinz"), BuildaHQ.translate("Tzeentch D�monenprinz"), BuildaHQ.translate("Nurgle D�monenprinz"), BuildaHQ.translate("Slaanesh D�monenprinz"), " ", BuildaHQ.translate("Skarbrand"), BuildaHQ.translate("Kairos Schicksalsweber") , BuildaHQ.translate("Kugath Seuchenvater")};
		String[] Helden = {"", BuildaHQ.translate("Herold des Khorne"), BuildaHQ.translate("Herold des Tzeentch"), BuildaHQ.translate("Herold des Nurgle"), BuildaHQ.translate("Herold des Slaanesh"), "", BuildaHQ.translate("Sch�delsammler"), BuildaHQ.translate("Die blauen Gelehrten"), BuildaHQ.translate("Epidemus"), BuildaHQ.translate("Die Maske des Slaanesh")};
		String[] Kern = {"", BuildaHQ.translate("Zerfleischer"), BuildaHQ.translate("Rosa Horrors"), BuildaHQ.translate("Seuchenh�ter"), BuildaHQ.translate("D�monetten"), BuildaHQ.translate("Chaosgargoyle")};
		String[] Elite = {"", BuildaHQ.translate("Bluthunde"), BuildaHQ.translate("Kreischer"), BuildaHQ.translate("Nurglings"), BuildaHQ.translate("J�gerinnen")};
		String[] Selten = {"", BuildaHQ.translate("Zerschmetterer"), BuildaHQ.translate("Feuerd�monen"), BuildaHQ.translate("Schleimbestien"), BuildaHQ.translate("Slaaneshbestien")};

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

		nameDerArtDerArmee = BuildaHQ.translate("D�monen des Chaos");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("D�monen des Chaos");
		textAreaUeberschrift = BuildaHQ.translate("D�monen des Chaos");
		
		complete();
	}
}