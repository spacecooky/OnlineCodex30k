package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class ORPluenderaSchrottkommandoKammerPluenderaz extends RuestkammerVater {

	AnzahlPanel Pluenderaz;
	OptionsEinzelZaehler Mekz;
	OptionsZaehlerGruppe MekzFK;
	OptionsEinzelZaehler Schmiergrot;
	OptionsEinzelUpgrade madDokCybork;
	
	RuestkammerStarter bigmek;
	
	RuestkammerStarter PikkUp;

	public ORPluenderaSchrottkommandoKammerPluenderaz() {
		
	}

	public void initButtons(boolean... defaults) {
		
		grundkosten = 0;

		Pluenderaz = new AnzahlPanel(ID, randAbstand, cnt, "Pluenderaz", 4, 12, 15);
		add(Pluenderaz);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/Pluenderaz.gif"));
		

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
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Pluenderaz.getModelle()*5));
		seperator();
		
		bigmek = new RuestkammerStarter(ID, randAbstand, cnt, "ORPluenderaSchrottkommandoKammerBigmek", "Bigmek");
		bigmek.initKammer(true);
		add(bigmek);
		
		PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, "ORPikkUpKammer", "Pikk Up");
		PikkUp.initKammer(true);
		add(PikkUp);
		PikkUp.setAbwaehlbar(false);

		sizeSetzen();
	}

	
	@Override
	public void refreshen() {

		MekzFK.setMaxAnzahl(Mekz.getAnzahl());

		Schmiergrot.setMaxAnzahl(Mekz.getAnzahl());
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Pluenderaz.getModelle()*5);
		
		bigmek.setLegal(bigmek.isSelected() || Mekz.getAnzahl()>0 && Pluenderaz.getModelle()>4);
		Mekz.setLegal(bigmek.isSelected() || Mekz.getAnzahl()>0 && Pluenderaz.getModelle()>4);
		
		if(bigmek.isSelected()){
			Pluenderaz.setMaxModelle(11);
		} else {
			Pluenderaz.setMaxModelle(12);
		}

	}
}
