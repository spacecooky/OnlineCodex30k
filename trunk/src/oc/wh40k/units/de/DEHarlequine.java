package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DEHarlequine extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsUpgradeGruppe o3;

	public DEHarlequine() {
		name = "Harlequin-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Harlequine", 5, 10, 18);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEHarlequine.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Harlequin-Peitsche", 4));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fusionspistole", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Todesjoker", "Upgrade zum Todesjoker mit Kreischerkanone", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Schicksalsleser", "Upgrade zum Schicksalsleser", 30));

        ogE.addElement(new OptionsGruppeEintrag("Meistermime (E-Waffe)", "Upgrade zum Meistermime mit Energiewaffe", 20));
        ogE.addElement(new OptionsGruppeEintrag("Meistermime (Peitsche)", "Upgrade zum Meistermime mit Harlequinpeitsche", 20));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle() - (o3.isSelected() ? 1 : 0));
	}

}
