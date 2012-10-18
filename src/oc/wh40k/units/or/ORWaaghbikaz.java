package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORWaaghbikaz extends Eintrag {

	AnzahlPanel waaghbikaz;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe bossCC;
	OptionsEinzelUpgrade troph�enstange;
	OptionsEinzelUpgrade madDokCybork;

	public ORWaaghbikaz() {

		kategorie = 4;



		grundkosten = 0;



		waaghbikaz = new AnzahlPanel(ID, randAbstand, cnt, "Waaghbikaz", 3, 12, 25);

		add(waaghbikaz);





		add(ico = new oc.Picture("oc/wh40k/images/Waaghbike.gif"));



		seperator();





		boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss", 10);

		add(boss);



		seperator();



		ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));

		ogE.addElement(new OptionsGruppeEintrag("Energiekrall�", 25));



		bossCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE);

		add(bossCC);



		seperator();



		troph�enstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Troph�'enstang�", 5);

		add(troph�enstange);


		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-K�rpa", waaghbikaz.getModelle()*5));




		complete();



	}

	//@OVERRIDE
	public void refreshen() {

		if (!boss.isSelected()) {

			bossCC.setAktiv(false);

			troph�enstange.setAktiv(false);
		} else {

			bossCC.setAktiv(true);

			troph�enstange.setAktiv(true);
		}


		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(waaghbikaz.getModelle()*5);




	}
}
