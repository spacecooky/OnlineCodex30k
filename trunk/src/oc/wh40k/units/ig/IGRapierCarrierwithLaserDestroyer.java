package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IGRapierCarrierwithLaserDestroyer extends Eintrag {

	OptionsZaehlerGruppe o2;
        AnzahlPanel squad;

	public IGRapierCarrierwithLaserDestroyer() {
                name = "Rapier Carrier with Laser Destroyer";
                grundkosten = 0;                
                
		add(ico = new oc.Picture("oc/wh40k/images/IGChimera.jpg"));
		
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Rapier", "Rapiers", 1, 3, 40));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Additional Crewman", 6));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();
	}

	// @OVERRIDE
	public void refreshen() {
            o2.setMaxAnzahl(squad.getModelle());
	}

}
