package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKImperium extends BuildaVater {

	public static int JAEGER = 0;
	public static int FLAGELANTEN = 0;
	
	public VOLKImperium() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "IM";
		
		JAEGER = 0;
		FLAGELANTEN = 0;
		
		String[] Kommandanten = {"", BuildaHQ.translate("Erzlektor des Sigmar"), BuildaHQ.translate("General des Imperiums"), BuildaHQ.translate("Großmeister der Ordensritter"), BuildaHQ.translate("Meisterzauberer"), " ", BuildaHQ.translate("Karl Franz"), BuildaHQ.translate("Großtheognist Volkmar"), BuildaHQ.translate("Balthasar Gelt"), BuildaHQ.translate("Kurt Helborg")};
		String[] Helden = {"", BuildaHQ.translate("Hauptmann"), BuildaHQ.translate("Kampfzauberer"), BuildaHQ.translate("Meistertechnikus"), BuildaHQ.translate("Sigmarpriester"), " ", BuildaHQ.translate("Luthor Huss"), BuildaHQ.translate("Ludwig Schwarzhelm")};
		String[] Kern = {"", BuildaHQ.translate("Armbrustschützen"), BuildaHQ.translate("Bogenschützen"), BuildaHQ.translate("Hellebardenträger"), BuildaHQ.translate("Jäger"), BuildaHQ.translate("Milliz"), BuildaHQ.translate("Musketenschützen"), BuildaHQ.translate("Ordensritter"), BuildaHQ.translate("Schwertkämpfer"), BuildaHQ.translate("Speerträger")};
		String[] Elite = {"", BuildaHQ.translate("Bihandkämpfer"), BuildaHQ.translate("Großkanone"), BuildaHQ.translate("Mörser"), BuildaHQ.translate("Pistoliere"), BuildaHQ.translate("Ritter des inneren Zirkels"), BuildaHQ.translate("Schützenreiter")};
		String[] Selten = {"", BuildaHQ.translate("Dampfpanzer"), BuildaHQ.translate("Flagellanten"), BuildaHQ.translate("Höllenfeuer Salvenkanone"), BuildaHQ.translate("Höllenfeuer Raketenlafette")};

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
		
		nameDerArtDerArmee = BuildaHQ.translate("Imperium");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Imperium");
		textAreaUeberschrift = BuildaHQ.translate("Imperium");

		complete();
	}

	@Override
	protected void finalize() {
		 
	}

}