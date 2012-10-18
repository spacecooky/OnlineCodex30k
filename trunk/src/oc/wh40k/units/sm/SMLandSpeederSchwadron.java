package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class SMLandSpeederSchwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;

	public SMLandSpeederSchwadron() {
		name = "Land Speeder Schwadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Land Speeder", 1, 3, 50);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMLandSpeederSquadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Typhoon-Raketenw.", "Typhoon-Raketenwerfer", 40));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 40));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
		o2.setMaxAnzahl(squad.getModelle());
	}

}
