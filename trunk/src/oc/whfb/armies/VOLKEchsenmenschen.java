package oc.whfb.armies;



import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKEchsenmenschen extends BuildaVater {

	public VOLKEchsenmenschen() {
		BuildaHQ.Items = new Vector<String>();
		
		reflectionKennung = "EM";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Slann Magierpriester"), BuildaHQ.translate("Saurus Hornnackenveteran"), "", BuildaHQ.translate("Lord Kroak"), BuildaHQ.translate("Lord Mazdamundi"), BuildaHQ.translate("Kroq Gar"), BuildaHQ.translate("Tehenhauin") };
		String[] Helden = {"", BuildaHQ.translate("Saurus Hornnacken"), BuildaHQ.translate("Skink Häuptling"), BuildaHQ.translate("Skink-Schamane"), "", BuildaHQ.translate("Chakax"), BuildaHQ.translate("Gor Rok"), BuildaHQ.translate("Tetto Eko"), BuildaHQ.translate("TikTaq To"), BuildaHQ.translate("Oxyotl")};
		String[] Kern = {"", BuildaHQ.translate("Sauruskrieger"), BuildaHQ.translate("Skink Plänkler"), BuildaHQ.translate("Skinks"), BuildaHQ.translate("Dschungelschwarm")};
		String[] Elite = {"", BuildaHQ.translate("Sauruskavallerie"), BuildaHQ.translate("Kroxigore"), BuildaHQ.translate("Stegadon"), BuildaHQ.translate("Teradonreiter"), BuildaHQ.translate("Chamäleonskinks"), BuildaHQ.translate("Tempelwache")};
		String[] Selten = {"", BuildaHQ.translate("Ehrwürdiges Stegadon"), BuildaHQ.translate("Salamander Jagdrudel"), BuildaHQ.translate("Stachelsalamander Jagdrudel")};

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

		nameDerArtDerArmee = BuildaHQ.translate("Echsenmenschen");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Echsenmenschen");
		textAreaUeberschrift = BuildaHQ.translate("Echsenmenschen");

		complete();
	}

	@Override
	protected void finalize() {
		 
	}

}