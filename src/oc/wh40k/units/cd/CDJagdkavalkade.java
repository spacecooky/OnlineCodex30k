package oc.wh40k.units.cd;


import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;;

public class CDJagdkavalkade extends Eintrag {

	OptionsZaehlerGruppe o1;
	
	public CDJagdkavalkade() {

		name = "Jagdkavalkade";
		gesamtpunkteImmerAnzeigen=true;
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/CDBlutdaemon.gif"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Jagdstreitwagen","Jagdstreitwagen des Slaanesh", 40));
		ogE.addElement(new OptionsGruppeEintrag("Erh. Jagdstreitwagen","Erhabener Jagdstreitwagen des Slaanesh", 90));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "",ogE,3));
		
		complete();

	}

	@Override
	public void refreshen() {
		o1.setLegal(o1.isSelected());
	}
}
