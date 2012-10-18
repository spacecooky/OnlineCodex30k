package oc.whfb.armies;




import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKOger extends BuildaVater {

	public VOLKOger() {
		reflectionKennung = "OG";
		
		String[] Kommandanten = {"", BuildaHQ.translate("Tyrann"), BuildaHQ.translate("Fleischermeister"), "", BuildaHQ.translate("Skrag der Schlächter"), BuildaHQ.translate("Speckus Goldzahn")};
		String[] Helden = {"", BuildaHQ.translate("Brecher"), BuildaHQ.translate("Jäger"), BuildaHQ.translate("Fleischer"), BuildaHQ.translate("Feuerbauch"), "", BuildaHQ.translate("Golgfag Vielfrass"), BuildaHQ.translate("Bragg der Ausweider")};
		String[] Kern = {"", BuildaHQ.translate("Oger"), BuildaHQ.translate("Eisenwänste"), BuildaHQ.translate("Gnoblars")};
		String[] Elite = {"", BuildaHQ.translate("Bleispucker"), BuildaHQ.translate("Vielfrasse"), BuildaHQ.translate("Säbelzahnrudel"), BuildaHQ.translate("Yhetis"), BuildaHQ.translate("Trauerfangkavallerie"), BuildaHQ.translate("Verschlinger")};
		String[] Selten = {"", BuildaHQ.translate("Gnoblar Schrottschleuder"), BuildaHQ.translate("Eisenspeier"), BuildaHQ.translate("Riese"), BuildaHQ.translate("Steinyak"), BuildaHQ.translate("Donnerhorn")};

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
		
		nameDerArtDerArmee = BuildaHQ.translate("Ogerkönigreiche");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Ogerkönigreiche");
		textAreaUeberschrift = BuildaHQ.translate("Ogerkönigreiche");

		complete();
	}

	@Override
	protected void finalize() {
		 
	}

}