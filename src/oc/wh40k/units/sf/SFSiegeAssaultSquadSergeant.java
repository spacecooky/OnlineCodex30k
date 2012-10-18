package oc.wh40k.units.sf;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class SFSiegeAssaultSquadSergeant extends RuestkammerVater {
    
	public SFSiegeAssaultSquadSergeant() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombiflammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
