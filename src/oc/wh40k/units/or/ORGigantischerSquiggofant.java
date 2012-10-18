package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORGigantischerSquiggofant extends Eintrag {

    OptionsEinzelZaehler o1;
    OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade madDokCybork;

	public ORGigantischerSquiggofant() {
		name = "Gigantischer Squiggofant";
		grundkosten = 600;


		add(ico = new oc.Picture("oc/wh40k/images/GigantischerSquiggofant.gif"));
		

        add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "fette Wumme", 4, 10));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Supa-lobba", 0));
        ogE.addElement(new OptionsGruppeEintrag("Killkannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Big-Zzapa", 15));
        add(o2 =new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", 5));


		complete();

	}

	public void refreshen() {
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
		
	}
}
