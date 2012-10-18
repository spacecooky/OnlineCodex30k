package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELRunenprophet extends Eintrag {

	AnzahlPanel Runenprophet;
	OptionsEinzelUpgrade boss1;
	OptionsEinzelUpgrade boss2;
	OptionsEinzelUpgrade boss3;
	OptionsEinzelUpgrade boss4;
	OptionsEinzelUpgrade boss5;
	OptionsUpgradeGruppe oG;

	public ELRunenprophet() {

		name = "Runenprophet";

		grundkosten = 55;



		add(ico = new oc.Picture("oc/wh40k/images/Runenprophet.gif"));

		seperator();

		boss1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runenspeer", 3);
		add(boss1);

		boss2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runen der Vorhersehung", 15);
		add(boss2);

		boss3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runen der Klarheit", 10);
		add(boss3);

		boss4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seelensteine", 20);
		add(boss4);

		boss5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eldar-Jetbike", 30);
		add(boss5);

		seperator(15);

		ogE.addElement(new OptionsGruppeEintrag("Verdammnis", 25));
		ogE.addElement(new OptionsGruppeEintrag("Psisturm", 20));
		ogE.addElement(new OptionsGruppeEintrag("Gunst des Schicksals", 30));
		ogE.addElement(new OptionsGruppeEintrag("Runenblick", 20));
		ogE.addElement(new OptionsGruppeEintrag("Mentales Duell", 20));
		oG = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 4);
		add(oG);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		oG.setLegal(oG.getAnzahl() > 0); // mind. 1
		
		if(BuildaHQ.getCountFromInformationVector("ELBelAnnath")>0){
			setFehlermeldung("Keine Runenpropethen!");
        }else{
        	setFehlermeldung("");
        }
	}
}
















