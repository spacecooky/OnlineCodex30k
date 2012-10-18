package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKWaldelfen extends BuildaVater {

	public VOLKWaldelfen() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "WE";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Hochgeborener"), BuildaHQ.translate("Zauberweber"), BuildaHQ.translate("Baumältester"), "", BuildaHQ.translate("Naestra and Arahan - Sisters of Twilight")};
		String[] Helden = {"", BuildaHQ.translate("Adliger"), BuildaHQ.translate("Zaubersänger"), BuildaHQ.translate("Erinnye")};
		String[] Kern = {"", BuildaHQ.translate("Dryaden")};
		String[] Elite = {"", BuildaHQ.translate("Baumschrate")};
		String[] Selten = {"", BuildaHQ.translate("Baummensch")};

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
		
		

		nameDerArtDerArmee = BuildaHQ.translate("Waldelfen");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Waldelfen");
		textAreaUeberschrift = BuildaHQ.translate("Waldelfen");

		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
		
		//Orion
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkrieger"));
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkundschafter"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Kurnous Wilde Jagd"));
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl(BuildaHQ.translate("Waldläufer"));
		
		//Drycha
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldreiter"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Kampftänzer"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Falkenreiter"));
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl(BuildaHQ.translate("Riesenadler"));
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl(BuildaHQ.translate("Orion, the King in the Woods"));
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl(BuildaHQ.translate("Drycha"));
		
		complete();
	}

	@Override
	protected void finalize() {
		 
	}

}