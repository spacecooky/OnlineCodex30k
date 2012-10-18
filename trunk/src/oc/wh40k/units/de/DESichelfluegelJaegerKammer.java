package oc.wh40k.units.de;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DESichelfluegelJaegerKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o3x;

	public DESichelfluegelJaegerKammer() {}

	public void initButtons(boolean... defaults) {
		name = "Sichelflügel-Jäger";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/DESichelfluegelJaeger.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Schattenlanzen", "2 x flügelmontierte Schattenlanze", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 Schattenkanonen", "2 x flügelmontierte Schattenkanone", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sync. Splittergewehr", "Synchronisiertes Splittergewehr", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splitterkanone", "Splitterkanone", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schnitterfeldrakete", 0));
        add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Nekrotoxinrakete", 5));
        ogE.addElement(new OptionsGruppeEintrag("Scherbenfeldrakete", 5));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flackerfeld", 10));

        sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) {
            o1.setSelected(0, true);
        }
        if(!o2.isSelected()) {
            o2.setSelected(0, true);
        }

        o3x.setMaxAnzahl(4 - o3.getAnzahl());
        o3x.setAnzahl(0, 4 - o3.getAnzahl());
	}

}
