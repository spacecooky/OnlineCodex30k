package oc.whfb.armies;



import java.util.HashMap;
import java.util.Vector;

import javax.swing.JComboBox;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.Chooser;
import oc.ChooserGruppe;

public class VOLKBretonia extends BuildaVater {

	public static HashMap<String, Integer> Vows = null;
	public static int GR = 0;
	public static int RELIQUIE = 0;
	public static int PEGASUSRITTER = 0;
	ChooserGruppe cg1;
	ChooserGruppe cg2;
	public static int AST = 0;
	
	public VOLKBretonia() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "BT";
		
		GR = 0;
		RELIQUIE = 0;
		PEGASUSRITTER = 0;
		AST = 0;
		Vows = new HashMap<String, Integer>();

		String[] Kommandanten = {"", BuildaHQ.translate("Bretonischer Herzog"), BuildaHQ.translate("Dame der Herrin des Sees"), " ", BuildaHQ.translate("Der grüne Ritter"), BuildaHQ.translate("Die Feenzauberin"), "Louen Leoncouer"};
		String[] Helden = {"", "Paladin", BuildaHQ.translate("Maid der Herrin des Sees")};
		String[] Kern = {"", BuildaHQ.translate("Fahrende Ritter"), BuildaHQ.translate("Ritter des Königs")};
		String[] Elite = {"", BuildaHQ.translate("Berittene Knappen"), BuildaHQ.translate("Gralsreliquie"), BuildaHQ.translate("Pegasusritter"), BuildaHQ.translate("Questritter")};
		String[] Selten = {"", BuildaHQ.translate("Gralsritter"), BuildaHQ.translate("Trebuchet")};
		
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, Kommandanten));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(cg1 = new ChooserGruppe(reflectionKennung, cnt, 0, 2, Helden));	
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(cg2 = new ChooserGruppe(reflectionKennung, cnt, 0, 3, Kern));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Elite));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Selten));
		cnt += 480;

		nameDerArtDerArmee = "Bretonia";
		nameDerArtDerArmeeDekliniert = "Bretonia";
		textAreaUeberschrift = "Bretonia";
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
		
		BuildaHQ.refreshEntries(3);
		BuildaHQ.refreshEntries(4);
		
		 if(!oc.OnlineCodex.getInstance().dokumenteContains("Bretonia")) {
			Vector<Chooser> vec = cg1.getmC();
			Chooser c = vec.get(0);
			JComboBox box = c.getComboBox();
			box.setSelectedIndex(1);
			c.erstelleEintrag("Paladin");
			box.getSelectedItem();
			
			/*
			vec = cg2.getmC();
			c = vec.get(0);
			box = c.getComboBox();
			box.setSelectedIndex(2);
			c.erstelleEintrag(BuildaHQ.translate("Ritter des Königs"));
			*/
		}
		
		complete();
	}
}