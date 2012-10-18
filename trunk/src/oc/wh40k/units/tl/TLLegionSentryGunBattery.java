package oc.wh40k.units.tl;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TLLegionSentryGunBattery extends Eintrag {

	AnzahlPanel SentryGuns;
	OptionsZaehlerGruppe SentryGunsFK;

	public TLLegionSentryGunBattery() {

		kategorie = 4;

		grundkosten = 0;

		SentryGuns = new AnzahlPanel(ID, randAbstand, cnt, "Sentry Gun", "Sentry Guns", 3, 6, 15);
		add(SentryGuns);

		add(ico = new oc.Picture("oc/wh40k/images/TLLegionSentryGunBattery.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("TL heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL lascannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("TL assaultcannon", 20));

		SentryGunsFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3);
		add(SentryGunsFK);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		SentryGunsFK.setMaxAnzahl(SentryGuns.getModelle());
		SentryGunsFK.setLegal(SentryGunsFK.getAnzahl()==SentryGunsFK.getMaxAnzahl());

	}
}
