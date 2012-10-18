package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKAdeptusSororitas extends BuildaVater {

	public VOLKAdeptusSororitas() {
		reflectionKennung = "AS";
		reflectionKennungAllies = "AS";

		String[] HQeintr�ge = {"", "Principalis", "Celestia-Gefolge", "Konfessor der Ekklesiarchie", "J�nger der Ekklesiarchie", "", "Sankt Celestine", "Erzkonfessor Kyrinov", "Uriah Jacobus"};
		String[] Eliteeintr�ge = {"", "Prediger der Ekklesiarchie", "Celestiatrupp", "Repentiatrupp"};
		String[] Standardeintr�ge = {"", "Sororitastrupp"};
		String[] Sturmeintr�ge = {"", "Seraphimtrupp", "Dominatortrupp",
								  "", "[IA Aeronautica] Aquila Lander", "[IA Aeronautica] Arvus Lighter"};
		String[] Unterst�tzungeintr�ge = {"", "Retributortrupp", "Exorzist", "L�uterer",
										  "", "[IA Aeronautica] Avenger Strike Fighter"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erl�sung"};
		String[] ApoEinheiten = {""};
		String[] ApoFormationen = {"","Schaar der Bu�fertigen","Purgatorschwadron"};
		
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, HQeintr�ge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 2, Eliteeintr�ge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 3, Standardeintr�ge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Sturmeintr�ge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Unterst�tzungeintr�ge));
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
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}
}