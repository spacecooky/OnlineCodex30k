package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerVater;

public class ORSnotzoggaBaddarieKammerSnotlingherde extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelUpgrade madDokCybork;

	public ORSnotzoggaBaddarieKammerSnotlingherde() {
	}

	public void initButtons(boolean... defaults) {
		grundkosten = 0;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Snotlings", 5, 20, 8));

		add(ico = new oc.Picture("oc/wh40k/images/Snotlings.gif"));
		

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Treiba", 1, 10));

		seperator();

		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grotschubsa", 1, 5));

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", squad.getModelle()+1,5));
		
		sizeSetzen();
	}

	    //@OVERRIDE
	    @Override
	    public void refreshen() {
	    	int nmbr=squad.getModelle()/5;
	    	if(squad.getModelle()%5 >0){
	    		nmbr++;
	    	}
	    	
	    	oe1.setMaxAnzahl(nmbr);
			oe1.setAnzahl(nmbr);
			oe2.setMaxAnzahl(nmbr);
	    	
		
			if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
				madDokCybork.setAktiv(true);
				
			} else {
				madDokCybork.setAktiv(false);
				madDokCybork.setSelected(false);
			}
			
			madDokCybork.setPreis((squad.getModelle()+nmbr)*5);
	    }

}
