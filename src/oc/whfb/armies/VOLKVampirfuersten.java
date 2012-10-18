package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKVampirfuersten extends BuildaVater {

	public VOLKVampirfuersten() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "VF";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Vampirfürst"), "", BuildaHQ.translate("Vlad von Carstein"), BuildaHQ.translate("Fürst Manfred")};
		String[] Helden = {"", BuildaHQ.translate("Nekromant"), BuildaHQ.translate("Vampir"), BuildaHQ.translate("Fluchfürst"), BuildaHQ.translate("Banshee"), BuildaHQ.translate("Gespenst"), "", BuildaHQ.translate("Manfred der Akolyth"), BuildaHQ.translate("Konrad von Carstein"), BuildaHQ.translate("Isabella von Carstein")};
		String[] Kern = {"", BuildaHQ.translate("Zombiehorde"), BuildaHQ.translate("Skelettkrieger"), BuildaHQ.translate("Gruftghule"), BuildaHQ.translate("Todeswölfe"), BuildaHQ.translate("Fledermausschwarm"), BuildaHQ.translate("Leichenkarren")};
		String[] Elite = {"", BuildaHQ.translate("Verfluchte"), BuildaHQ.translate("Fluchritter"), BuildaHQ.translate("Vampirfledermäuse"), BuildaHQ.translate("Geister")};
		String[] Selten = {"", BuildaHQ.translate("Varghulf"), BuildaHQ.translate("Gespenster"), BuildaHQ.translate("Blutritter"), BuildaHQ.translate("Schwarze Kutsche"), BuildaHQ.translate("Flederbestie")};

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

		nameDerArtDerArmee = BuildaHQ.translate("Vampirfürsten");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Vampirfürsten");
		textAreaUeberschrift = BuildaHQ.translate("Vampirfürsten");

		complete();
	}

	@Override
	protected void finalize() {
		 
	}

}