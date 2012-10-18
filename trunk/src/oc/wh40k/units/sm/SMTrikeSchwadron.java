package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class SMTrikeSchwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o;

	public SMTrikeSchwadron() {
		name = "Trike-Schwadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Trike", "Trikes", 1, 3, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMTrikeSchwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		complete();
	}

	@Override
	public void refreshen() {
		o.setMaxAnzahl(squad.getModelle());
		o.setLegal(o.getAnzahl() == squad.getModelle());
	}

}
