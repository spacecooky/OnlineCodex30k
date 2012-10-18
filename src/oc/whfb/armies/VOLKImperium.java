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
		
		String[] Kommandanten = {"", BuildaHQ.translate("Erzlektor des Sigmar"), BuildaHQ.translate("General des Imperiums"), BuildaHQ.translate("Gro�meister der Ordensritter"), BuildaHQ.translate("Meisterzauberer"), " ", BuildaHQ.translate("Karl Franz"), BuildaHQ.translate("Gro�theognist Volkmar"), BuildaHQ.translate("Balthasar Gelt"), BuildaHQ.translate("Kurt Helborg")};
		String[] Helden = {"", BuildaHQ.translate("Hauptmann"), BuildaHQ.translate("Kampfzauberer"), BuildaHQ.translate("Meistertechnikus"), BuildaHQ.translate("Sigmarpriester"), " ", BuildaHQ.translate("Luthor Huss"), BuildaHQ.translate("Ludwig Schwarzhelm")};
		String[] Kern = {"", BuildaHQ.translate("Armbrustsch�tzen"), BuildaHQ.translate("Bogensch�tzen"), BuildaHQ.translate("Hellebardentr�ger"), BuildaHQ.translate("J�ger"), BuildaHQ.translate("Milliz"), BuildaHQ.translate("Musketensch�tzen"), BuildaHQ.translate("Ordensritter"), BuildaHQ.translate("Schwertk�mpfer"), BuildaHQ.translate("Speertr�ger")};
		String[] Elite = {"", BuildaHQ.translate("Bihandk�mpfer"), BuildaHQ.translate("Gro�kanone"), BuildaHQ.translate("M�rser"), BuildaHQ.translate("Pistoliere"), BuildaHQ.translate("Ritter des inneren Zirkels"), BuildaHQ.translate("Sch�tzenreiter")};
		String[] Selten = {"", BuildaHQ.translate("Dampfpanzer"), BuildaHQ.translate("Flagellanten"), BuildaHQ.translate("H�llenfeuer Salvenkanone"), BuildaHQ.translate("H�llenfeuer Raketenlafette")};

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