package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORWyrdboy extends Eintrag {

	OptionsEinzelUpgrade Warpkopp;
	OptionsEinzelUpgrade madDokCybork;

	public ORWyrdboy() {

		kategorie = 1;



		name = "Wyrdboy";



		grundkosten = 55;



		add(ico = new oc.Picture("oc/wh40k/images/Wyrdboy.gif"));



		seperator();





		Warpkopp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpkopp", 30);

		add(Warpkopp);


		seperator();
			
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", 5));





		complete();



	}

	//@OVERRIDE
	public void refreshen() {
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
	}
}
