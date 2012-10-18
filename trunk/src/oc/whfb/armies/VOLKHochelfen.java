package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKHochelfen extends BuildaVater {

	private static boolean ersteUnterGleichen = false;
	
	public VOLKHochelfen() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "HE";
		
		ersteUnterGleichen = false;
		
		String[] Kommandanten = {"", BuildaHQ.translate("Prinz"), BuildaHQ.translate("Erzmagier"), "", BuildaHQ.translate("Tyrion"), BuildaHQ.translate("Teclis"), BuildaHQ.translate("Eltharion"), BuildaHQ.translate("Alith Anar")};
		String[] Helden = {"", BuildaHQ.translate("Edler"), BuildaHQ.translate("Magier"), BuildaHQ.translate("Drachenmagier von Caledor"), "", BuildaHQ.translate("Caradryan"), BuildaHQ.translate("Korhil")};
		String[] Kern = {"", BuildaHQ.translate("Bogenschützen"), BuildaHQ.translate("Speerträger"), BuildaHQ.translate("Seegarde von Lothern")};
		String[] Elite = {"", BuildaHQ.translate("Schwertmeister von Hoeth"), BuildaHQ.translate("Phönixgarde"), BuildaHQ.translate("Weisse Löwen von Chrace"), BuildaHQ.translate("Silberhelme"), 				              BuildaHQ.translate("Drachenprinzen von Caledor"), BuildaHQ.translate("Ellyrianische Grenzreiter"), BuildaHQ.translate("Schattenkrieger"), BuildaHQ.translate("Tiranoc-Streitwagen"), BuildaHQ.translate("Löwenstreitwagen von Chrace")};
		String[] Selten = {"", BuildaHQ.translate("Repetier-Speerschleuder"), BuildaHQ.translate("Riesenadler")};

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
		
		nameDerArtDerArmee = BuildaHQ.translate("Hochelfen");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Hochelfen");
		textAreaUeberschrift = BuildaHQ.translate("Hochelfen");

		complete();
	}

	@Override
	protected void finalize() {
		 
	}

	public static void setErsteUnterGleichen(boolean state) {
		ersteUnterGleichen = state;
	}

	public static boolean isErsteUnterGleichen() {
		return ersteUnterGleichen;
	}

}