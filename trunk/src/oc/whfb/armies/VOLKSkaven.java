package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKSkaven extends BuildaVater {
	
	public static int GLOBARDIERS = 0;
	public static int GLOBARDIERSWT = 0;
	public static int GUTTERRUNNERS = 0;
	public static int GUTTERRUNNERSWT = 0;
	public static int RO = 0;
	
	public VOLKSkaven() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "SK";
		
		GLOBARDIERS = 0;
		GLOBARDIERSWT = 0;
		GUTTERRUNNERS = 0;
		GUTTERRUNNERSWT = 0;
		RO = 0;
		
		String[] Kommandanten = {"", BuildaHQ.translate("Rattendämon"), BuildaHQ.translate("Kriegsherr"), BuildaHQ.translate("Grauer Prophet"), "", BuildaHQ.translate("Seuchenherrscher Skrolk"), BuildaHQ.translate("Thanquol"), BuildaHQ.translate("Ikit Krallenhand"), BuildaHQ.translate("Skrotz der Mutant"), BuildaHQ.translate("Queek Kopfjäger")};
		String[] Helden = {"", BuildaHQ.translate("Häuptling"), BuildaHQ.translate("Seuchenpriester"), BuildaHQ.translate("Warlocktechniker"), BuildaHQ.translate("Assassine"), " ", BuildaHQ.translate("Tretch Feigschwanz"), BuildaHQ.translate("Meisterassassine Snikch")};
		String[] Kern = {"", BuildaHQ.translate("Klanratten"), BuildaHQ.translate("Sturmratten"), BuildaHQ.translate("Skavensklaven"), BuildaHQ.translate("Schattenläufer"), BuildaHQ.translate("Riesenratten"), BuildaHQ.translate("Rattenschwarm")};
		String[] Elite = {"", BuildaHQ.translate("Gossenläufer"), BuildaHQ.translate("Rattenoger"), BuildaHQ.translate("Seuchenschleuderer"), BuildaHQ.translate("Jezzails"), BuildaHQ.translate("Giftwindkrieger")};
		String[] Selten = {"", BuildaHQ.translate("Höllengrubenbrut"), BuildaHQ.translate("Todesrad"), BuildaHQ.translate("Warpblitzkanone"), BuildaHQ.translate("Seuchenklauenkatapult")};
		
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

		nameDerArtDerArmee = BuildaHQ.translate("Skaven");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Skaven");
		textAreaUeberschrift = BuildaHQ.translate("Skaven");
		
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Seuchenmönche"));		
		
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Seuchenmönche"));
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Kern Rattenoger"));
		
		complete();
	}
}