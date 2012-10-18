package oc.wh40k.units.dm;

import javax.swing.ImageIcon;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class DMSpannaBoyzMob extends Eintrag {

	AnzahlPanel boyz;
	OptionsEinzelUpgrade stikkbombz;
	OptionsEinzelUpgrade wummen;
	OptionsEinzelUpgrade cyborks;
	OptionsEinzelUpgrade mek;
	OptionsUpgradeGruppe mekFK;
	OptionsEinzelUpgrade oiler;
	RuestkammerStarter ScrapTrukk;

	public DMSpannaBoyzMob() {

		kategorie = 3;

		name = "Spanna Boyz";

		grundkosten = 0;
		
		

		boyz = new AnzahlPanel(ID, randAbstand, cnt, "Boyz", 10, 20, 6);

		add(boyz);




		add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

		seperator();





		wummen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shootas", 0, boyz.getModelle());

		add(wummen);

		seperator(5);



		cyborks = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cybork Bodies", 3, boyz.getModelle());

		add(cyborks);
		


		stikkbombz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombz", 1, boyz.getModelle());

		add(stikkbombz);

		seperator();

		
		mek = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mek", 10);

		add(mek);


		seperator(5);


		ogE.addElement(new OptionsGruppeEintrag("Burna", 10));

		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		
		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		
		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 10));


		mekFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE);

		add(mekFK);

		seperator(5);





		add(oiler = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grot Oiler", 5));

		seperator();



		ScrapTrukk = new RuestkammerStarter(ID, randAbstand, cnt, "DMScrapTrukkKammer", "Scrap Trukk");

		ScrapTrukk.initKammer();

		add(ScrapTrukk);





		complete();



	}

	public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgeführt. Dafr wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt

		
		if(cyborkBool){
			BuildaHQ.addToInformationVector("Cyborks", -1);
		}
		
		super.deleteYourself();

	}
	
	boolean cyborkBool = false;
	
	boolean wummenBild = false;

	@Override
	public void refreshen() {



		mekFK.setAktiv(mek.isSelected());

		oiler.setAktiv(mek.isSelected());

		stikkbombz.setModelle(boyz.getModelle());

		cyborks.setModelle(boyz.getModelle());

		ScrapTrukk.setAktiv(boyz.getModelle() <= 12);



		if (wummen.isSelected() == true && wummenBild == false) {

			String icon = "oc/wh40k/images/Ballaboy.gif";

			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			wummenBild = true;
		}



		if (wummen.isSelected() == false && wummenBild == true) {

			String icon = "oc/wh40k/images/Moschaboy.gif";

			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			wummenBild = false;
		}

 
		if (cyborkBool != cyborks.isSelected()) {

			cyborkBool = !cyborkBool;

			if (cyborkBool) {

				BuildaHQ.addToInformationVector("Cyborks", 1);
			} else {

				BuildaHQ.addToInformationVector("Cyborks", -1);
			}

			RefreshListener.fireRefresh();

		}
		
		cyborks.setLegal(BuildaHQ.getCountFromInformationVector("Cyborks")<=BuildaHQ.getCountFromInformationVector("DMPainBoss") || !cyborks.isSelected());

		if(BuildaHQ.getCountFromInformationVector("DMPainBoss")==0){
			cyborks.setAktiv(false);
		}
		else{
			cyborks.setAktiv(true);
		}
	}
}
