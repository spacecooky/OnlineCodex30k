package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DENachtrabeJagdbomber extends Eintrag {

    OptionsZaehlerGruppe o1;

	public DENachtrabeJagdbomber() {
		name = "Nachtrabe-Jagdbomber";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/DENachtrabeJagdbomber.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schnitterfeldrakete", 10));
        ogE.addElement(new OptionsGruppeEintrag("Nekrotoxinrakete", 10));
        ogE.addElement(new OptionsGruppeEintrag("Scherbenfeldrakete", 10));
        ogE.addElement(new OptionsGruppeEintrag("Implosionsrakete", 30));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flackerfeld", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
