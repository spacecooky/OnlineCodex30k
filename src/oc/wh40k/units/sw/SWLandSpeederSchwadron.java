package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class SWLandSpeederSchwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsZaehlerGruppe o2;

	public SWLandSpeederSchwadron() {
		name = "Land Speeder Schwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Landspeeder", 1, 3, 50);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWLandSpeederSchwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 40));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon Rak-Werfer", "Typhoon Raketenwerfer", 40));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1x.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
		
		o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
	}

}
