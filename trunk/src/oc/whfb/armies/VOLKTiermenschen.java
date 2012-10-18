package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKTiermenschen extends BuildaVater {
	
	public static int GHORROS = 0;
	
	public VOLKTiermenschen() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "BDC";
		
		GHORROS = 0;
		
		String[] Kommandanten = {"", BuildaHQ.translate("Großhäuptling"), BuildaHQ.translate("Todesbulle"),BuildaHQ.translate("Großschamane"), "", BuildaHQ.translate("Khazrak der Einäugige"), BuildaHQ.translate("Gorthor, der Bestienherrscher"), BuildaHQ.translate("Malagor, das dunkle Omen"), BuildaHQ.translate("Taurox, der Messingbulle")};
		String[] Helden = {"", BuildaHQ.translate("Häuptling"), BuildaHQ.translate("Sturmbulle"), BuildaHQ.translate("Schamane"), "", BuildaHQ.translate("Morghur, der Schädelmeister"), BuildaHQ.translate("Schneckenzunge"), BuildaHQ.translate("Mondklaue, Sohn des Morrslieb")};
		String[] Kern = {"", BuildaHQ.translate("Gor Herde"), BuildaHQ.translate("Ungor Herde"), BuildaHQ.translate("Ungor Plünderer"), BuildaHQ.translate("Tuskgor Streitwagen"), BuildaHQ.translate("Chaoshunde")};
		String[] Elite = {"", BuildaHQ.translate( "Minotauren"), BuildaHQ.translate("Harpyien"), BuildaHQ.translate("Bestigor Herde"), BuildaHQ.translate("Gnargor Streitwagen"), BuildaHQ.translate("Gnargor Herde")};
		String[] Selten = {"", BuildaHQ.translate("Zygor"), BuildaHQ.translate("Ghorgor"), BuildaHQ.translate("Riese"), BuildaHQ.translate("Chaosbrut"), BuildaHQ.translate("Grinderlak")};

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
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Ghorros Kriegshuf"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Centigor"));
		
		nameDerArtDerArmee = BuildaHQ.translate("Tiermenschen");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Tiermenschen");
		textAreaUeberschrift = BuildaHQ.translate("Tiermenschen");

		complete();
	}

	
}