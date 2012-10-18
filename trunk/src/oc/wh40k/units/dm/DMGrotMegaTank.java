package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DMGrotMegaTank extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;

	public DMGrotMegaTank() {
		name = "Grot Mega Tank";
		kategorie = 4;
		grundkosten = 70;


		add(ico = new oc.Picture("oc/wh40k/images/GrotMegaTank.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("twin Big Shoota", 10));
		ogE.addElement(new OptionsGruppeEintrag("twin Skorcha", 10));
		ogE.addElement(new OptionsGruppeEintrag("twin Grotzooka", 20));
		ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", 20));
		ogE.addElement(new OptionsGruppeEintrag("twin Kustom Mega Blasta", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grotzooka", 10));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shoota", 5));
        
        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wrekkin' Ball", 10));

    	complete();

	}

	public void refreshen() {
		o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
		o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
	}
}
