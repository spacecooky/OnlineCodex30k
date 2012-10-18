package oc.whfb.units.og2004;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class OG2004Vielfrasse extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelUpgrade oe;
	
	public OG2004Vielfrasse() {
		name = BuildaHQ.translate("Vielfraﬂe");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Vielfraﬂ"), BuildaHQ.translate("Vielfraﬂe"), 1, 100, 80);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/OGVielfrasse.jpg"));

		seperator();

		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schwere R¸stung"), 4));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ogerkeule"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Cathay-Langschwert"), 6));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 6));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Musketenpaar"), 6));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
	public void refreshen() {
		oe.setPreis(squad.getModelle() * 4);
		o1.setMaxAnzahl(squad.getModelle());
		o1.setLegal(o1.getAnzahl() == squad.getModelle());	
	}
}
