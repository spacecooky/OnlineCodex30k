package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKAdeptusSororitas extends BuildaVater {

	public VOLKAdeptusSororitas() {
		reflectionKennung = "AS";
		reflectionKennungAllies = "AS";

		String[] HQeinträge = {"", "Principalis", "Celestia-Gefolge", "Konfessor der Ekklesiarchie", "Jünger der Ekklesiarchie", "", "Sankt Celestine", "Erzkonfessor Kyrinov", "Uriah Jacobus"};
		String[] Eliteeinträge = {"", "Prediger der Ekklesiarchie", "Celestiatrupp", "Repentiatrupp"};
		String[] Standardeinträge = {"", "Sororitastrupp"};
		String[] Sturmeinträge = {"", "Seraphimtrupp", "Dominatortrupp",
								  "", "[IA Aeronautica] Aquila Lander", "[IA Aeronautica] Arvus Lighter"};
		String[] Unterstützungeinträge = {"", "Retributortrupp", "Exorzist", "Läuterer",
										  "", "[IA Aeronautica] Avenger Strike Fighter"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
		String[] ApoEinheiten = {""};
		String[] ApoFormationen = {"","Schaar der Bußfertigen","Purgatorschwadron"};
		
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 2, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 3, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 6, Befestigungen));
		if(oc.OnlineCodex.getInstance().isApo()){ 
            cnt += CHOOSERGRUPPEN_X_ABSTAND;
			adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
			cnt += CHOOSERGRUPPEN_X_ABSTAND;
			adden(new ChooserGruppe(reflectionKennung, cnt, 0, 8, ApoFormationen));
		}
        cnt += 480;

		nameDerArtDerArmee = "Adeptus Sororitas";
		nameDerArtDerArmeeDekliniert = "Adeptus Sororitas";
		textAreaUeberschrift = "Adeptus Sororitas";
		
		noAllies.clear();
		noAllies.add("AS");
		noAllies.add("CD");
		noAllies.add("CM");
		noAllies.add("TY");
		noAllies.add("RH");
		noAllies.add("TL");
		noAllies.add("OR");
		noAllies.add("DM");

		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}
}