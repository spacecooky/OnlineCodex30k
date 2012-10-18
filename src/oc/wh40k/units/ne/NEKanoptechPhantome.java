package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class NEKanoptechPhantome extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;

	public NEKanoptechPhantome() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Kanoptech-Phantom", "Kanoptech-Phantome", 1, 6, 35);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechPhantome.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Partikelwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Fesselspulen", 10));
		ogE.addElement(new OptionsGruppeEintrag("Transdim.-Strahler", "Transdimensionsstrahler", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		complete();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
	}

}
