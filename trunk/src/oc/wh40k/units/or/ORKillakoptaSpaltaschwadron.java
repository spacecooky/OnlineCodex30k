package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORKillakoptaSpaltaschwadron extends Eintrag {

	AnzahlPanel Killakoptaz;
	OptionsZaehlerGruppe KillakoptazFK;
	OptionsEinzelZaehler Bomb�;
	OptionsEinzelZaehler Turbos�ge;
	OptionsEinzelUpgrade madDokCybork;
	OptionsUpgradeGruppe schwadron;
	OptionsGruppeEintrag schwadron1;
	OptionsGruppeEintrag schwadron2;
	

	public ORKillakoptaSpaltaschwadron() {

		kategorie = 6;
		grundkosten = 0;
		
		Killakoptaz = new AnzahlPanel(ID, randAbstand, cnt, "Killakopta", "Killakoptaz", 6, 2147483647, 35);
		add(Killakoptaz);

		add(ico = new oc.Picture("oc/wh40k/images/Killakoptaz.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Bazzukka", 10));
		ogE.addElement(new OptionsGruppeEintrag("Megablasta", 5));

		KillakoptazFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(KillakoptazFK);

		seperator();

		Bomb� = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Bomb�", 1, 15);
		add(Bomb�);

		Turbos�ge = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Turbos�ge", 1, 25);
		add(Turbos�ge);

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-K�rpa", Killakoptaz.getModelle()*5));

		seperator();
		
		ogE.addElement(schwadron1= new OptionsGruppeEintrag("Spaltaschwadron", 75));
		ogE.addElement(schwadron2= new OptionsGruppeEintrag("Fetter-Spaltaschwadron", 100));
		add(schwadron=new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		
		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		if(Killakoptaz.getModelle()<12){
			schwadron.setSelected(0, true);
			schwadron.setAktiv(1, false);
		} else{
			schwadron.setAktiv(1, true);
		}
		
		KillakoptazFK.setMaxAnzahl(Killakoptaz.getModelle());
		Turbos�ge.setMaxAnzahl(Killakoptaz.getModelle());

		Bomb�.setMaxAnzahl(Killakoptaz.getModelle());
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Killakoptaz.getModelle()*5);
	}
}
