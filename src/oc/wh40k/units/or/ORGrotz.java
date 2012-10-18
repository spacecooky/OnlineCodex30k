package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class ORGrotz extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelUpgrade madDokCybork;

	public ORGrotz() {
		kategorie = 3;
		grundkosten = 0;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Grotz", 10, 30, 3));

		add(ico = new oc.Picture("oc/wh40k/images/Grotz.gif"));
		

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Treiba", squad.getModelle() / 10, 10));

		seperator();

		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grotschubsa", squad.getModelle() / 10, 5));

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", (squad.getModelle()+squad.getModelle() / 10)*5));
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle() / 10);
		oe1.setAnzahl(squad.getModelle() / 10);
		oe2.setMaxAnzahl(oe1.getAnzahl());
	
	
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis((squad.getModelle()+squad.getModelle() / 10)*5);
		
	}
}
