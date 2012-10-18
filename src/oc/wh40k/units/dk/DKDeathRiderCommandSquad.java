package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DKDeathRiderCommandSquad extends Eintrag {

	OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe3;
    OptionsEinzelUpgrade oe4;

	public DKDeathRiderCommandSquad() {
		name = "Death Rider Command Squad";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Company Commander", 0));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Platoon Standard", 15));

		complete();
	}

	@Override
	public void refreshen() {
        oe1.setSelected(true);

        o2.setAktiv(oe3.isSelected());
        oe4.setAktiv(oe3.isSelected());
	}


}
