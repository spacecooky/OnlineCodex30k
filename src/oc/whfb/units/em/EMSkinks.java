package oc.whfb.units.em;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class EMSkinks extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;	
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;

	public EMSkinks() {
		name = BuildaHQ.translate("Skinks");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Skinks"), 10, 100, 5);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/EMSkinks.jpg"));

		seperator();


		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 8));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 8));

		seperator();
		
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kroxigore"), 55));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));


		complete();
	}

	@Override
	public void refreshen() {
		
		int skinks = squad.getModelle();
		int allowedKroxigore = skinks/8;
		
		
		if(allowedKroxigore < o2.getMaxAnzahl()){
			if(o2.getAnzahl() == o2.getMaxAnzahl()){
				o2.setAnzahl(0, o2.getAnzahl()-1);
				o2.setMaxAnzahl(allowedKroxigore);
			}else{
				o2.setMaxAnzahl(allowedKroxigore);				
			}
		}
		o2.setMaxAnzahl(allowedKroxigore);
	}

}
