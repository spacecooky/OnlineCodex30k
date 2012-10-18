package oc.whfb.armies;

import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKGruftkoenigevonKhemri extends BuildaVater {
	
	public VOLKGruftkoenigevonKhemri(){
		reflectionKennung = "GK";
		
		BuildaHQ.Items = new Vector<String>();
		
		String[] Kommandanten = {"", BuildaHQ.translate("Gruftk�nig"), BuildaHQ.translate("Hohenpriester des Todes"), "", BuildaHQ.translate("Settra der Unverg�ngliche"), BuildaHQ.translate("Hochk�nigin Khalida"), BuildaHQ.translate("Arkhan der Schwarze"), BuildaHQ.translate("Grosshierophant Khatep")};
		String[] Helden = {"", BuildaHQ.translate("Gruftprinz"), BuildaHQ.translate("Gruftherold"), BuildaHQ.translate("Priester des Todes"), BuildaHQ.translate("Nekrotekt"), "", BuildaHQ.translate("Nekaph der Herold"), BuildaHQ.translate("Prinz Apophas"), BuildaHQ.translate("Ramhotep der Vision�r") };
		String[] Kern = {"", BuildaHQ.translate("Skelettkrieger"), BuildaHQ.translate("Skelettbogensch�tzen"), BuildaHQ.translate("Skelettreiter"), BuildaHQ.translate("Skelettbogenreiter"), BuildaHQ.translate("Streitwagen")};
		String[] Elite = {"", BuildaHQ.translate("Gruftskorpion"), BuildaHQ.translate("Ushabti"), BuildaHQ.translate("Grabw�chter"), BuildaHQ.translate("Todesgeier"), BuildaHQ.translate("Nekropolenritter"), BuildaHQ.translate("Gruftschwarm"), BuildaHQ.translate("Khemrische Kriegssphinx"), BuildaHQ.translate("Grabj�ger")};
		String[] Selten = {"", BuildaHQ.translate("Nekrolith-Koloss"), BuildaHQ.translate("Hierotitan"), BuildaHQ.translate("Nekrosphinx"), BuildaHQ.translate("Sch�delkatapult"), BuildaHQ.translate("Lade der Verdammten Seelen")};
		
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
		
		nameDerArtDerArmee = BuildaHQ.translate("Gruftk�nige von Khemri");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Gruftk�nige von Khemri");
		textAreaUeberschrift = BuildaHQ.translate("Gruftk�nige von Khemri");
	
		complete();
	}
}
