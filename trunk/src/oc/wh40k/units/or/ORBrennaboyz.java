package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORBrennaboyz extends Eintrag {

	AnzahlPanel Brennaboyz;
	OptionsEinzelZaehler Mekz;
	OptionsZaehlerGruppe MekzFK;
	OptionsEinzelZaehler Schmiergrot;
	OptionsEinzelUpgrade madDokCybork;

	public ORBrennaboyz() {

		kategorie = 2;



		grundkosten = 0;



		Brennaboyz = new AnzahlPanel(ID, randAbstand, cnt, "Brennaboyz", 5, 15, 15);

		add(Brennaboyz);



		seperator();



		add(ico = new oc.Picture("oc/wh40k/images/Brennaboyz.gif"));



		Mekz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Mekz", 3, 0);

		add(Mekz);



		seperator();



		ogE.addElement(new OptionsGruppeEintrag("Knarre & Spalta", 0));

		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 0));

		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 5));



		MekzFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, Mekz.getAnzahl());

		add(MekzFK);



		seperator();



		Schmiergrot = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Schmiergrot", Mekz.getAnzahl(), 5);

		add(Schmiergrot);



		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Brennaboyz.getModelle()*5));








		complete();

	}

	//@OVERRIDE
	public void refreshen() {



		MekzFK.setMaxAnzahl(Mekz.getAnzahl());

		Schmiergrot.setMaxAnzahl(Mekz.getAnzahl());
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Brennaboyz.getModelle()*5);

	}
}
