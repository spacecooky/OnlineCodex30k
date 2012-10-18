package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RHSentryGunBattery extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public RHSentryGunBattery() {
		name = "Sentry Gun Battery";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Tarantula Sentry", "Tarantula Sentries", 1, 3, 15);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/RHSentryGunBattery.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("TL heavy bolters","Twin-linked heavy bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL lascannons","Twin-linked lascannons", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1.setLegal(o1.getAnzahl()==o1.getMaxAnzahl());
	}

}
