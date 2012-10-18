package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TLServitorKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public TLServitorKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... löschmichdusau) {
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Servitor", "Servitoren", 1, 5, 15);
		squad.setGrundkosten(-5);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMServitorKammer.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 30));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl((squad.getModelle() > 1 ? 2 : 1));
	}
	
}
