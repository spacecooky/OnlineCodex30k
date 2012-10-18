package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;

public class BASanguinischeGarde extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade banner;

	boolean added = false;

	public BASanguinischeGarde() {
		name = "Sanguinische Garde\n5 Sanguinische Gardisten";
		grundkosten = 200;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/BASanguinischeGarde.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Todesmasken", 25));
		add(banner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ordensbanner", 30));
		banner.setToolTipText("Das Ordensbanner darf nur maximal 1x pro Armee gewählt werden.");

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angelus-Bolter", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Karmesinklinge", "Karmesinrote Klinge", 0));
		add(o2def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		complete();
	}

	@Override
	public void refreshen() {
		o1def.setMaxAnzahl(5 - o1.getAnzahl());
		o1def.setAnzahl(0, 5 - o1.getAnzahl());

		o2def.setMaxAnzahl(5 - o2.getAnzahl());
		o2def.setAnzahl(0, 5 - o2.getAnzahl());

		if (!added && banner.isSelected()) {
			BuildaHQ.addToInformationVector("BAOrdensbanner", 1);
			added = true;
			RefreshListener.fireRefresh();
		} else if (added && !banner.isSelected()) {
			BuildaHQ.addToInformationVector("BAOrdensbanner", -1);
			added = false;
			RefreshListener.fireRefresh();
		}

		banner.setLegal(BuildaHQ.getCountFromInformationVector("BAOrdensbanner") < 2);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		if(banner.isSelected()) {
			BuildaHQ.addToInformationVector("BAOrdensbanner", -1);
		}
	}

}
