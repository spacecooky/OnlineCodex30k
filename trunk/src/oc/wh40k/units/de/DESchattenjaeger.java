package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DESchattenjaeger extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;

	public DESchattenjaeger() {
		name = "Schattenjäger";
		grundkosten = 105;

		add(ico = new oc.Picture("oc/wh40k/images/DESchattenjaeger.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schattenlanze", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Schattenkanone", 0));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Schocksporn", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Terrorgas-Granatwerfer", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Verbesserte Äthersegel", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Bremstriebwerke", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fangketten", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Grausige Trophäen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Toxinklingen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flackerfeld", 10));

		complete();
	}

	@Override
	public void refreshen() {
        o1x.setMaxAnzahl(3 - o1.getAnzahl());
        o1x.setAnzahl(0, 3 - o1.getAnzahl());
	}

}
